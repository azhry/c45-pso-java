/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Azhary Arliansyah
 */
public class Data {
    
    private String nama;
    private int pendidikan;
    private int pekerjaan;
    private int penghasilan;
    private int ptr;
    private int ventilasi;
    private int pencahayaan;
    private int kelembaban;
    private int atap;
    private int dinding;
    private int lantai;
    private int ispa;
    
    public Data(String nama, int pendidikan, int pekerjaan, int penghasilan, 
            int ptr, int ventilasi, int pencahayaan, int kelembaban, 
            int atap, int dinding, int lantai, int ispa) {
        this.setNama(nama);
        this.setPendidikan(pendidikan);
        this.setPekerjaan(pekerjaan);
        this.setPenghasilan(penghasilan);
        this.setPtr(ptr);
        this.setVentilasi(ventilasi);
        this.setPencahayaan(pencahayaan);
        this.setKelembaban(kelembaban);
        this.setAtap(atap);
        this.setDinding(dinding);
        this.setLantai(lantai);
        this.setIspa(ispa);
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(int pendidikan) {
        this.pendidikan = pendidikan;
    }

    public int getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(int pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public int getPenghasilan() {
        return penghasilan;
    }

    public void setPenghasilan(int penghasilan) {
        this.penghasilan = penghasilan;
    }

    public int getPtr() {
        return ptr;
    }

    public void setPtr(int ptr) {
        this.ptr = ptr;
    }

    public int getVentilasi() {
        return ventilasi;
    }

    public void setVentilasi(int ventilasi) {
        this.ventilasi = ventilasi;
    }

    public int getPencahayaan() {
        return pencahayaan;
    }

    public void setPencahayaan(int pencahayaan) {
        this.pencahayaan = pencahayaan;
    }

    public int getKelembaban() {
        return kelembaban;
    }

    public void setKelembaban(int kelembaban) {
        this.kelembaban = kelembaban;
    }

    public int getAtap() {
        return atap;
    }

    public void setAtap(int atap) {
        this.atap = atap;
    }

    public int getDinding() {
        return dinding;
    }

    public void setDinding(int dinding) {
        this.dinding = dinding;
    }

    public int getLantai() {
        return lantai;
    }

    public void setLantai(int lantai) {
        this.lantai = lantai;
    }

    public int getIspa() {
        return ispa;
    }

    public void setIspa(int ispa) {
        this.ispa = ispa;
    }
    
}
