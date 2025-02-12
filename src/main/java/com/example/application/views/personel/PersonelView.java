package com.example.application.views.personel;

import com.example.application.model.Personel;
import com.example.application.service.PersonelService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.util.List;

@PageTitle("Personel")
@Route("data-grid")
@Menu(order = 1, icon = LineAwesomeIconUrl.TH_SOLID)
public class PersonelView extends Div {
    private final ListDataProvider<Personel> dataProvider;

    public PersonelView(PersonelService service) {
        // Verinin servisten çekilmesi
        List<Personel> personels = service.getPersonels();
        // Gride uygun veriye çevirme
        dataProvider = new ListDataProvider<>(personels);
        // Grid oluşturup uygun veriyi verme
        Grid<Personel> grid = new Grid<>(Personel.class);
        grid.setItems(dataProvider);

        grid.setColumns("ad", "soyad");

        // Arama yapma alanı
        TextField nameSearch = new TextField();
        nameSearch.setPlaceholder("isim ile ara");
        nameSearch.addValueChangeListener(event -> {
            String searchTerm = event.getValue();
            dataProvider.setFilter(personel -> personel.getAd().toLowerCase().contains(searchTerm.toLowerCase()));
        });

        add(nameSearch, grid);
    }
}
