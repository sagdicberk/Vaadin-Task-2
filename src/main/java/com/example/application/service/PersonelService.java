package com.example.application.service;

import com.example.application.model.Personel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonelService {

    private final List<Personel> personels;

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
    }

    public List<Personel> getPersonels() {
        return personels;
    }

}
