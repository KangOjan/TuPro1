/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
Nama   : Fauzan Ramadhan
NIM    : 1301168591
Kelas  : IF-39-10
Tujuan : Aplikasi ini untuk membantu menemukan nilai minimal dari sebuah fungsi 
         dengan menggunakan algoritma Simulated Annealing (SA)
 */
package SimulatedAnnealing;

/**
 *
 * @author fznrm
 */
public class iterasi {

    //inisialisasi nilai awal alpha dan Tawal
    private static final double alpha = 0.98;
    double Tawal = 10000000;
    double Takhir = 1;

    double x1, x2, currentState, newState, deltaE, r, peluang, bestOfFar;

    //instansiasi kelas operasi untuk menggunakan method yang ada di kelas operasi
    operasi op = new operasi();

    public void iterasiSA() {

        //inisialisasi nilai x1, x2 dan current state awal
        x1 = operasi.randomInRange((-10), 10);
        x2 = operasi.randomInRange((-10), 10);
        currentState = op.hasil(x1, x2);
        bestOfFar = currentState;

        //melakukan perulangan sampai Tawal sama dengan atau lebih kecil dari Takhir
        while (Tawal > Takhir) {
            //inisialisasi nilai x1 dan x2 yang baru dan new state nya
            double x1new = operasi.randomInRange((-10), 10);
            double x2new = operasi.randomInRange((-10), 10);
            newState = op.hasil(x1new, x2new);

            //mencari selisih new state dan current state
            deltaE = currentState - newState;
            if (deltaE > 0) {
                //jika new state lebih kecil dari current state, maka 
                //nilai current state diganti oleh new state
                //x1 diganti dengan x1new
                //x2 diganti dengan x2new
                

                if (currentState > newState) {
                    currentState = newState;
                    x1 = x1new;
                    x2 = x2new;
                }

                //jika new state lebih besar dari current state, maka
                //dicari peluangnya
            } else {
                peluang = Math.exp((-deltaE) / Tawal);
                r = operasi.randomInRange(0, 1);
                if (r < peluang) {
                   

                    if (currentState > newState) {
                         currentState = newState;
                        x1 = x1new;
                        x2 = x2new;
                    }
                }
            }
            //setting ulang nilai Tawal setelah dikalikan dengan nilai alpha
            Tawal = Tawal * alpha;
        }
        System.out.println("Nilai X1 : " + x1);
        System.out.println("Nilai X2 : " + x2);
//        System.out.println("Best Of Far adalah : " + bestOfFar);
        System.out.println("Nilai terakhir : " + currentState);
    }
}
