package com.heidsen.views.counter;

import com.heidsen.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.awt.*;

@PageTitle("Counter")
@Route(value = "start", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class BeerCounterView extends HorizontalLayout {

    private NumberField beerAmount;

    private Button oneFifthLiter;
    private Button oneThirdLiter;
    private Button halfLiter;

    private Button resetBeer;

    public BeerCounterView() {

        beerAmount = new NumberField();
        beerAmount.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
        beerAmount.setSizeFull();
        beerAmount.setReadOnly(true);
        beerAmount.setValue(0.0);

        oneFifthLiter = new Button("0,2l");
        oneFifthLiter.addClickListener(e -> {
            Notification.show("added 0,2l ");
            beerAmount.setValue(getCurrentBeerAmount() + 0.2);
        });
        oneThirdLiter = new Button("0,33l");
        oneThirdLiter.addClickListener(e -> {
            Notification.show("added 0,33l ");
            beerAmount.setValue(getCurrentBeerAmount() + 0.33);
        });
        halfLiter = new Button("0,5l");
        halfLiter.addClickListener(e -> {
            Notification.show("added 0,5l ");
            beerAmount.setValue(getCurrentBeerAmount() + 0.5);
        });
        resetBeer = new Button("Reset");
        resetBeer.addClickListener(e -> {
            beerAmount.setValue(0.0);
        });

        VerticalLayout layout = new VerticalLayout();
        layout.setHorizontalComponentAlignment(Alignment.CENTER, beerAmount, oneFifthLiter,
                oneThirdLiter, halfLiter, resetBeer);
        layout.add(beerAmount);
        layout.add(oneFifthLiter);
        layout.add(oneThirdLiter);
        layout.add(halfLiter);
        layout.add(resetBeer);

        add(layout);
    }

    private Double getCurrentBeerAmount() {
        return beerAmount.getValue() == null ? 0.0 : beerAmount.getValue();
    }
}
