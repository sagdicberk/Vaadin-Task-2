# Monad Task
![Proje Ekran Görüntüsü](ss/ss.png)
---

## 1. **Proje Kurulumu ve Vaadin Sayfalarının Oluşturulması**

İlk adımda, Vaadin Framework kullanarak aşağıdaki sayfalar oluşturdum:
- **Hello World**
- **About**

Bu sayfaların oluşturulmasının ardından, Vaadin arayüzü üzerinden **Personel** adında yeni bir tab ekledim. Bu tabın içeriğini doldurmak amacıyla uygulama dosyalarını indirdim.

---

## 2. **Projeyi Çalıştırmak için Yapılandırma**

1. İndirilen `.zip` uzantılı dosyayı **Intelij IDEA**'ya aktararak projeyi açtım.
2. **Maven** bağımlılıkları, **Java** sürümü ve **Spring** versiyonu kontrolü gerçekleştirdim.
3. Maven bağımlılıklarını tekrar yükleyerek projeyi başarıyla çalıştırdım.

---

## 3. **Model Katmanının Oluşturulması**

Uygulama yapısında **model** adında bir paket oluşturdum. Bu pakette **Personel.java** adında bir sınıf oluşturup, personel verisini modellemek için aşağıdaki alanları tanımladım:

- `String TC`
- `String Ad`
- `String Soyad`

Ayrıca, bu sınıfa gerekli **getter** ve **setter** metodlarını ekleyerek, veri manipülasyonunu mümkün kıldım.

---

## 4. **Servis Katmanının Eklenmesi**

MVC mimarisine uygun olarak, **service** katmanını eklemem gerekti. Bu sebeple:
1. **service** adında bir paket oluşturdum.
2. **PersonelService.java** dosyasını oluşturup, 10 adet personel verisini tanımladım.
3. Bu verilere erişebilmek için **getPersonels** metodunu servis katmanına ekledim.

---

## 5. **Personel Grid ve Arama Kutusunun Eklenmesi**

Personel View'ini Vaadin üzerinden boş olarak oluşturduktan sonra, aşağıdaki adımları takip ettim:
- **Grid**: Personel verilerini gösterecek şekilde yapılandırıldı.
- **Arama Kutusu (Search Box)**: Kullanıcıların personel adlarına göre arama yapabilmesini sağlamak için Vaadin TextField kullanarak bir arama kutusu ekledim.

Vaadin dökümantasyonlarından yararlanarak gerekli Grid ve Arama kutusu bileşenlerini entegre ettim.
