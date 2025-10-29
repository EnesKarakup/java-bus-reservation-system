package com.otobusrezervasyon.model;

import com.otobusrezervasyon.model.enums.RezervasyonDurumu;

public class Rezervasyon {
    private int rezervasyonNo;
    private Sefer sefer;
    private Yolcu yolcu;
    private Koltuk koltuk;
    private RezervasyonDurumu durum;

    // Constructor
    public Rezervasyon(int rezervasyonNo, Sefer sefer, Yolcu yolcu, Koltuk koltuk) {
        this.rezervasyonNo = rezervasyonNo;
        this.sefer = sefer;
        this.yolcu = yolcu;
        this.koltuk = koltuk;
        this.durum = RezervasyonDurumu.AKTIF; // varsayılan aktif
    }

    // Metotlar
    public void rezervasyonDetay() {
        System.out.println("Rezervasyon No: " + rezervasyonNo +
                " | Sefer: " + sefer.getSeferNo() +
                " | Yolcu: " + yolcu.getAd() + " " + yolcu.getSoyad() +
                " | Koltuk: " + koltuk.getKoltukNo() +
                " | Durum: " + durum);
    }

    public void iptalEt() {
        this.durum = RezervasyonDurumu.IPTAL;
        koltuk.setDurum(com.otobusrezervasyon.model.enums.KoltukDurumu.BOS);
    }

    // Getters & Setters
    public int getRezervasyonNo() { return rezervasyonNo; }
    public void setRezervasyonNo(int rezervasyonNo) { this.rezervasyonNo = rezervasyonNo; }

    public Sefer getSefer() { return sefer; }
    public void setSefer(Sefer sefer) { this.sefer = sefer; }

    public Yolcu getYolcu() { return yolcu; }
    public void setYolcu(Yolcu yolcu) { this.yolcu = yolcu; }

    public Koltuk getKoltuk() { return koltuk; }
    public void setKoltuk(Koltuk koltuk) { this.koltuk = koltuk; }

    public RezervasyonDurumu getDurum() { return durum; }
    public void setDurum(RezervasyonDurumu durum) { this.durum = durum; }
}
