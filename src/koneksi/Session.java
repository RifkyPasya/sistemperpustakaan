/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

/**
 *
 * @author xiels
 */
public class Session {
    private static String id_petugas;
    private static String nama_petugas;

    public static void setIdPetugas(String id) {
        id_petugas = id;
    }

    public static String getIdPetugas() {
        return id_petugas;
    }

    public static void setNamaPetugas(String nama) {
        nama_petugas = nama;
    }

    public static String getNamaPetugas() {
        return nama_petugas;
    }

    public static void clearSession() {
        id_petugas = null;
        nama_petugas = null;
    }
}
