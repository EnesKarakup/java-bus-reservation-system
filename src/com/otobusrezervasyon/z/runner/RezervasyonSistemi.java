package com.otobusrezervasyon.z.runner;

import com.otobusrezervasyon.model.*;
import com.otobusrezervasyon.model.enums.*;
import com.otobusrezervasyon.service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class RezervasyonSistemi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Servisler
        OtobusServis otobusServis = new OtobusServis();
        SeferServis seferServis = new SeferServis();
        YolcuServis yolcuServis = new YolcuServis();
        RezervasyonServis rezervasyonServis = new RezervasyonServis();

        int rezervasyonSayaci = 1;

        while (true) {
            // ANA MENÜ
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║        OTOBÜS REZERVASYON SİSTEMİ        ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.println("1. Sefer İşlemleri");
            System.out.println("2. Rezervasyon İşlemleri");
            System.out.println("3. Yolcu İşlemleri");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = sc.nextInt();
            sc.nextLine();

            switch (secim) {
                case 1: // SEFER İŞLEMLERİ
                    while (true) {
                        System.out.println("╔══════════════════════════════════════════╗");
                        System.out.println("║             SEFER İŞLEMLERİ              ║");
                        System.out.println("╚══════════════════════════════════════════╝");
                        System.out.println("1. Yeni Sefer Ekle");
                        System.out.println("2. Sefer Listele");
                        System.out.println("3. Sefer Doluluk Durumu");
                        System.out.println("4. Ana Menüye Dön");
                        System.out.print("Seçiminiz: ");

                        int altSecim = sc.nextInt();
                        sc.nextLine();

                        if (altSecim == 1) {
                            System.out.print("Sefer No: ");
                            int seferNo = sc.nextInt(); sc.nextLine();
                            System.out.print("Kalkış Yeri: ");
                            String kalkis = sc.nextLine();
                            System.out.print("Varış Yeri: ");
                            String varis = sc.nextLine();
                            System.out.print("Tarih (YYYY-AA-GG): ");
                            LocalDate tarih = LocalDate.parse(sc.nextLine());
                            System.out.print("Saat (SS:DD): ");
                            LocalTime saat = LocalTime.parse(sc.nextLine());
                            System.out.print("Fiyat: ");
                            double fiyat = sc.nextDouble(); sc.nextLine();

                            // Otobüs bilgileri
                            System.out.print("Otobüs Plakası: ");
                            String plaka = sc.nextLine();
                            System.out.print("Otobüs Markası: ");
                            String marka = sc.nextLine();
                            System.out.print("Koltuk Sayısı: ");
                            int koltukSayisi = sc.nextInt(); sc.nextLine();

                            OtobusTuru tur = null;
                            while (tur == null) {
                                System.out.print("Otobüs Türü (STANDART/KONFOR): ");
                                String turStr = sc.nextLine().toUpperCase();
                                try {
                                    tur = OtobusTuru.valueOf(turStr);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Geçersiz tür, tekrar deneyin.");
                                }
                            }

                            Otobus otobus = new Otobus(plaka, koltukSayisi, marka, tur);
                            otobusServis.otobusEkle(otobus);

                            Sefer yeniSefer = new Sefer(seferNo, kalkis, varis, tarih, saat, fiyat, otobus);
                            seferServis.seferEkle(yeniSefer);

                        } else if (altSecim == 2) {
                            seferServis.seferleriListele();
                        } else if (altSecim == 3) {
                            System.out.print("Sefer No: ");
                            int no = sc.nextInt(); sc.nextLine();
                            Sefer secilen = seferServis.seferBul(no);
                            if (secilen != null) {
                                System.out.println("Sefer " + no + " için koltuk durumu:");
                                secilen.getOtobus().koltuklariListele();
                            } else {
                                System.out.println("Sefer bulunamadı.");
                            }
                        } else if (altSecim == 4) {
                            break;
                        } else {
                            System.out.println("Geçersiz seçim.");
                        }
                    }
                    break;

                case 2: // REZERVASYON İŞLEMLERİ
                    while (true) {
                        System.out.println("╔══════════════════════════════════════════╗");
                        System.out.println("║          REZERVASYON İŞLEMLERİ           ║");
                        System.out.println("╚══════════════════════════════════════════╝");
                        System.out.println("1. Yeni Rezervasyon Yap");
                        System.out.println("2. Rezervasyon İptal Et");
                        System.out.println("3. Rezervasyonları Listele");
                        System.out.println("4. Ana Menüye Dön");
                        System.out.print("Seçiminiz: ");

                        int altSecim = sc.nextInt();
                        sc.nextLine();

                        if (altSecim == 1) {
                            System.out.print("Sefer No: ");
                            int seferNo = sc.nextInt(); sc.nextLine();
                            Sefer secilenSefer = seferServis.seferBul(seferNo);
                            if (secilenSefer == null) break;

                            System.out.print("TC No: ");
                            String tc = sc.nextLine();
                            Yolcu yolcu = yolcuServis.yolcuBul(tc);
                            if (yolcu == null) {
                                System.out.println("Yolcu bulunamadı, önce yolcu ekleyin.");
                                break;
                            }

                            System.out.print("Koltuk No: ");
                            int koltukNo = sc.nextInt(); sc.nextLine();
                            Koltuk koltuk = secilenSefer.getOtobus().getKoltukByNo(koltukNo);

                            rezervasyonServis.rezervasyonYap(rezervasyonSayaci++, secilenSefer, yolcu, koltuk);

                        } else if (altSecim == 2) {
                            System.out.print("İptal edilecek rezervasyon no: ");
                            int iptalNo = sc.nextInt(); sc.nextLine();
                            rezervasyonServis.rezervasyonIptalEt(iptalNo);

                        } else if (altSecim == 3) {
                            rezervasyonServis.rezervasyonlariListele();

                        } else if (altSecim == 4) {
                            break;
                        } else {
                            System.out.println("Geçersiz seçim.");
                        }
                    }
                    break;

                case 3: // YOLCU İŞLEMLERİ
                    while (true) {
                        System.out.println("╔══════════════════════════════════════════╗");
                        System.out.println("║             YOLCU İŞLEMLERİ              ║");
                        System.out.println("╚══════════════════════════════════════════╝");
                        System.out.println("1. Yolcu Ekle");
                        System.out.println("2. Yolcuları Listele");
                        System.out.println("3. Yolcu Bul (TC ile)");
                        System.out.println("4. Ana Menüye Dön");
                        System.out.print("Seçiminiz: ");

                        int altSecim = sc.nextInt();
                        sc.nextLine();

                        if (altSecim == 1) {
                            System.out.print("TC No: ");
                            String tc = sc.nextLine();
                            System.out.print("Ad: ");
                            String ad = sc.nextLine();
                            System.out.print("Soyad: ");
                            String soyad = sc.nextLine();
                            System.out.print("Yaş: ");
                            int yas = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Telefon: ");
                            String tel = sc.nextLine();

                            Cinsiyet cinsiyet = null;
                            while (cinsiyet == null) {
                                System.out.print("Cinsiyet (ERKEK/KADIN): ");
                                String cStr = sc.nextLine().toUpperCase();
                                try {
                                    cinsiyet = Cinsiyet.valueOf(cStr);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Geçersiz giriş, tekrar deneyin.");
                                }
                            }

                            Yolcu yolcu = new Yolcu(tc, ad, soyad, cinsiyet, yas, tel);
                            yolcuServis.yolcuEkle(yolcu);
                        } else if (altSecim == 2) {
                            yolcuServis.yolculariListele();

                        } else if (altSecim == 3) {
                            System.out.print("TC No: ");
                            String tc = sc.nextLine();
                            Yolcu bulunan = yolcuServis.yolcuBul(tc);
                            if (bulunan != null) {
                                bulunan.bilgileriGoster();
                            }
                        } else if (altSecim == 4) {
                            break; // Ana menüye dön
                        } else {
                            System.out.println("Geçersiz seçim.");
                        }
                    }
                    break;

                case 4: // ÇIKIŞ
                    System.out.println("👋 Görüşmek üzere!");
                    return;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
}
