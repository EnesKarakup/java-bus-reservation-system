package com.otobusrezervasyon.service;

import com.otobusrezervasyon.model.Otobus;

import java.util.ArrayList;
import java.util.List;

public class OtobusServis {
    private List<Otobus> otobusler = new ArrayList<>();

    // Otobüs ekle
    public void otobusEkle(Otobus otobus) {
        otobusler.add(otobus);
        System.out.println("Otobüs eklendi: " + otobus.getPlaka());
    }

    // Otobüsleri listele
    public void otobusleriListele() {
        if (otobusler.isEmpty()) {
            System.out.println("Henüz otobüs eklenmemiş.");
            return;
        }
        for (Otobus o : otobusler) {
            o.otobusBilgileriniYazdir();
        }
    }

    // Plaka ile otobüs bul
    public Otobus otobusBul(String plaka) {
        for (Otobus o : otobusler) {
            if (o.getPlaka().equalsIgnoreCase(plaka)) {
                return o;
            }
        }
        System.out.println("Otobüs bulunamadı: " + plaka);
        return null;
    }

    // Koltukları listele (plaka ile)
    public void koltuklariListele(String plaka) {
        Otobus otobus = otobusBul(plaka);
        if (otobus != null) {
            System.out.println(" koltuk " + plaka + " plakalı otobüsün koltukları:");
            otobus.koltuklariListele();
        }
    }

    public List<Otobus> getOtobusler() {
        return otobusler;
    }
}
