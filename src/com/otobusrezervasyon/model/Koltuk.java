package com.otobusrezervasyon.model;

import com.otobusrezervasyon.model.enums.KoltukDurumu;

public class Koltuk {
    private int koltukNo;
    private KoltukDurumu durum;

    // Constructor
    public Koltuk(int koltukNo) {
        this.koltukNo = koltukNo;
        this.durum = KoltukDurumu.BOS; // varsayılan olarak boş
    }

    // Metotlar
    public void koltukBilgileriniYazdir() {
        System.out.println("Koltuk No: " + koltukNo + " | Durum: " + durum);
    }

    public void durumunuGuncelle(KoltukDurumu yeniDurum) {
        this.durum = yeniDurum;
    }

    // Getters & Setters
    public int getKoltukNo() { return koltukNo; }
    public void setKoltukNo(int koltukNo) { this.koltukNo = koltukNo; }

    public KoltukDurumu getDurum() { return durum; }
    public void setDurum(KoltukDurumu durum) { this.durum = durum; }
}
