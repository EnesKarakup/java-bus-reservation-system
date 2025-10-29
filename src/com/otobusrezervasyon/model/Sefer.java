package com.otobusrezervasyon.model;

import com.otobusrezervasyon.model.enums.KoltukDurumu;
import java.time.LocalDate;
import java.time.LocalTime;

public class Sefer {
    private int seferNo;
    private String kalkisYeri;
    private String varisYeri;
    private LocalDate tarih;
    private LocalTime saat;
    private double fiyat;
    private Otobus otobus;

    // Constructor
    public Sefer(int seferNo, String kalkisYeri, String varisYeri,
                 LocalDate tarih, LocalTime saat, double fiyat, Otobus otobus) {
        this.seferNo = seferNo;
        this.kalkisYeri = kalkisYeri;
        this.varisYeri = varisYeri;
        this.tarih = tarih;
        this.saat = saat;
        this.fiyat = fiyat;
        this.otobus = otobus;
    }

    // Metotlar
    public void seferBilgisiGoster() {
        System.out.println("Sefer No: " + seferNo +
                " | " + kalkisYeri + " → " + varisYeri +
                " | Tarih: " + tarih +
                " | Saat: " + saat +
                " | Fiyat: " + fiyat + "₺");
        otobus.otobusBilgileriniYazdir();
    }

    public boolean musaitMi(int koltukNo) {
        Koltuk koltuk = otobus.getKoltukByNo(koltukNo);
        return koltuk != null && koltuk.getDurum() == KoltukDurumu.BOS;
    }

    // Getters & Setters
    public int getSeferNo() { return seferNo; }
    public void setSeferNo(int seferNo) { this.seferNo = seferNo; }

    public String getKalkisYeri() { return kalkisYeri; }
    public void setKalkisYeri(String kalkisYeri) { this.kalkisYeri = kalkisYeri; }

    public String getVarisYeri() { return varisYeri; }
    public void setVarisYeri(String varisYeri) { this.varisYeri = varisYeri; }

    public LocalDate getTarih() { return tarih; }
    public void setTarih(LocalDate tarih) { this.tarih = tarih; }

    public LocalTime getSaat() { return saat; }
    public void setSaat(LocalTime saat) { this.saat = saat; }

    public double getFiyat() { return fiyat; }
    public void setFiyat(double fiyat) { this.fiyat = fiyat; }

    public Otobus getOtobus() { return otobus; }
    public void setOtobus(Otobus otobus) { this.otobus = otobus; }
}

