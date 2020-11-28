# Scrum Report (Sprint 2)
| From 22/11/2020 to 30/11/2020

## Team Gorilla
| NPM           | Name        |
| ------------- |-------------|
| 140810190038  | Leonardo Septian D    |
| 140810190066  | Johannes Gavin G N    |
| 140810190074  | Fahrul Thariq F       |

## Sprint Overview
| Planned (n)   | Completed (n) |
| ------------- |-------------- |
| 9             | 9             |

## Sprint 2 Backlog

| ID  | Title/Desc | Asignee | Status |
| --- | ---------- | ------- | ------ |
| 2.1 | membuat class Tile  | Gavin |  DONE |
| 2.2 | membuat setter getter pada class tile dari Tile, Col, dan Row |  Leonardo| DONE  |
| 2.3 |menambahkan fungsi setValue, isEmptyTile, dan isOnRightPosition pada class Tile | Thariq |  DONE  |
| 2.4 |menganti class Fungsi dengan class PuzzleMode | Gavin |  DONE  |
| 2.5 |mengisi class puzzleModel dengan deklarasi variabel, setter, dan getter | Thariq |  DONE  |
| 2.6 |menambahkan method generateBlock, ShuffleBlock, dan isSolvable | Leonardo |  DONE  |
| 2.7 | memindahkan fungsi isSolved dari class Fungsi ke class PuzzleModel | Gavin |  DONE  |
| 2.8 |Menambahkan fungsi exchangeTile dan moveTile | Thariq |  DONE  |
| 2.9 | menambahkan method isChangable dan isValidTile | Leonardo |  DONE  |

## Retrospective 

Dalam sprint-1 fungsi setter getter masih digabung dalam main class FifteenPuzzle, dan saat ini telah dipisahkan dalam class baru yakni Tile. Method-method yang digunakan dalam gim khususnya pada tile sudah ditambahkan dan dimasukan dalam class PuzzleModel, dengan catatan fungsi yang dimasukan masih berupa fungsi-fungsi dasar dari gim. Tantangan sekarang adalah men-design Gui dari gim dan memberi tambahan-tambahan fitur lainnya. Fungsi untuk membuat costum tile (n x n) masih dalam pengembangan jadi belum bisa dimasukan dalam PuzzleModel. Agar lebih mudah kemungkinan besar akan dibedakan antara folder Gui dan folder dari fungsi-fungsi yang digunakan dalam gim.  

## Next Sprint Backlog (Sprint 3)
| ID  | Title/Desc | Asignee | 
| --- | ---------- | ------- | 
| 3.1 |Membuat class PuzzlePanel | Leonardo | 
| 3.2 | Membuat fungsi untuk menghentikan pemain saat gim selesai | Thariq | 
| 3.3 | Menambahkan method addListenerButton | Gavin | 
| 3.4 | Membuat method update saat gui digerakan | Leonardo | 
| 3.5 | Membuat Panel gim saat gim dimulai | Leonardo| 
| 3.6 | Menambahkan method untuk mengubah ukuran puzzle | Thariq | 
| 3.7 | Membuat tombol new gim | Gavin | 
| 3.8 | Membuat form actionPerfromed ketika gim dimenangkan| Leonardo | 
| 3.9 | Mengisi classes used, UML, dan Notable Assumption and Design App Details pada README.md| Thariq | 
| 3.10 | Membuat fungsi mengubah warna saat tile digerakan ditempat yang salah atau benar | Gavin | 