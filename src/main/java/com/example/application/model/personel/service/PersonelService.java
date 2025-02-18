package com.example.application.model.personel.service;

import com.example.application.model.personel.Personel;
import com.vaadin.flow.data.provider.ListDataProvider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonelService {
    // personellerin tanımlanacağı listeyi oluşturdum
    private final List<Personel> personels;

    // Grid üzerinde kullanacağımız DataProviderı oluşturdum
    private final ListDataProvider<Personel> dataProvider;

    public PersonelService() {
        personels = new ArrayList<>();

        personels.add(new Personel("00000000001","Berk", "Sağdıç"));
        personels.add(new Personel("00000000010","İlyas", "Sağdıç"));
        personels.add(new Personel("00000000011","Patrick", "Jane"));
        personels.add(new Personel("00000000100","Chris", "Bum"));
        personels.add(new Personel("00000000101","Anderson", "Talisca"));
        personels.add(new Personel("00000000110","Edin", "Dzeko"));
        personels.add(new Personel("00000000111","Volcano", "Ironhand"));
        personels.add(new Personel("00000001000","Alfredo James", "Pacino"));
        personels.add(new Personel("00000001001","Ismail", "Eagle"));
        personels.add(new Personel("00000001010","Ihsan ", "Dogramaci"));

        // personel listemizi data providera ceviriyoruz.
        dataProvider = new ListDataProvider<>(personels);
    }

    public List<Personel> getPersonels() {
        return personels;
    }

    // personel ekleme işlemi
    public void addPersonel() {

        // burdaki idye benzer yapıya ihtiyac olmayabilir ama yine de ekledim.
        int id= personels.size();

        // Burada eklenecek personel bilgisi var. Sabit bir veri kullandım sadece yenile butonu ekleme işlemi olacağı için
        Personel newPerson = new Personel("1234567891" + id, "New", "Personel");

        // burda personel listesine ekliyoruz yeni personeli
        personels.add(newPerson);

        // Data Providerı yenileyerek yeni kullanıcın gözükmesini sağlıyoruz.
        dataProvider.refreshAll();
    }

    // Grid içerisine veriyi buradan alacağımız için bir get metodu tanımladım.
    public ListDataProvider<Personel> getDataProvider() {
        return dataProvider;
    }

    // arama işlemini de servis katmanında tanımlayarak passive view prensibine uygun hale getirdim.
    // Burada da TextFiel'dan alınan string stream methodları işle arama işlemi yapıyor.
    public ListDataProvider<Personel> getPersonelsDataProviderByName(String searchTerm) {
        dataProvider.setFilter(personel -> personel.getAd().toLowerCase().contains(searchTerm.toLowerCase()));
        return dataProvider;
    }
}
