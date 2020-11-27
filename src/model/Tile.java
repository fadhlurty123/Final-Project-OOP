/* 
Anggota Kelompok    : - Leonardo Septian Dwigantoro - 140810190038
                      - Johannes Gavin              - 140810190066
                      - Fahrul Thariq Fadillah      - 140810190074
Kelas               : B
Tanggal             : Jumat,  27 November 2020 [UPDATE-0]
Deskripsi           : Class Tile untuk menentukan ubin pada gim FifteenPuzzle
*/
package model;

public class Tile {
    // Deklarasi variabel
    private int row;
    private int col;
    private String value;

    // setter Tile
    public Tile(int row, int col, String value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    // getter getCol
    public int getCol() {
        return col;
    }

    // getter getROW
    public int getRow() {
        return row;
    }

    // getter getValue
    public String getValue() {
        return value;
    }

    // setter setRow
    public void setCol(int col) {
        this.col = col;
    }

    // setter setRow
    public void setRow(int row) {
        this.row = row;
    }

    // setter setValue
    public void setValue(String value) {
        this.value = value;
    }

    // getter isEmptyTile
    public boolean isEmptyTile() {
        return this.value.isEmpty();
    }

    // getter isOnRightPosition
    public boolean isOnRightPosition(int row, int col) {
        return this.row == row && this.col == col;
    }

}
