package com.example.application.views.personel;

import com.example.application.controller.PersonelController;
import com.example.application.model.personel.Personel;
import com.example.application.model.personel.service.PersonelService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Personel")
@Route("data-grid")
@Menu(order = 1, icon = LineAwesomeIconUrl.TH_SOLID)
public class PersonelView extends Div {

    private final Grid<Personel> grid = new Grid<>(Personel.class);

    private final TextField nameSearch = new TextField("isim ile arama");

    private final Button refreshButton = new Button("Yenile");


    public PersonelView(PersonelController controller) {
        UIStyleConfig();
        controller.initView(this);
    }

    private void UIStyleConfig(){
        grid.setHeight("70vh");
        grid.setColumns("ad", "soyad");

        nameSearch.setWidth("300px");

        refreshButton.getStyle()
                .set("position", "fixed")
                .set("bottom", "10px")
                .set("right", "10px")
                .set("width", "100px")
                .set("height", "50px");

        add(nameSearch, grid, refreshButton);
    }

    public Grid<Personel> getGrid() {
        return grid;
    }

    public Button getRefreshButton() {
        return refreshButton;
    }

    public TextField getNameSearch() {
        return nameSearch;
    }
}
