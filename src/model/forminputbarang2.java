/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ROG
 */
public class forminputbarang2 {
    private int kd_barang; 
    private String nama_barang;
    private String harga_barang;
    
    public forminputbarang2(){
    
    }

    public int getkd_barang() {
        return kd_barang;
    }

    public void setkd_barang(int kd_barang) {
        this.kd_barang = kd_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(String harga_barang) {
        this.harga_barang = harga_barang;
    }
}
