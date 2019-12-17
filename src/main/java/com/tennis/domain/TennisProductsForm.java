package com.tennis.domain;

import com.tennis.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class TennisProductsForm extends FormLayout {
    private TextField productName = new TextField("Product name");
    private TextField description = new TextField("Description");
    private TextField productPrice = new TextField("Product Price");
    private Button saveProduct = new Button("Save");
    private Button deleteProduct = new Button("Delete");
    private Binder<TennisProducts> binder = new Binder<>(TennisProducts.class);
    private TennisProductService tennisProductService = TennisProductService.getInstance();
    private MainView mainView;

    public TennisProductsForm() {
        HorizontalLayout buttons = new HorizontalLayout(saveProduct, deleteProduct);
        saveProduct.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(productName, description, productPrice, buttons);
        binder.bindInstanceFields(this);
        saveProduct.addClickListener(event -> save());
        deleteProduct.addClickListener(event -> delete());
    }

    private void save() {
        TennisProducts tennisProducts = binder.getBean();
        tennisProductService.save(tennisProducts);
        mainView.refresh();
        setTennisProducts(null);
    }

    private void delete() {
        TennisProducts tennisProducts = binder.getBean();
        tennisProductService.delete(tennisProducts);
        mainView.refresh();
        setTennisProducts(null);
    }

    public void setTennisProducts(TennisProducts tennisProducts) {
        binder.setBean(tennisProducts);

        if (tennisProducts == null) {
            setVisible(false);
        } else {
            setVisible(true);
            productName.focus();
        }
    }
}
