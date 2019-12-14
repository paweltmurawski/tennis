
package com.tennis;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    private Grid<Tennis_Products> grid = new Grid<>(Tennis_Products.class);
    private TextField filter = new TextField();

    public MainView() {
        grid.setColumns("product_name", "description", "product_price");
        add(grid);
        setSizeFull();
        filter.setPlaceholder("Filter by product name");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
    //    filter.addValueChangeListener(e -> updateTennisProducts());
        add(filter, grid);
    }
}
