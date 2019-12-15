package com.tennis.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TennisProductService {
    private Set<TennisProducts> tennisProducts;
    private static TennisProductService tennisProductService;

    private TennisProductService() {
        this.tennisProducts = getTennisProductsBase();
    }

    public static TennisProductService getInstance() {
        if (tennisProductService == null) {
            tennisProductService = new TennisProductService();
        }
        return tennisProductService;
    }

    public Set<TennisProducts> getTennisProducts() {
        return new HashSet<>(tennisProducts);
    }

    public void addTennisProduct(TennisProducts tennisProducts) {
        this.tennisProducts.add(tennisProducts);
    }

    private Set<TennisProducts> getTennisProductsBase() {
        Set<TennisProducts> tennisProducts = new HashSet<>();
        tennisProducts.add(new TennisProducts("Babolat Aero Team", "Babolat racket", new BigDecimal(650)));
        tennisProducts.add(new TennisProducts("Head Graphene", "Head racket", new BigDecimal(570)));
        tennisProducts.add(new TennisProducts("Wilson Autograph", "Wilson racket", new BigDecimal(550)));
        tennisProducts.add(new TennisProducts("Babolat Roland Garros", "Babolat tennis balls", new BigDecimal(31)));
        tennisProducts.add(new TennisProducts("Head Tour", "Head tennis balls", new BigDecimal(30)));
        return tennisProducts;
    }
}

