/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tampilan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import koneksi.koneksi;
import koneksi.Session;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author xiels
 */
public class FormPengembalian extends javax.swing.JFrame {
    Connection conn = koneksi.getKoneksi();
    DefaultTableModel model;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPengembalian.class.getName());

    /**
     * Creates new form FormPengembalian
     */
    public FormPengembalian() {
        initComponents();
    txtidkembali.setEditable(false);
    labelidpetugas.setText(Session.getIdPetugas());
    labelnamapetugas.setText(Session.getNamaPetugas());

    sptglkembali.setModel(new javax.swing.SpinnerDateModel());
    JSpinner.DateEditor de =
    new JSpinner.DateEditor(sptglkembali,"yyyy-MM-dd");
    sptglkembali.setEditor(de);

    sptglkembali.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
        hitungStatusPengembalian();
        });

    txttenggat.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            hitungStatusPengembalian();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            hitungStatusPengembalian();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            hitungStatusPengembalian();
        }
    });

    nonAktif();
    autoID();
    tampilData();
    resetForm();
    }
    
private void nonAktif(){

    txtidpinjam.setEditable(false);
    txtidanggota.setEditable(false);
    txtnamaanggota.setEditable(false);
    txtidbuku.setEditable(false);
    txtjudul.setEditable(false);
    txttanggalpinjam.setEditable(false);
    txttenggat.setEditable(false);
    txtstatus.setEditable(false);
}
    
    private void tampilData() {
    String[] judul = {
        "ID Pengembalian",
        "ID Peminjaman",
        "Tanggal Kembali",
        "Status"
    };

    model = new DefaultTableModel(judul, 0);
    tblpengembalian.setModel(model);
}
    
    private void autoID(){

    try {

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(
            "SELECT id_pengembalian FROM pengembalian ORDER BY id_pengembalian DESC LIMIT 1"
        );

        if(rs.next()){

            String id =
            rs.getString("id_pengembalian").substring(2);

            int angka = Integer.parseInt(id) + 1;

            String nol = "";

            if(angka < 10){
                nol = "00";
            }else if(angka < 100){
                nol = "0";
            }

            txtidkembali.setText("KB"+nol+angka);

        }else{

            txtidkembali.setText("KB001");
        }

    } catch(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage());
    }
}
    
    private void resetForm(){

    autoID();

    txtidpinjam.setText("");
    txtidanggota.setText("");
    txtnamaanggota.setText("");
    txtidbuku.setText("");
    txtjudul.setText("");
    txttanggalpinjam.setText("");
    txttenggat.setText("");
    txtstatus.setText("");

    sptglkembali.setValue(new java.util.Date());
}
    private void hitungStatusPengembalian() {
    try {
        if (txttenggat.getText().equals("")) {
            txtstatus.setText("");
            return;
        }

        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

        String tanggalKembali = fm.format(sptglkembali.getValue());

        java.util.Date tglKembali = fm.parse(tanggalKembali);
        java.util.Date tglTenggat = fm.parse(txttenggat.getText());

        if (tglKembali.after(tglTenggat)) {
            txtstatus.setText("Terlambat");
        } else {
            txtstatus.setText("Tepat Waktu");
        }

    } catch (Exception e) {
        txtstatus.setText("");
    }
}
    
    public void cetakpengembalian(String idPengembalian) {
    try {
        String path = "./src/report/Pengembalian.jasper";

        HashMap parameter = new HashMap();
        parameter.put("id_pengembalian", idPengembalian);
        parameter.put("nama_petugas", Session.getNamaPetugas());

        JasperPrint print = JasperFillManager.fillReport(path, parameter, conn);
        JasperViewer.viewReport(print, false);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Gagal mencetak report: " + ex);
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelidpetugas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtidkembali = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        labelnamapetugas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sptglkembali = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtidpinjam = new javax.swing.JTextField();
        txtidanggota = new javax.swing.JTextField();
        txtnamaanggota = new javax.swing.JTextField();
        txtidbuku = new javax.swing.JTextField();
        txtjudul = new javax.swing.JTextField();
        txttanggalpinjam = new javax.swing.JTextField();
        btnCariPinjam = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txttenggat = new javax.swing.JTextField();
        txtstatus = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpengembalian = new javax.swing.JTable();
        btnhapus = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 251, 235));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(6, 78, 59));
        jLabel1.setText("Data Pengembalian Buku");

        jLabel2.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(6, 78, 59));
        jLabel2.setText("ID Petugas");

        labelidpetugas.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        labelidpetugas.setForeground(new java.awt.Color(6, 78, 59));
        labelidpetugas.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(6, 78, 59));
        jLabel4.setText("ID Pengembalian");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(6, 78, 59));
        jLabel5.setText("Nama Petugas");

        labelnamapetugas.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        labelnamapetugas.setForeground(new java.awt.Color(6, 78, 59));
        labelnamapetugas.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(6, 78, 59));
        jLabel7.setText("Tanggal Kembali");

        jPanel2.setBackground(new java.awt.Color(252, 247, 228));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(6, 78, 59));
        jLabel9.setText("ID Peminjaman");

        jLabel10.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(6, 78, 59));
        jLabel10.setText("Nama Anggota");

        jLabel11.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(6, 78, 59));
        jLabel11.setText("Judul Buku");

        jLabel12.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(6, 78, 59));
        jLabel12.setText("Tanggal Pinjam");

        jLabel13.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(6, 78, 59));
        jLabel13.setText("Tenggat Kembali");

        jLabel14.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(6, 78, 59));
        jLabel14.setText("Status Pengembalian");

        btnCariPinjam.setBackground(new java.awt.Color(6, 78, 59));
        btnCariPinjam.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        btnCariPinjam.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPinjam.setText("Cari");
        btnCariPinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCariPinjamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCariPinjamMouseExited(evt);
            }
        });
        btnCariPinjam.addActionListener(this::btnCariPinjamActionPerformed);

        jLabel15.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(6, 78, 59));
        jLabel15.setText("ID Anggota");

        jLabel16.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(6, 78, 59));
        jLabel16.setText("ID Buku");

        btntambah.setBackground(new java.awt.Color(6, 78, 59));
        btntambah.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        btntambah.setForeground(new java.awt.Color(255, 255, 255));
        btntambah.setText("Tambah");
        btntambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntambahMouseExited(evt);
            }
        });
        btntambah.addActionListener(this::btntambahActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtidbuku))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtidpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnCariPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtstatus)
                            .addComponent(txttenggat)
                            .addComponent(txttanggalpinjam)
                            .addComponent(txtidanggota))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtnamaanggota))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtjudul)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidanggota, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnamaanggota, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttanggalpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttenggat, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jLabel8.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(6, 78, 59));
        jLabel8.setText("Data Peminjaman");

        jPanel3.setBackground(new java.awt.Color(252, 247, 228));

        tblpengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Pengembalian", "ID Peminjaman", "Tanggal Kembali", "Status Pengembalian"
            }
        ));
        jScrollPane1.setViewportView(tblpengembalian);

        btnhapus.setBackground(new java.awt.Color(6, 78, 59));
        btnhapus.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        btnhapus.setForeground(new java.awt.Color(255, 255, 255));
        btnhapus.setText("Hapus");
        btnhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhapusMouseExited(evt);
            }
        });
        btnhapus.addActionListener(this::btnhapusActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        jLabel17.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(6, 78, 59));
        jLabel17.setText("Pengembalian");

        btnsimpan.setBackground(new java.awt.Color(6, 78, 59));
        btnsimpan.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        btnsimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnsimpan.setText("Simpan");
        btnsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsimpanMouseExited(evt);
            }
        });
        btnsimpan.addActionListener(this::btnsimpanActionPerformed);

        btnbatal.setBackground(new java.awt.Color(6, 78, 59));
        btnbatal.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        btnbatal.setForeground(new java.awt.Color(255, 255, 255));
        btnbatal.setText("Batal");
        btnbatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbatalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbatalMouseExited(evt);
            }
        });
        btnbatal.addActionListener(this::btnbatalActionPerformed);

        btnclose.setBackground(new java.awt.Color(6, 78, 59));
        btnclose.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        btnclose.setForeground(new java.awt.Color(255, 255, 255));
        btnclose.setText("Close");
        btnclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncloseMouseExited(evt);
            }
        });
        btnclose.addActionListener(this::btncloseActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(361, 361, 361))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelidpetugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtidkembali, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                        .addGap(284, 284, 284)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelnamapetugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sptglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel8)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sptglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelidpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPinjamActionPerformed
        // TODO add your handling code here:
        FormPopupPeminjaman p = new FormPopupPeminjaman();
        p.setVisible(true);
    }//GEN-LAST:event_btnCariPinjamActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
         int baris = tblpengembalian.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(null, "Pilih data pengembalian yang ingin dihapus");
        return;
    }

    String idPengembalian = tblpengembalian.getValueAt(baris, 0).toString();
    String idPeminjaman = tblpengembalian.getValueAt(baris, 1).toString();

    int ok = JOptionPane.showConfirmDialog(
        null,
        "Yakin ingin menghapus data pengembalian ini?",
        "Konfirmasi",
        JOptionPane.YES_NO_OPTION
    );

    if (ok == JOptionPane.YES_OPTION) {
        try {
            conn.setAutoCommit(false);

            String sqlHapus =
                "DELETE FROM pengembalian WHERE id_pengembalian=?";

            PreparedStatement pst = conn.prepareStatement(sqlHapus);
            pst.setString(1, idPengembalian);
            pst.executeUpdate();

            String sqlUpdateBuku =
                "UPDATE buku SET status_buku='Dipinjam' " +
                "WHERE id_buku IN " +
                "(SELECT id_buku FROM isi_peminjaman WHERE id_peminjaman=?)";

            PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdateBuku);
            pstUpdate.setString(1, idPeminjaman);
            pstUpdate.executeUpdate();

            conn.commit();

            JOptionPane.showMessageDialog(null, "Data pengembalian berhasil dihapus");

            resetForm();
            tampilData();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        try {
        if (txtidpinjam.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pilih data peminjaman terlebih dahulu");
            return;
        }

        if (txtstatus.getText().equals("")) {
            hitungStatusPengembalian();
        }

        if (model.getRowCount() > 0) {
            JOptionPane.showMessageDialog(null, "Data pengembalian sudah ditambahkan");
            return;
        }

        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalKembali = fm.format(sptglkembali.getValue());

        Object[] data = {
            txtidkembali.getText(),
            txtidpinjam.getText(),
            tanggalKembali,
            txtstatus.getText()
        };

        model.addRow(data);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
        resetForm();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        try {
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Klik tombol Tambah terlebih dahulu");
            return;
        }

        String idPengembalian = model.getValueAt(0, 0).toString();
        String idPeminjaman = model.getValueAt(0, 1).toString();
        String tanggalKembali = model.getValueAt(0, 2).toString();
        String statusPengembalian = model.getValueAt(0, 3).toString();

        String cek = "SELECT * FROM pengembalian WHERE id_peminjaman=?";
        PreparedStatement pstCek = conn.prepareStatement(cek);
        pstCek.setString(1, idPeminjaman);
        ResultSet rsCek = pstCek.executeQuery();

        if (rsCek.next()) {
            JOptionPane.showMessageDialog(null, "Data peminjaman ini sudah pernah dikembalikan");
            return;
        }

        conn.setAutoCommit(false);

        String sqlPengembalian =
            "INSERT INTO pengembalian " +
            "(id_pengembalian, id_peminjaman, tanggal_kembali, status_pengembalian) " +
            "VALUES (?,?,?,?)";

        PreparedStatement pst = conn.prepareStatement(sqlPengembalian);
        pst.setString(1, idPengembalian);
        pst.setString(2, idPeminjaman);
        pst.setString(3, tanggalKembali);
        pst.setString(4, statusPengembalian);
        pst.executeUpdate();

        String sqlUpdateBuku =
            "UPDATE buku SET status_buku='Tersedia' "
          + "WHERE id_buku IN "
          + "(SELECT id_buku FROM isi_peminjaman WHERE id_peminjaman=?)";

        PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdateBuku);
        pstUpdate.setString(1, idPeminjaman);
        pstUpdate.executeUpdate();

        conn.commit();

        JOptionPane.showMessageDialog(null, "Data pengembalian berhasil disimpan");

        cetakpengembalian(idPengembalian);

        resetForm();
        tampilData();

    } catch (Exception e) {
        try {
            conn.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        JOptionPane.showMessageDialog(null, e.getMessage());

    } finally {
        try {
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        new MenuUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnCariPinjamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariPinjamMouseExited
        // TODO add your handling code here:
        btnCariPinjam.setBackground(new java.awt.Color(6,78,59));
    }//GEN-LAST:event_btnCariPinjamMouseExited

    private void btntambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseEntered
        // TODO add your handling code here:
        btntambah.setBackground(new java.awt.Color(25,135,84));
    }//GEN-LAST:event_btntambahMouseEntered

    private void btntambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseExited
        // TODO add your handling code here:
        btntambah.setBackground(new java.awt.Color(6,78,59));
    }//GEN-LAST:event_btntambahMouseExited

    private void btnhapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapusMouseExited
        // TODO add your handling code here:
        btnhapus.setBackground(new java.awt.Color(6,78,59));
    }//GEN-LAST:event_btnhapusMouseExited

    private void btnsimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseExited
        // TODO add your handling code here:
        btnsimpan.setBackground(new java.awt.Color(6,78,59));
    }//GEN-LAST:event_btnsimpanMouseExited

    private void btncloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncloseMouseExited
        // TODO add your handling code here:
        btnclose.setBackground(new java.awt.Color(6,78,59));
    }//GEN-LAST:event_btncloseMouseExited

    private void btnbatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMouseExited
        // TODO add your handling code here:
        btnbatal.setBackground(new java.awt.Color(6,78,59));
    }//GEN-LAST:event_btnbatalMouseExited

    private void btnCariPinjamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariPinjamMouseEntered
        // TODO add your handling code here:
        btnCariPinjam.setBackground(new java.awt.Color(25,135,84));
    }//GEN-LAST:event_btnCariPinjamMouseEntered

    private void btnhapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapusMouseEntered
        // TODO add your handling code here:
        btnhapus.setBackground(new java.awt.Color(25,135,84));
    }//GEN-LAST:event_btnhapusMouseEntered

    private void btnsimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseEntered
        // TODO add your handling code here:
        btnsimpan.setBackground(new java.awt.Color(25,135,84));
    }//GEN-LAST:event_btnsimpanMouseEntered

    private void btncloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncloseMouseEntered
        // TODO add your handling code here:
        btnclose.setBackground(new java.awt.Color(25,135,84));
    }//GEN-LAST:event_btncloseMouseEntered

    private void btnbatalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbatalMouseEntered
        // TODO add your handling code here:
        btnbatal.setBackground(new java.awt.Color(25,135,84));
    }//GEN-LAST:event_btnbatalMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormPengembalian().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariPinjam;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelidpetugas;
    private javax.swing.JLabel labelnamapetugas;
    private javax.swing.JSpinner sptglkembali;
    private javax.swing.JTable tblpengembalian;
    public static javax.swing.JTextField txtidanggota;
    public static javax.swing.JTextField txtidbuku;
    private javax.swing.JTextField txtidkembali;
    public static javax.swing.JTextField txtidpinjam;
    public static javax.swing.JTextField txtjudul;
    public static javax.swing.JTextField txtnamaanggota;
    public static javax.swing.JTextField txtstatus;
    public static javax.swing.JTextField txttanggalpinjam;
    public static javax.swing.JTextField txttenggat;
    // End of variables declaration//GEN-END:variables
}
