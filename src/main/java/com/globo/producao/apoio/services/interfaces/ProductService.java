package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.models.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findById(Long productId);

    Product update(Long productId,Product product);

    Product findByName (String name);

    void delete(Long productId);
}
