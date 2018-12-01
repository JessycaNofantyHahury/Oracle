/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model_RS.Dokter;
import model_RS.RumahSakit;

/**
 *
 * @author user only
 */
public class TambahDokterDialog extends JDialog {

    private RumahSakit rumahSakit;
    private JLabel tambahDokterLabel;
    private JLabel idDokterLabel;
    private JTextField idDokterText;
    private JLabel namaDokterLabel;
    private JTextField namaDokterText;
    private JButton tambahButton;
    private MyDokterDialog owner;

    public TambahDokterDialog(MyDokterDialog owner, RumahSakit rs) {
        super(owner);
        this.owner = owner;
        rumahSakit = rs;
        init();
    }

    /**
     * Fungsi untuk inisialisasi
     */
    public void init() {
        // set size
        setSize(400, 300);
        // set layout
        setLayout(null);

        tambahDokterLabel = new JLabel();
        tambahDokterLabel.setBounds(30, 50, 50, 40);
        this.add(tambahDokterLabel);

        namaDokterLabel = new JLabel("Nama");
        namaDokterLabel.setBounds(60, 50, 50, 60);
        this.add(namaDokterLabel);

        namaDokterText = new JTextField();
        namaDokterText.setBounds(120, 70, 70, 20);
        this.add(namaDokterText);

        idDokterLabel = new JLabel("Id Dokter");
        idDokterLabel.setBounds(60, 70, 70, 80);
        this.add(idDokterLabel);

        idDokterText = new JTextField();
        idDokterText.setBounds(120, 100, 100, 20);
        this.add(idDokterText);

        // tambah Tombol Tambah
        tambahButton = new JButton("Tambah");
        tambahButton.setBounds(150, 300, 100, 30);
        this.add(tambahButton);

        // set action listener button
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahDokter();
            }
        });
    }

    public void tambahDokter() {
        
        Dokter dr1 = new Dokter(idDokterText.getText(), namaDokterText.getText());
        rumahSakit.tambahDokter(dr1);
        owner.refreshTabelDokter();
        dispose();
    }
}
