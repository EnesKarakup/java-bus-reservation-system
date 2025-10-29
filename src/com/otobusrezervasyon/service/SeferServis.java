package com.otobusrezervasyon.service;

import com.otobusrezervasyon.model.Sefer;
import java.util.ArrayList;
import java.util.List;

public class SeferServis {
    private List<Sefer> seferler = new ArrayList<>();

    // Sefer ekle
    public void seferEkle(Sefer sefer) {
        seferler.add(sefer);
        System.out.println("Sefer eklendi: " + sefer.getSeferNo());
    }

    // Seferleri listele
    public void seferleriListele() {
        if (seferler.isEmpty()) {
            System.out.println("Henüz sefer eklenmemiş.");
            return;
        }
        for (Sefer s : seferler) {
            s.seferBilgisiGoster();
        }
    }

    // Seferi numarasına göre getir
    public Sefer seferBul(int seferNo) {
        for (Sefer s : seferler) {
            if (s.getSeferNo() == seferNo) {
                return s;
            }
        }
        System.out.println("Sefer bulunamadı: " + seferNo);
        return null;
    }

    public List<Sefer> getSeferler() {
        return seferler;
    }
}
