/* 
Anggota Kelompok    : - Leonardo Septian Dwigantoro - 140810190038
                      - Johannes Gavin              - 140810190066
                      - Fahrul Thariq Fadillah      - 140810190074
Kelas               : B
Tanggal             : Kamis, 2 Desember 2020 [UPDATE-0]
Deskripsi           : Class PuzzlePanel untuk menentukan fungsi-fungsi panel pada gim FifteenPuzzle
*/

package gui;

// import library 
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.PuzzleModel;

public class PuzzlePanel extends javax.swing.JPanel {

    // deklarasi variabel dan kriteria font yang digunakan
    private final Font biggerFont = new Font("Time New Roman", Font.BOLD, 24);
    private PuzzleModel puzzleModel;
    private JButton[][] buttonArray;
    private int size;
    private int moveCount;

    public PuzzlePanel() {
        initComponents();
    }

    /**
     * Membuat form baru pada PuzzlePanel
     */
    public PuzzlePanel(int size) {
        initComponents();
        this.size = size;
        moveCount = 0;

        this.setLayout(new GridLayout(size, size, 0, 0));

        puzzleModel = new PuzzleModel(size);
        buttonArray = new JButton[size][size];
        initPuzzleModel();
        initButton();
    }

    // getter getMoveCount
    public int getMoveCount() {
        return moveCount;
    }

    // setter setMoveCount
    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    // getter getPuzzleModel
    public PuzzleModel getPuzzleModel() {
        return puzzleModel;
    }

    /**
     * Method initPuzzleModel membuat puzzle block dan mengacaknya sampai bisa
     * diselesaikan
     */
    public void initPuzzleModel() {
        do {
            puzzleModel.generateBlock();
            puzzleModel.shuffleBlock();
        } while (!puzzleModel.isSolvable());
    }

    /**
     * Method showCompletePuzzle menghentikan pemain dari menggerakan tile ketika
     * gim telah selesai
     */
    public void showCompletePuzzle() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttonArray[i][j].setEnabled(false);
            }
        }

    }

    /**
     * Method initButton mengeluarkan nilai dari tombol dan menambahkanya ke dalam
     * panel
     */
    public void initButton() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final int row = i;
                final int col = j;
                buttonArray[i][j] = new JButton(puzzleModel.getTile(i, j).getValue());
                buttonArray[i][j].setFont(biggerFont);
                if (puzzleModel.getTile(i, j).isEmptyTile()) {
                    buttonArray[i][j].setBackground(Color.GRAY);
                }
                this.add(buttonArray[i][j]);
            }
        }
        addListenerToButton();
    }

    /**
     * Method addListenerToButton menambahkan sinyal penerima dari setiap tombol
     * untuk melakukan gerakan atau perubahan
     */
    public void addListenerToButton() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final int row = i;
                final int col = j;
                buttonArray[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (puzzleModel.moveTile(row, col)) {
                            moveCount++;
                            updateButton();
                            buttonArray[row][col].setBackground(Color.GRAY);
                        }
                        Component source = (Component) e.getSource();

                        // secara rekursif mencari komponen akar dari class utama
                        while (source.getParent() != null) {
                            source = source.getParent();
                        }

                        // ketika telah ditemukan, akan dipanggil penerima ke akar komponen
                        if (source instanceof ActionListener) {
                            ((ActionListener) source).actionPerformed(e);
                        }
                    }
                });
            }
        }
    }

    /**
     * Method updateButton akan meng-update GUI dari tile ketika digerakan
     */
    public void updateButton() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                buttonArray[row][col].setText(puzzleModel.getTile(row, col).getValue());
                if (!puzzleModel.getTile(row, col).isEmptyTile()) {
                    buttonArray[row][col].setBackground(new JButton().getBackground());
                }
            }
        }
    }

    /**
     * Method initComponents dipanggil dalam konstruktor untuk men-inisialisasi form
     */
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
    }
}
