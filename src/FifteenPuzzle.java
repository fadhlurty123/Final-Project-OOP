/* 
Anggota Kelompok    : - Leonardo Septian Dwigantoro - 140810190038
                      - Johannes Gavin              - 140810190066
                      - Fahrul Thariq Fadillah      - 140810190074
Kelas         : B
Tanggal       : Sabtu,  28 November 2020 [UPDATE-2]
Deskripsi     : Main class FifteenPuzzle
*/

import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Color;

public class FifteenPuzzle {
    public static void main(String args[]) {
        // intansiasi objek
        Scanner inputN = new Scanner(System.in);
        JFrame frame = new JFrame();

        // mengatur warna dan besar background
        frame.setBackground(Color.BLUE);
        frame.setResizable(true);
        frame.setSize(450, 450);

        // input besaran grid
        System.out.print("Masukan besaran grid : ");
        int besarGrid = inputN.nextInt();
        System.out.print("Besar grid yang digunakan adalah : " + besarGrid);

        // close method
        inputN.close();

    }
}