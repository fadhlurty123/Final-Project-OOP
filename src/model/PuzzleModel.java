/* 
Anggota Kelompok    : - Leonardo Septian Dwigantoro - 140810190038
                      - Johannes Gavin              - 140810190066
                      - Fahrul Thariq Fadillah      - 140810190074
Kelas               : B
Tanggal             : Sabtu,  28 November 2020 [UPDATE-0]
Deskripsi           : Class PuzzleModel untuk menentukan fungsi-fungsi dalam ubin pada gim FifteenPuzzle
*/
package model;

import java.util.Random;

public class PuzzleModel {

    // Deklarasi 2D array sebagai panjang dan lebar Puzzle
    private Tile[][] tiles;
    private Tile emptyTile;
    private int squareSize;

    public PuzzleModel() {
    }

    // setter PuzzleModel
    public PuzzleModel(int squareSize) {
        this.squareSize = squareSize;
        tiles = new Tile[squareSize][squareSize];
    }

    // getter Tile
    public Tile[][] getTiles() {
        return tiles;
    }

    // setter setTiles
    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    // getter getEmptyTile
    public Tile getEmptyTile() {
        return emptyTile;
    }

    // setter setEmptyTile
    public void setEmptyTile(Tile emptyTile) {
        this.emptyTile = emptyTile;
    }

    // getter getSquareSize
    public int getSquareSize() {
        return squareSize;
    }

    // setter setSquareSize
    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }

    // getter getTile
    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    /*
     * Method generateBlock digunakan untuk membuat block baru dan me-reset blok
     */
    public void generateBlock() {
        for (int row = 0; row < squareSize; row++) {
            for (int col = 0; col < squareSize; col++) {
                tiles[row][col] = new Tile(row, col, "" + (row * squareSize + col + 1));
            }
        }
        tiles[squareSize - 1][squareSize - 1].setValue("");
        emptyTile = new Tile(squareSize - 1, squareSize - 1, "");
    }

    /**
     * Method shuffleBlock untuk ngatur ulang puzzle
     */
    public void shuffleBlock() {
        for (int row = 0; row < squareSize; row++) {
            for (int col = 0; col < squareSize; col++) {
                int newRow = new Random().nextInt(squareSize);
                int newCol = new Random().nextInt(squareSize);
                exchangeTile(row, col, newRow, newCol);
            }
        }
    }

    /**
     * Method isSolvable untuk mengecek apakah puzzle dapat diselesaikan atau tidak
     */
    public boolean isSolvable() {
        int[] tempTile = new int[squareSize * squareSize];
        int index = 0;

        // membuat sebuah array 1D yang berisi semua tile terlebih dahulu
        for (int row = 0; row < squareSize; row++) {
            for (int col = 0; col < squareSize; col++) {
                if (tiles[row][col].isEmptyTile()) {
                    tempTile[index++] = 0;
                } else {
                    tempTile[index++] = Integer.parseInt(tiles[row][col].getValue());
                }
            }
        }

        // menghitung jumlah angka dengan inversi
        int inversion = 0;
        for (int i = 0; i < tempTile.length; i++) {
            for (int j = i; j < tempTile.length; j++) {
                if (tempTile[i] > tempTile[j] && tempTile[j] != 0) {
                    inversion++;
                }
            }
        }

        // kondisi 1: jika ukuran kotak adalah ganjil
        if (squareSize % 2 != 0) {
            // jika inversi genap, maka puzzle bisa diselesaikan
            return inversion % 2 == 0;
        }

        // kondisi 2: jika ukuran kotak genap maka jumlah inversi dan angka dalam baris 
        // dari tile kosong menjadi genap, jadi puzzle bisa diselesaikan
        // ditambah dengan satu tile karena emptyTile.getRow() dimulai dari 0
        return (inversion + emptyTile.getRow() + 1) % 2 == 0;
    }

    /**
     * Method exchangeTile digunakan untuk menukar tile dengan aturan: Parameter
     * firstRow mengisi baris pertama tile, Parameter firstCol mengisi kolom pertama
     * tile, Parameter SecondRow mengisi baris kedua tile, Parameter SecondCol
     * mengisi kolom kedua tile dengan menukar dua tile.
     */
    public void exchangeTile(int firstRow, int firstCol, int secondRow, int secondCol) {
        // pertama, update baris dan kolom dengan emptyTile sebelum menukar tile jika
        // memungkinkan
        if (this.getTile(firstRow, firstCol).isEmptyTile()) {
            emptyTile.setRow(secondRow);
            emptyTile.setCol(secondCol);
        } else if (this.getTile(secondRow, secondCol).isEmptyTile()) {
            emptyTile.setRow(firstRow);
            emptyTile.setCol(firstCol);
        }

        Tile tmp = tiles[firstRow][firstCol];
        tiles[firstRow][firstCol] = tiles[secondRow][secondCol];
        tiles[secondRow][secondCol] = tmp;
    }

    /**
     * Method isSolved mengembalikan nilai apakah tile dalam gim sudah terselesaikan
     * atau tidak
     */
    public boolean isSolved() {
        for (int row = 0; row < squareSize; row++) {
            for (int col = 0; col < squareSize; col++) {
                // mengecek jika ada tile dalam kondisi yang salah maka akan mengembalikan nilai
                // false
                if (!tiles[row][col].isOnRightPosition(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method moveTile digunakan untuk mengubah tile dengan konsep: parameter Row
     * untuk menukar tile baris parameter Col untuk menukar tile kolom kemudian
     * mengecek apakah tile sudah di gerakan atau tidak
     */
    public boolean moveTile(int row, int col) {
        if (isChangable(row, col, 1, 0) || isChangable(row, col, -1, 0) || isChangable(row, col, 0, 1)
                || isChangable(row, col, 0, -1)) {
            return true;
        }
        return false;
    }

    /**
     * Method isChangable untuk mengecek tile apakah kosong dan bisa ditukar. Jika
     * bisa maka pertukaran dilakukan dengan aturan: parameter row untuk baris
     * sekarang, parameter col untuk kolom sekarang, parameter rowChange untuk
     * menukar baris, parameter colChange untuk menukar kolom.
     */
    public boolean isChangable(int row, int col, int rowChange, int colChange) {
        int neighborRow = row + rowChange;
        int neighborCol = col + colChange;
        if (isValidTile(neighborRow, neighborCol) && tiles[neighborRow][neighborCol].isEmptyTile()) {
            exchangeTile(row, col, neighborRow, neighborCol);
            return true;
        }
        return false;
    }

    /**
     * Method isValidTile untuk mengecek apakah baris dan kolom cocok atau tidak
     * dengan aturan: Parameter row untuk mengecek tile baris, Parameter col untuk
     * mengecek tile kolom.
     */
    public boolean isValidTile(int row, int col) {
        return row >= 0 && row < squareSize && col >= 0 && col < squareSize;
    }

}
