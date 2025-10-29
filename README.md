# Otobüs Rezervasyon Sistemi

## Proje Hakkında

Otobüs Rezervasyon Sistemi, şehirlerarası otobüs seferlerinin yönetimi ve bilet rezervasyonlarının yapılabildiği konsol tabanlı bir Java uygulamasıdır. Proje, **Nesne Yönelimli Programlama (OOP)** prensipleri ve **Katmanlı Mimari** yapısı kullanılarak geliştirilmiştir.

## Geliştirme Ekibi

Bu proje **5 kişilik** bir ekip tarafından geliştirilmiştir.

## Mimari Yapı

Proje, **3 Katmanlı Mimari (Layered Architecture)** kullanılarak tasarlanmıştır:

```
com.otobusrezervasyon
├── model.enums          # Enum tanımlamaları
├── model                # Entity sınıfları (Domain Layer)
├── service              # İş mantığı katmanı (Business Layer)
└── z.runner             # Uygulama başlatma katmanı (Presentation Layer)
```

### Katman Açıklamaları

#### 1️ Model Katmanı (Entity Layer)
Sistemdeki temel varlıkları ve enum tiplerini içerir:
- **Yolcu**: Yolcu bilgilerini tutar
- **Otobus**: Otobüs ve koltuk bilgilerini yönetir
- **Sefer**: Sefer detaylarını içerir
- **Koltuk**: Koltuk durumlarını yönetir
- **Rezervasyon**: Rezervasyon işlemlerini temsil eder

#### 2️ Service Katmanı (Business Layer)
İş mantığı ve CRUD operasyonlarını gerçekleştirir:
- **YolcuServis**: Yolcu işlemleri
- **OtobusServis**: Otobüs yönetimi
- **SeferServis**: Sefer yönetimi
- **RezervasyonServis**: Rezervasyon işlemleri

#### 3️ Runner Katmanı (Presentation Layer)
- **RezervasyonSistemi**: Ana uygulama ve kullanıcı arayüzü

## OOP Prensipleri

Projede kullanılan nesne yönelimli programlama prensipleri:

### 1. Encapsulation (Kapsülleme)
- Tüm sınıflarda `private` alanlar ve `public` getter/setter metodları kullanılmıştır
- İç yapı dışarıya kapatılmış, kontrollü erişim sağlanmıştır

### 2. Abstraction (Soyutlama)
- Service katmanı, iş mantığını model katmanından ayırarak soyutlama sağlar
- Kullanıcı, altta yatan karmaşık işlemlerden habersiz işlem yapar

### 3. Inheritance (Kalıtım)
- Enum yapıları ile tip güvenliği sağlanmıştır
- Ortak davranışlar üst seviyede tanımlanmıştır

### 4. Polymorphism (Çok Biçimlilik)
- Enum kullanımı ile farklı durumlar tek bir tip üzerinden yönetilir
- Method overloading ile esneklik sağlanmıştır

## UML Diyagramları

### Class Diagram
Projenin sınıf yapısını ve ilişkilerini gösteren detaylı UML diyagramı:

<img width="3703" height="3120" alt="UML class" src="https://github.com/user-attachments/assets/fff1b4fd-dea3-4e31-a750-38442b9d0e25" />

**Önemli İlişkiler:**
- `Sefer` → `Otobus`: 1-to-1 ilişki
- `Otobus` → `Koltuk`: 1-to-Many ilişki
- `Rezervasyon` → `Sefer`, `Yolcu`, `Koltuk`: Many-to-1 ilişkiler
- Service sınıfları → Model sınıfları: Dependency ilişkisi

### Package Diagram
Katmanlar arası ilişkileri ve bağımlılıkları gösteren mimari diyagram görselleştirilmiştir.

<img width="1023" height="642" alt="package diagram" src="https://github.com/user-attachments/assets/d2c69688-4447-4893-9494-55c7c385bc0e" />

## Özellikler

### Sefer İşlemleri
- ✅ Yeni sefer ekleme
- ✅ Mevcut seferleri listeleme
- ✅ Sefer doluluk durumunu görüntüleme
- ✅ Otobüs bilgilerini yönetme

### Rezervasyon İşlemleri
- ✅ Yeni rezervasyon yapma
- ✅ Rezervasyon iptali
- ✅ Tüm rezervasyonları listeleme
- ✅ Koltuk durumu kontrolü

### Yolcu İşlemleri
- ✅ Yeni yolcu kaydı
- ✅ Yolcu bilgilerini görüntüleme
- ✅ TC kimlik ile yolcu arama
- ✅ Yolcu listesi

## Teknolojiler

- **Java SE** (Core Java)
- **Java Time API** (LocalDate, LocalTime)
- **Collections Framework** (List, ArrayList)
- **Scanner** (Kullanıcı girişi)
- **Enum Types** (Tip güvenliği)

## 📦 Enum Yapıları

```java
// Cinsiyet durumları
Cinsiyet: ERKEK, KADIN

// Koltuk durumları
KoltukDurumu: BOS, DOLU

// Otobüs tipleri
OtobusTuru: STANDART, KONFOR

// Rezervasyon durumları
RezervasyonDurumu: AKTIF, IPTAL
```

## 🚀 Kurulum ve Çalıştırma

### Gereksinimler
- Java JDK 8 veya üzeri
- Herhangi bir Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Çalıştırma Adımları

1. Projeyi klonlayın veya indirin:
```bash
git clone [repository-url]
```

2. IDE'nizde projeyi açın

3. `RezervasyonSistemi.java` dosyasını çalıştırın:
```bash
java com.otobusrezervasyon.z.runner.RezervasyonSistemi
```

4. Ana menüden istediğiniz işlemi seçin

## 📖 Kullanım Örneği

### 1. Sefer Ekleme
```
Sefer İşlemleri > Yeni Sefer Ekle
- Sefer bilgilerini girin
- Otobüs detaylarını belirtin
- Sistem otomatik olarak koltukları oluşturur
```

### 2. Yolcu Kaydı
```
Yolcu İşlemleri > Yolcu Ekle
- TC kimlik numarası
- Ad, soyad, yaş
- Cinsiyet ve telefon bilgileri
```

### 3. Rezervasyon Yapma
```
Rezervasyon İşlemleri > Yeni Rezervasyon Yap
- Sefer seçimi
- Yolcu TC ile arama
- Boş koltuk seçimi
- Otomatik rezervasyon numarası
```

## 📁 Proje Yapısı

```
src/
└── com.otobusrezervasyon/
    ├── model/
    │   ├── enums/
    │   │   ├── Cinsiyet.java
    │   │   ├── KoltukDurumu.java
    │   │   ├── OtobusTuru.java
    │   │   └── RezervasyonDurumu.java
    │   ├── Koltuk.java
    │   ├── Otobus.java
    │   ├── Rezervasyon.java
    │   ├── Sefer.java
    │   └── Yolcu.java
    ├── service/
    │   ├── OtobusServis.java
    │   ├── RezervasyonServis.java
    │   ├── SeferServis.java
    │   └── YolcuServis.java
    └── z.runner/
        └── RezervasyonSistemi.java
```

## 🎨 Öne Çıkan Tasarım Desenleri

### Service Layer Pattern
Her entity için ayrı servis sınıfı oluşturulmuş, iş mantığı merkezi olarak yönetilmiştir.

### Repository Pattern (Light)
Service sınıfları `List<T>` koleksiyonları ile basit bir veri yönetimi sağlar.

### Single Responsibility Principle
Her sınıf tek bir sorumluluğa sahiptir ve bu sorumluluk net bir şekilde ayrılmıştır.

## 🔐 Validasyon ve Kontroller

- ✅ Dolu koltuk kontrolü
- ✅ Geçersiz sefer/yolcu kontrolü
- ✅ TC kimlik doğrulaması
- ✅ Enum değer kontrolü
- ✅ Rezervasyon durum kontrolü

## 📝 Lisans

Bu proje eğitim amaçlı geliştirilmiştir.

---
