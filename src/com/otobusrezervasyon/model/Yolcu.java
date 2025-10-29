package com.otobusrezervasyon.model;

import com.otobusrezervasyon.model.enums.Cinsiyet;

public class Yolcu {
    private String tcNo;
    private String ad;
    private String soyad;
    private Cinsiyet cinsiyet;
    private int yas;
    private String telefon;

    // Constructor
    public Yolcu(String tcNo, String ad, String soyad, Cinsiyet cinsiyet, int yas, String telefon) {
        this.tcNo = tcNo;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
        this.telefon = telefon;
    }

    // Metotlar
    public void bilgileriGoster() {
        System.out.println("TC: " + tcNo +
                ", Ad: " + ad +
                ", Soyad: " + soyad +
                ", Cinsiyet: " + cinsiyet +
                ", Yaş: " + yas +
                ", Telefon: " + telefon);
    }

    public void bilgileriGuncelle(String ad, String soyad, int yas, String telefon) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.telefon = telefon;
    }

    // Getters & Setters
    public String getTcNo() { return tcNo; }
    public void setTcNo(String tcNo) { this.tcNo = tcNo; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public Cinsiyet getCinsiyet() { return cinsiyet; }
    public void setCinsiyet(Cinsiyet cinsiyet) { this.cinsiyet = cinsiyet; }

    public int getYas() { return yas; }
    public void setYas(int yas) { this.yas = yas; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
}
