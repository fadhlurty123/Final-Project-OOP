/* 
Anggota Kelompok    : - Leonardo Septian Dwigantoro - 140810190038
                      - Johannes Gavin              - 140810190066
                      - Fahrul Thariq Fadillah      - 140810190074
Kelas               : B
Tanggal             : Minggu,  22 November 2020
Deskripsi           : class Fungsi dalam gim FifteenPuzzle
*/

import javax.swing.JPanel;
import javax.swing.JButton;

public class Fungsi extends JPanel {
  // variable untuk menentukan jumlah Baris,Kolom,dan Sel
  int jumlahBaris, jumlahKolom, jumlahSel;
  JButton[][] reaksi;

  private int perhitunganInversion() {
    /*
     * Fungsi untuk menghitung inversi yang diberikan
     */
    int[] vals = new int[jumlahSel];
    int pos = 0;
    int jumlahInversion = 0;
    for (int i = 0; i < jumlahBaris; i++)
      for (int j = 0; j < jumlahKolom; j++) {
        if (reaksi[i][j].isVisible())
          vals[pos++] = Integer.parseInt(reaksi[i][j].getText());
      }
    for (int i = 0; i < jumlahSel - 2; i++)
      for (int j = i + 1; j < jumlahSel - 1; j++)
        if (vals[i] > vals[j])
          jumlahInversion++;
    return jumlahInversion;
  }

  private boolean isSolved() {
    /*
     * fungsi untuk mengecek apakah game sudah terselesaikan atau belum
     */
    int val = 1, i, j = 0;
    if (reaksi[jumlahBaris - 1][jumlahKolom - 1].isVisible())
      return false;
    label: {
      for (i = 0; i < jumlahBaris; i++)
        for (j = 0; j < jumlahKolom; j++) {
          if (!reaksi[i][j].isVisible() || Integer.parseInt(reaksi[i][j].getText()) != val++)
            break label;
        }
    }
    if (i == jumlahBaris - 1 && j == jumlahKolom - 1)
      return true;
    return false;
  }

}