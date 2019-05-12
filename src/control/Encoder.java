/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Azhary Arliansyah
 */
public class Encoder {
    
    public static int pendidikan(String value) {
        switch (value) {
            case "Tidak Sekolah / Tidak Tamat SD":
                return 1;
            case "Tamat SD":
                return 2;
            case "Tamat SMP":
                return 3;
            case "Tamat SMA":
                return 4;
            case "Perguruan Tinggi":
                return 5;
        }
        return 0;
    }
    
    public static int pekerjaan(String value) {
        switch (value) {
            case "Tidak Bekerja":
                return 1;
            case "Petani":
                return 2;
            case "Buruh":
                return 3;
            case "Swasta":
                return 4;
            case "PNS":
                return 5;
            case "Lain-lain":
                return 6;
        }
        return 0;
    }
    
    public static int penghasilan(String value) {
        switch (value) {
            case "Kurang Dari Rp. 250.000":
                return 1;
            case "Rp. 250.000 - Rp. 500.000":
                return 2;
            case "Lebih Dari Rp. 500.000":
                return 3;
        }
        return 0;
    }
    
    public static int ptr(String value) {
        switch (value) {
            case "Ya":
                return 1;
            case "Tidak":
                return 2;
        }
        return 0;
    }
    
    public static int ventilasi(String value) {
        switch (value) {
            case "Baik (≥ 10%)":
                return 1;
            case "Tidak Baik (< 10%)":
                return 2;
        }
        return 0;
    }
    
    public static int pencahayaan(String value) {
        switch (value) {
            case "Baik (60 - 120 Lux)":
                return 1;
            case "Tidak Baik (< 60 Lux atau > 120 Lux)":
                return 2;
        }
        return 0;
    }
    
    public static int kelembaban(String value) {
        switch (value) {
            case "Baik (40 - 70%)":
                return 1;
            case "Tidak Baik (< 40% atau > 70%)":
                return 2;
        }
        return 0;
    }
    
    public static int lantai(String value) {
        switch (value) {
            case "Keramik / Ubin":
                return 1;
            case "Semen":
                return 2;
            case "Tanah":
                return 3;
        }
        return 0;
    }
    
    public static int dinding(String value) {
        switch (value) {
            case "Permanen / Batu":
                return 1;
            case "Semi Permanen / Setengah Batu":
                return 2;
            case "Kayu / Bambu / Papan":
                return 3;
        }
        return 0;
    }
    
    public static int atap(String value) {
        switch (value) {
            case "Genting":
                return 1;
            case "Asbes / Seng":
                return 2;
        }
        return 0;
    }
}
