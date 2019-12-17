package com.tennis.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        tennisProducts.add(new TennisProducts("Babolat Aero Team", "Babolat racket", "650"));
        tennisProducts.add(new TennisProducts("Head Graphene", "Head racket", "570"));
        tennisProducts.add(new TennisProducts("Wilson Autograph", "Wilson racket", "560"));
        tennisProducts.add(new TennisProducts("Babolat Roland Garros", "Babolat tennis balls", "30"));
        tennisProducts.add(new TennisProducts("Head Tour", "Head tennis balls", "31"));
        return tennisProducts;
    }

    public Set<TennisProducts> findByProductName(String productName) {
        return tennisProducts.stream().filter(tennisProducts -> tennisProducts.getProductName().contains(productName)).collect(Collectors.toSet());
    }

    public void save(TennisProducts tennisProducts) {
        this.tennisProducts.add(tennisProducts);
    }

    public void delete(TennisProducts tennisProducts) {
        this.tennisProducts.remove(tennisProducts);
    }
}

