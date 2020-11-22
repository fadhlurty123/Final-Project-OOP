/* 
Anggota Kelompok    : - Leonardo Septian Dwigantoro - 140810190038
                      - Johannes Gavin              - 140810190066
                      - Fahrul Thariq Fadillah      - 140810190074
Kelas         : B
Tanggal       : Minggu,  22 November 2020
Deskripsi     : 
*/

import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Color;

public class FifteenPuzzle {
 private int n;       //variable n

 public FifteenPuzzle(int n) {  //setter
  this.n = n;
 }

 public int getN() {     //getter
  return n;
 }

 public void setN(int n) {   //fungsi n
  this.n = n;
 }

 public static void main(String args[]) {
  /*membuat scanner object*/
  FifteenPuzzle dataN = new FifteenPuzzle(4);
  Scanner inputN = new Scanner(System.in);
  JFrame frame = new JFrame();

  /*menset warna dan besar background*/
  frame.setBackground(Color.BLUE);
  frame.setResizable(true);
  frame.setSize(450, 450);
  
  /*input besaran daripada grid*/
  System.out.print("Masukan besaran grid : ");
  int besarGrid = inputN.nextInt();

  /*menampilkan inputan besaran greed*/
  dataN.setN(besarGrid);
  System.out.println("Besaran grid adalah : " + dataN.getN());

  inputN.close(); //close method

 }
}