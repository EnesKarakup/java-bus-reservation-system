package com.otobusrezervasyon.service;

import com.otobusrezervasyon.model.*;
import com.otobusrezervasyon.model.enums.KoltukDurumu;
import com.otobusrezervasyon.model.enums.RezervasyonDurumu;

import java.util.ArrayList;
import java.util.List;

public class RezervasyonServis {
    private List<Rezervasyon> rezervasyonlar = new ArrayList<>();

    // Rezervasyon yap
    public Rezervasyon rezervasyonYap(int rezervasyonNo, Sefer sefer, Yolcu yolcu, Koltuk koltuk) {
        if (koltuk == null) {
            System.out.println("Geçersiz koltuk numarası!");
            return null;
        }

        if (koltuk.getDurum() == KoltukDurumu.DOLU) {
            System.out.println("Bu koltuk zaten dolu!");
            return null;
        }

        // Koltuğu rezerve et
        koltuk.setDurum(KoltukDurumu.DOLU);

        Rezervasyon rezervasyon = new Rezervasyon(rezervasyonNo, sefer, yolcu, koltuk);
        rezervasyonlar.add(rezervasyon);

        System.out.println("Rezervasyon başarıyla yapıldı!");
        rezervasyon.rezervasyonDetay();
        return rezervasyon;
    }

    // Rezervasyon iptal et
    public void rezervasyonIptalEt(int rezervasyonNo) {
        for (Rezervasyon r : rezervasyonlar) {
            if (r.getRezervasyonNo() == rezervasyonNo && r.getDurum() == RezervasyonDurumu.AKTIF) {
                r.iptalEt();
                System.out.println("Rezervasyon iptal edildi: " + rezervasyonNo);
                return;
            }
        }
        System.out.println("Rezervasyon bulunamadı veya zaten iptal edilmiş.");
    }

    // Rezervasyonları listele
    public void rezervasyonlariListele() {
        if (rezervasyonlar.isEmpty()) {
            System.out.println("Henüz rezervasyon yapılmamış.");
            return;
        }
        for (Rezervasyon r : rezervasyonlar) {
            r.rezervasyonDetay();
        }
    }

    public List<Rezervasyon> getRezervasyonlar() {
        return rezervasyonlar;
    }
}
