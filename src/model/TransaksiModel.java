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
public class TransaksiModel {
    private int no_stand; 
    private String nama_barang;
    private String harga_satuan;
    private int jumlah_beli;
    
    public TransaksiModel(){
    
    }

    public int getNo_stand() {
        return no_stand;
    }

    public void setNo_stand(int no_stand) {
        this.no_stand = no_stand;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getHarga_satuan() {
        return harga_satuan;
    }

    public void setHarga_satuan(String harga_satuan) {
        this.harga_satuan = harga_satuan;
    }

    public int getJumlah_beli() {
        return jumlah_beli;
    }

    public void setJumlah_beli(int jumlah_beli) {
        this.jumlah_beli = jumlah_beli;
    }

    
}
