package com.example.application.controller;

import com.example.application.model.personel.service.PersonelService;
import com.example.application.views.personel.PersonelView;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@UIScope
@Component
public class PersonelController {
    private final PersonelService personelService;

    public PersonelController(PersonelService personelService) {
        this.personelService = personelService;
    }

    public void initView(PersonelView view) {
        // verilerin initialize etme işlemi
        view.getGrid().setDataProvider(personelService.getDataProvider());

        // arama işlemi
        view.getNameSearch().addValueChangeListener(event ->
            view.getGrid().setDataProvider(personelService.getPersonelsDataProviderByName(event.getValue()))
        );

        // buton işlevi
        view.getRefreshButton().addClickListener(event -> personelService.addPersonel());
    }
}
