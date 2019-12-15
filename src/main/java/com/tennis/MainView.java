
package com.tennis;

import com.tennis.domain.TennisProductService;
import com.tennis.domain.TennisProducts;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    private TennisProductService tennisProductService = TennisProductService.getInstance();
    private Grid<TennisProducts> grid = new Grid<>(TennisProducts.class);

    public MainView() {
        grid.setColumns("productName", "description", "productPrice");
        add(grid);
        setSizeFull();
      ;
    }
}
