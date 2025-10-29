package com.otobusrezervasyon.model;

import com.otobusrezervasyon.model.enums.OtobusTuru;
import java.util.ArrayList;
import java.util.List;

public class Otobus {
    private String plaka;
    private int kapasite;
    private String model;
    private OtobusTuru otobusTuru;
    private List<Koltuk> koltuklar;

    // Constructor
    public Otobus(String plaka, int kapasite, String model, OtobusTuru otobusTuru) {
        this.plaka = plaka;
        this.kapasite = kapasite;
        this.model = model;
        this.otobusTuru = otobusTuru;
        this.koltuklar = new ArrayList<>();

        // kapasiteye göre koltukları otomatik oluştur
        for (int i = 1; i <= kapasite; i++) {
            koltuklar.add(new Koltuk(i));
        }
    }

    // Metotlar
    public void otobusBilgileriniYazdir() {
        System.out.println("Plaka: " + plaka +
                ", Model: " + model +
                ", Kapasite: " + kapasite +
                ", Tür: " + otobusTuru);
    }

    // 👇 Koltuklarla ilgili yardımcı metotlar burada
    public Koltuk getKoltukByNo(int koltukNo) {
        for (Koltuk k : koltuklar) {
            if (k.getKoltukNo() == koltukNo) {
                return k;
            }
        }
        return null;
    }

    public void koltuklariListele() {
        for (Koltuk k : koltuklar) {
            k.koltukBilgileriniYazdir();
        }
    }

    // Getters & Setters
    public String getPlaka() { return plaka; }
    public void setPlaka(String plaka) { this.plaka = plaka; }

    public int getKapasite() { return kapasite; }
    public void setKapasite(int kapasite) { this.kapasite = kapasite; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public OtobusTuru getOtobusTuru() { return otobusTuru; }
    public void setOtobusTuru(OtobusTuru otobusTuru) { this.otobusTuru = otobusTuru; }

    public List<Koltuk> getKoltuklar() { return koltuklar; }
    public void setKoltuklar(List<Koltuk> koltuklar) { this.koltuklar = koltuklar; }
}
