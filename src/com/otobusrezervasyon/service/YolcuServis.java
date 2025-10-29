package com.otobusrezervasyon.service;

import com.otobusrezervasyon.model.Yolcu;
import java.util.ArrayList;
import java.util.List;

public class YolcuServis {
    private List<Yolcu> yolcular = new ArrayList<>();

    // Yolcu ekle
    public void yolcuEkle(Yolcu yolcu) {
        yolcular.add(yolcu);
        System.out.println("Yolcu eklendi: " + yolcu.getAd() + " " + yolcu.getSoyad());
    }

    // TC ile yolcu bul
    public Yolcu yolcuBul(String tcNo) {
        for (Yolcu y : yolcular) {
            if (y.getTcNo().equals(tcNo)) {
                return y;
            }
        }
        System.out.println("Yolcu bulunamadı: " + tcNo);
        return null;
    }

    // Yolcuları listele
    public void yolculariListele() {
        if (yolcular.isEmpty()) {
            System.out.println("Henüz yolcu eklenmemiş.");
            return;
        }
        for (Yolcu y : yolcular) {
            y.bilgileriGoster();
        }
    }

    public List<Yolcu> getYolcular() {
        return yolcular;
    }
}

