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

import java.util.Random;

/**
 *
 * @author fznrm
 */
public class operasi {

    protected static Random random = new Random();

    //method function untuk melakukan fungsi random
    public static double randomInRange(double min, double max) {
        double range = max - min;
        double scaled = random.nextDouble() * range;
        double shifted = scaled + min;
        return shifted;
    }

    //method function untuk melakukan operasi dari fungsi bagian ke 1
    public double operasi1(double x1, double x2) {
        return (4 - (2.1 * Math.pow(x1, 2)) + (Math.pow(x1, 4) / 3)) * Math.pow(x1, 2);
    }

    //method function untuk melakukan operasi dari fungsi bagian ke 2
    public double operasi2(double x1, double x2) {
        return (x1 * x2);
    }

    //method function untuk melakukan operasi dari fungsi bagian ke 3
    public double operasi3(double x1, double x2) {
        return ((-4 + (4 * Math.pow(x1, 2))) * Math.pow(x2, 2));
    }

    //method function untuk melakukan operasi dari fungsi yang diberikan
    public double hasil(double x1, double x2) {
        return operasi1(x1, x2) + operasi2(x1, x2) + operasi3(x1, x2);
//        return (4 - (2.1 * Math.pow(x1, 2)) + (Math.pow(x1, 4) / 3)) * Math.pow(x1, 2) + (x1 * x2) + ((-4 + (4 * Math.pow(x1, 2))) * Math.pow(x2, 2));
    }
}
