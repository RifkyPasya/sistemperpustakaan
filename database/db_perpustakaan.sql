-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Jul 2026 pada 12.53
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpustakaan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `id_anggota` varchar(10) NOT NULL,
  `nama_anggota` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `alamat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`id_anggota`, `nama_anggota`, `jenis_kelamin`, `no_hp`, `alamat`) VALUES
('AG001', 'Jierra', 'Perempuan', 'Perempuan', 'Jakarta Selatan'),
('AG002', 'Budi', 'Laki-laki', '089566732122', 'Depok'),
('AG003', 'Verdi', 'Laki-laki', '081265436642', 'Bekasi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `id_buku` varchar(10) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `pengarang` varchar(30) NOT NULL,
  `penerbit` varchar(30) NOT NULL,
  `tahun_terbit` year(4) NOT NULL,
  `kategori` varchar(30) NOT NULL,
  `status_buku` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`id_buku`, `judul_buku`, `pengarang`, `penerbit`, `tahun_terbit`, `kategori`, `status_buku`) VALUES
('BK001', 'Yellowface', 'R.F.Kuang', 'Gramedia', '2024', 'Novel', 'Dipinjam'),
('BK002', 'Angsa dan Kelelawar', 'Keigo Higashino', 'Gramedia', '2023', 'Novel', 'Tersedia'),
('BK003', 'Bumi', 'Tere Liye', 'Gramedia', '2014', 'Novel', 'Tersedia'),
('BK004', 'A Man Called Ove', 'Fredrik Backman', 'Gramedia', '2022', 'Novel', 'Tersedia'),
('BK005', 'Alice In Borderland Vol. 01', 'HARO ASO', 'Elex Media Komputindo', '2022', 'Komik', 'Tersedia'),
('BK006', 'Alice In Borderland Vol. 02', 'HARO ASO', 'Elex Media Komputindo', '2023', 'Komik', 'Tersedia'),
('BK007', 'Alice In Borderland Vol. 03', 'HARO ASO', 'Elex Media Komputindo', '2023', 'Komik', 'Tersedia'),
('BK008', 'Alice In Borderland Vol. 04', 'HARO ASO', 'Elex Media Komputindo', '2023', 'Komik', 'Tersedia'),
('BK009', 'Platina Data', 'Keigo Higashino', 'Gramedia', '2025', 'Novel', 'Tersedia'),
('BK010', 'Rich Dad Poor Dad', 'Robert T. Kiyosaki', 'Gramedia', '2016', 'Bisnis', 'Tersedia'),
('BK011', 'Company Of One', 'Paul Jarvis', 'Mariner Books', '2019', 'Bisnis', 'Tersedia'),
('BK012', 'Clean Code', 'Robert C. Martin', 'Prentice Hall', '2008', 'Teknologi', 'Tersedia'),
('BK013', 'Guns, Germs, and Steel', 'Jared Diamond', 'W. W. Norton', '1999', 'Sejarah', 'Tersedia'),
('BK014', 'Agama dan Imajinasi', 'Haidar Bagir', 'Bentang Pustaka', '2025', 'Agama', 'Tersedia'),
('BK015', 'Misteri Agama dan Refleksi Filsafat', 'Louis Dupre', 'Diva Press', '2022', 'Agama', 'Tersedia'),
('BK016', 'Why? Computer', 'Yearimdang', 'Elex Media Komputindo', '2010', 'Anak-anak', 'Tersedia'),
('BK017', 'Why? People: Albert Einstein', 'Yearimdang', 'Elex Media Komputindo', '2013', 'Anak-anak', 'Tersedia'),
('BK018', 'Why? Science: Robot', 'Yearimdang', 'Elex Media Komputindo', '2012', 'Anak-anak', 'Tersedia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `denda`
--

CREATE TABLE `denda` (
  `id_denda` varchar(10) NOT NULL,
  `id_pengembalian` varchar(10) NOT NULL,
  `hari_terlambat` int(11) NOT NULL,
  `total_denda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `isi_peminjaman`
--

CREATE TABLE `isi_peminjaman` (
  `id_isi` int(11) NOT NULL,
  `id_peminjaman` varchar(10) NOT NULL,
  `id_buku` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `isi_peminjaman`
--

INSERT INTO `isi_peminjaman` (`id_isi`, `id_peminjaman`, `id_buku`) VALUES
(27, 'PJ001', 'BK001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` varchar(10) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `id_anggota` varchar(10) NOT NULL,
  `id_petugas` varchar(10) NOT NULL,
  `tenggat_kembali` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `tanggal_pinjam`, `id_anggota`, `id_petugas`, `tenggat_kembali`) VALUES
('PJ001', '2026-07-06', 'AG002', 'PT002', '2026-07-06');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_pengembalian` varchar(10) NOT NULL,
  `id_peminjaman` varchar(10) NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `status_pengembalian` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` varchar(10) NOT NULL,
  `nama_petugas` varchar(30) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama_petugas`, `username`, `password`) VALUES
('PT001', 'Bayu', 'admin1', '111'),
('PT002', 'Jinan', 'admin2', '222'),
('PT003', 'Bambang', 'admin3', '333');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indeks untuk tabel `denda`
--
ALTER TABLE `denda`
  ADD PRIMARY KEY (`id_denda`),
  ADD KEY `fk_denda_pengembalian` (`id_pengembalian`);

--
-- Indeks untuk tabel `isi_peminjaman`
--
ALTER TABLE `isi_peminjaman`
  ADD PRIMARY KEY (`id_isi`),
  ADD KEY `id_peminjaman` (`id_peminjaman`),
  ADD KEY `id_buku` (`id_buku`);

--
-- Indeks untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `fk_peminjaman_anggota` (`id_anggota`),
  ADD KEY `fk_peminjaman_petugas` (`id_petugas`);

--
-- Indeks untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`),
  ADD KEY `fk_pengembalian_peminjaman` (`id_peminjaman`);

--
-- Indeks untuk tabel `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `isi_peminjaman`
--
ALTER TABLE `isi_peminjaman`
  MODIFY `id_isi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `denda`
--
ALTER TABLE `denda`
  ADD CONSTRAINT `fk_denda_pengembalian` FOREIGN KEY (`id_pengembalian`) REFERENCES `pengembalian` (`id_pengembalian`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `isi_peminjaman`
--
ALTER TABLE `isi_peminjaman`
  ADD CONSTRAINT `isi_peminjaman_ibfk_1` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `isi_peminjaman_ibfk_2` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `fk_peminjaman_anggota` FOREIGN KEY (`id_anggota`) REFERENCES `anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_peminjaman_petugas` FOREIGN KEY (`id_petugas`) REFERENCES `petugas` (`id_petugas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `fk_pengembalian_peminjaman` FOREIGN KEY (`id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
