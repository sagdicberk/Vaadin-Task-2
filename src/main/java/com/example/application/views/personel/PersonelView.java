package com.example.application.views.personel;

import com.example.application.model.personel.Personel;
import com.example.application.service.PersonelService;
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


    public PersonelView(PersonelService service) {

        // personel clasına uygun bir grid oluşturma
        Grid<Personel> grid = new Grid<>(Personel.class);

        // TextField oluşturdum ve labelini tanımladım
        TextField nameSearch = new TextField("isim ile arama", event -> service.getPersonelsDataProviderByName(event.getValue()));

        // Vaadin butonu ile personel ekleme fonksiyonu çalıştırılması
        Button refreshButton = new Button("Yenile", click -> service.addPersonel());

        // Oluşturduğum giridin uzunluğunu ayarladım
        grid.setHeight("70vh");

        // Oluşturuduğum gridin hangi datayı kullanacağını belirledim
        grid.setDataProvider(service.getDataProvider());

        // Personel Modelinin Hangi fieldları göstereceğini belirledim.
        grid.setColumns("ad", "soyad");

        // Textfieldın genişliğini ayarladım
        nameSearch.setWidth("300px");

        // Buttonun Style özelliklerini değiştirerek daha büyük yaptım ve konumunu belirttim.
        refreshButton.getStyle()
                .set("position", "fixed")
                .set("bottom", "10px")
                .set("right", "10px")
                .set("width", "100px")
                .set("height", "50px");

        // oluşturduğum Grid, TextField ve Buttonu View'e ekledim.
        add(nameSearch, grid, refreshButton);
    }



}
