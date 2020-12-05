/* 
Anggota Kelompok    : - Leonardo Septian Dwigantoro - 140810190038
                      - Johannes Gavin              - 140810190066
                      - Fahrul Thariq Fadillah      - 140810190074
Kelas               : B
Tanggal             : Kamis, 3 Desember 2020 [UPDATE-0]
Deskripsi           : Class PuzzleFrame sebagai main class dan
                      untuk menentukan frame pada gim FifteenPuzzle
*/

package gui;

// import library 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PuzzleFrame extends javax.swing.JFrame implements ActionListener {

        // deklarasi variabel
        private int panelSize;
        private boolean isWin;
        private long startTime;
        private long currentTime;

        /**
         * Membuat form baru dari PuzzleFrame
         */
        public PuzzleFrame() {
                initComponents();
                this.setLayout(new BorderLayout());
                this.setTitle("15-Puzzle - Team Gorila - Praktikum PBO");

                // Mengatur ukuran default tile menjadi 4 x 4
                panelSize = 4;
                initPanel();
        }

        /**
         * Method initPanel untuk membuat panel pada puzzle ketika program berjalan
         */
        public void initPanel() {

                puzzlePanel.setVisible(false);
                puzzlePanel = new PuzzlePanel(panelSize);

                getContentPane().add(puzzlePanel, BorderLayout.CENTER);
                getContentPane().add(controlPanel, BorderLayout.SOUTH);
                puzzlePanel.setVisible(true);

                isWin = false;
                puzzlePanel.setMoveCount(0);

                lblMove.setText("Jumlah Gerakan: 0");
                lblTime.setText("Waktu: 0 detik");
                startTime = System.currentTimeMillis();

                Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                while (!isWin) {
                                        try {
                                                currentTime = System.currentTimeMillis();
                                                lblTime.setText("Waktu terpakai: " + ((currentTime - startTime) / 1000)
                                                                + " detik");
                                                Thread.sleep(1000);
                                        } catch (InterruptedException ex) {
                                                ex.printStackTrace();
                                        }
                                }
                        }
                });
                t.start();
        }

        /**
         * Method initComponents dipanggil dalam konstruktor untuk men-inisialisasi form
         */
        private void initComponents() {

                puzzlePanel = new gui.PuzzlePanel();
                controlPanel = new javax.swing.JPanel();
                lblMove = new javax.swing.JLabel();
                lblTime = new javax.swing.JLabel();
                lblSize = new javax.swing.JLabel();
                cbxSize = new javax.swing.JComboBox<>();
                btnNew = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                javax.swing.GroupLayout puzzlePanelLayout = new javax.swing.GroupLayout(puzzlePanel);
                puzzlePanel.setLayout(puzzlePanelLayout);
                puzzlePanelLayout.setHorizontalGroup(
                                puzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                puzzlePanelLayout.setVerticalGroup(
                                puzzlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 190, Short.MAX_VALUE));

                lblMove.setText("Jumlah Gerakan: 0");

                lblTime.setText("Waktu: 0 sec");

                lblSize.setText("Pilih Ukuran Tile");

                // Opsi tile dalam gim
                cbxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 x 3", "4 x 4", "5 x 5" }));
                cbxSize.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cbxSizeActionPerformed(evt);
                        }
                });

                // Membuat fitur reset
                btnNew.setText("Reset");
                btnNew.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnNewActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
                controlPanel.setLayout(controlPanelLayout);
                controlPanelLayout.setHorizontalGroup(controlPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(controlPanelLayout.createSequentialGroup().addGap(45, 45, 45)
                                                .addGroup(controlPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                                                .addComponent(lblSize)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(cbxSize,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(btnNew,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(lblTime,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(lblMove,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap(219, Short.MAX_VALUE)));
                controlPanelLayout.setVerticalGroup(controlPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(controlPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(lblMove, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblTime).addGap(18, 18, 18)
                                                .addGroup(controlPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(lblSize).addComponent(cbxSize,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(14, 14, 14).addComponent(btnNew)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(controlPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(puzzlePanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap()
                                                .addComponent(puzzlePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                pack();
        }

        /**
         * Method cbxSizeActionPerformed untuk mengubah ukuran tile Change puzzle size
         */
        private void cbxSizeActionPerformed(java.awt.event.ActionEvent evt) {

                String size = (String) cbxSize.getSelectedItem();
                if (size.contains("4")) {
                        panelSize = 4;
                } else if (size.contains("5")) {
                        panelSize = 5;
                } else {
                        panelSize = 3;
                }
                initPanel();
        }

        /**
         * Method btnNewActionPerformed untuk mereset gim dan memulai gim baru
         */
        private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {

                initPanel();
        }

        /**
         * Main class gim Fifteen Puzzle
         */
        public static void main(String args[]) {
                
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Windows Classic".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(PuzzleFrame.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(PuzzleFrame.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(PuzzleFrame.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(PuzzleFrame.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                

                /*Membuat dan menampilkan form  */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new PuzzleFrame().setVisible(true);
                        }
                });
        }

        // Deklarasi variabel
        private javax.swing.JButton btnNew;
        private javax.swing.JComboBox<String> cbxSize;
        private javax.swing.JPanel controlPanel;
        private javax.swing.JLabel lblMove;
        private javax.swing.JLabel lblSize;
        private javax.swing.JLabel lblTime;
        private gui.PuzzlePanel puzzlePanel;

        /**
         * Meng-override method actionPerformed untuk menampilkan kata-kata dalam gim.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
                lblMove.setText("Jumlah Gerakan: " + puzzlePanel.getMoveCount());
                if (puzzlePanel.getPuzzleModel().isSolved()) {
                        puzzlePanel.showCompletePuzzle();
                        isWin = true;
                        int choice = JOptionPane.showConfirmDialog(null, "Kamu menang! main lagi?", "Selamat!",
                                        JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                                initPanel();
                        }
                }

        }
}
