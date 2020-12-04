# Fifteen-Puzzle

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran. 

[Challenge Guidelines](challenge-guideline.md)

**Fifteen-Puzzle, 15-Puzzle atau Teka-teki 15 adalah teka-teki geser yang terdiri dari bingkai ubin persegi bernomor dalam urutan acak dengan satu ubin kosong. Puzzle tersebut juga ada dalam ukuran lain, terutama 8 puzzle yang lebih kecil. 

Jika ukurannya 3 × 3 ubin, maka puzzle tersebut disebut 8 tile terisi dan satu ubin kosong, dan jika 4x4 ubin, puzzle tersebut berisi 15 tile terisi dan satu ubin kosong, dan seterusnya. Tujuan dari teka-teki ini adalah untuk menempatkan ubin secara berurutan dengan melakukan gerakan geser yang menggunakan ruang kosong.**

## Credits
| NPM           | Name        |
| ------------- |-------------|
| 140810190038  | Leonardo Septian D    |
| 140810190066  | Johannes Gavin G N    |
| 140810190074  | Fahrul Thariq F |

## Change log
- **[Sprint Planning](changelog/sprint-planning.md) - (17/11/2020)** 
   -  Berdiskusi dan merencanakan sprint backlog dan sprint 1
   -  Mencari referensi 15 puzzle

- **[Sprint 1](changelog/sprint-1.md) - (From 16/11/2020 to 22/11/2020)** 
   - Membuat grid di class main
   - Membuat fungsi inverse
   - Membuat fungsi game selesai atau tidak

- **[Sprint 2](changelog/sprint-2.md) - ( From 22/11/2020 to 30/11/2020)** 
   - Menambahkan keterangan pada Running The App, App description, dan memperbaiki id pada sprint-1
   - Menambahkan class Tile dan mengganti class Fungsi dengan class PuzzleModel
   - Menambahkan setter, getter, dan method seperti dalam class Tile
   - Menambahkan setter, getter, dan method seperti dalam class PuzzleModel
   - Mengisi PuzzleModel dengan method-method yang digunakan dalam gim seperti shuffleBlock, dll.
   - Mulai merancang design GUI gim.

   
- **[Sprint 3](changelog/sprint-3.md) - (From 1/12/2020 to 8/12/2020)** 
   - Merancang GUI gim.
   - Membuat class PuzzlePanel
   - Menambahkan method addListenerButton
   - Membuat fungsi untuk menghentikan pemain saat gim selesai
   - Memindahkan main class ke class baru yakni PuzzleFrame dan class FifteenPuzzle dihapuskan untuk memudahkan pengkodean.
   - Menambahkan method untuk mengubah ukuran puzzle
   - Membuat tombol reset dan form actionPerfromed ketika gim dimenangkan
   - Mengisi classes used, UML, dan Notable Assumption and Design App Details pada README.md

## Running The App

* Saat aplikasi dimulai, terdapat opsi untuk memilih ukuran tile:
   - Secara default ukuran tile adalah (4 x 4)
   - Terdapat opsi ukuran tile dengan pilihan tile (n x n)<br>
* Jika pemain memilih opsi ukuran tile maka pemain memasukan ukuran tile yang diinginkan. [Untuk saat ini hanya terdapat opsi 3x3, 4x4, dan 5x5]
* Menampilkan grid ubin dengan besar 4 x 4 (ukuran default) atau n x n, ubin merupakan komponen dari board.
*  Urutan angka dari setiap tile pada grid diacak
* Untuk mengetahui urutan tersebut dapat dipecahkan dengan aturan:
   - Setiap angka yang didahului dengan angka yang lebih besar dianggap sebagai inversi, jumlah inversi pada puzzle harus genap
* Pemain mencoba untuk menyelesaikan puzzle, dengan mengeklik mouse listener lalu mengecek apakah kondisi/aturan berikut terpenuhi:
   - Pemain menggesar tile dengan menggerakan tile kosong, dengan tujuan tile tersebut terurut
   - Jika terasa sulit pemain dapat memilih tombol reset untuk mengulang gim.
   - Jika tile belum terurut maka gim belum selesai
* Selama gim 15-puzzle berjalan: disediakan tombol "Reset" ditujukan untuk pemain jika gim terasa sulit, tombol reset akan mengacak ulang urutan tile. 
* Terdapat fitur perhitungan jumlah gerakan yang dilakukan dan berapa jumlah waktu yang telah dihabiskan dalam bermain gim.
* Jika game selesai tile akan ter-reset sendiri, dan pemain dapat bermain kembali.

## Classes Used

TO;DO

UML image here

## Notable Assumption and Design App Details

TO;DO