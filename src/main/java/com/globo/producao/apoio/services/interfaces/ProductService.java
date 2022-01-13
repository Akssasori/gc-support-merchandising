package com.globo.producao.apoio.services.interfaces;

import com.globo.producao.apoio.models.Product;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;

import java.util.List;

public interface ProductService {

    Product save(Product product) throws InsertDataException;

    List<Product> findAll();

    Product findById(Long productId);

    Product update(Long productId,Product product);

    Product findByName (String name);

    void delete(Long productId);
}
