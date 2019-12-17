
package com.tennis;

import com.tennis.domain.TennisProductService;
import com.tennis.domain.TennisProducts;
import com.tennis.domain.TennisProductsForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    private TennisProductService tennisProductService = TennisProductService.getInstance();
    private Grid<TennisProducts> grid = new Grid<>(TennisProducts.class);
    private TextField filter = new TextField();
    private TennisProductsForm tennisProductsForm = new TennisProductsForm();
    private Button addNewProduct = new Button("Add new product");

    public MainView() {
        filter.setPlaceholder("Filter by product name");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> updateProducts());
        grid.setColumns("productName", "description", "productPrice");

        addNewProduct.addClickListener(e -> {
                    grid.asSingleSelect().clear();
                    tennisProductsForm.setTennisProducts(new TennisProducts());
                });

        HorizontalLayout toolbar = new HorizontalLayout(filter, addNewProduct);

        HorizontalLayout mainContent = new HorizontalLayout(grid, tennisProductsForm);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);
        tennisProductsForm.setTennisProducts(null);
        setSizeFull();
        refresh();

        grid.asSingleSelect().addValueChangeListener(event -> tennisProductsForm.setTennisProducts(grid.asSingleSelect().getValue()));
    }

    private void updateProducts() {
        grid.setItems(tennisProductService.findByProductName(filter.getValue()));
    }

    public void refresh() {
        grid.setItems(tennisProductService.getTennisProducts());
    }

}
