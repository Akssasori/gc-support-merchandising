package com.globo.producao.apoio.services.Impls;


import com.globo.producao.apoio.models.Product;
import com.globo.producao.apoio.repositories.ProductRepository;
import com.globo.producao.apoio.services.interfaces.ProductService;
import com.globo.producao.apoio.utils.exceptions.DeleteDataException;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import com.globo.producao.apoio.utils.exceptions.NoEntityException;
import com.globo.producao.apoio.utils.exceptions.UpdateDataException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    public static final long DEFAULT_REPOSITORY = 1L;

    private final ProductRepository repository;

    @Override
    @SneakyThrows
    public Product save(Product product) {

        var productDB = repository.findByName(product.getName());

        if (productDB.isPresent()) {

            if (Objects.equals(productDB.get().getName().trim().toUpperCase(),
                    product.getName().trim().toUpperCase())) {
                return productDB.get();
            }

        } else {
            if (StringUtils.isBlank(product.getName())) {
                return repository.findById(DEFAULT_REPOSITORY).get();

            } else {
                return repository.save(product);

            }
        }

        return productDB.get();

    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long productId) {
        return repository.findById(productId).orElseThrow(() -> new NoEntityException(productId.toString()));
    }

    @Override
    @SneakyThrows
    public Product update(Long productId, Product product) {

        var productDB = repository.findById(productId).orElseThrow(() -> new NoEntityException(productId.toString()));

        if (Objects.equals(product.getName().trim().toUpperCase(),
                productDB.getName().trim().toUpperCase())) {
            return productDB;

        } else {
            productDB.setId(productId);
            productDB.setName(product.getName());
            return repository.save(productDB);
        }


    }

    @Override
    public Product findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new NoEntityException(name));
    }

    @Override
    @SneakyThrows
    public void delete(Long productId) {

        if (repository.existsById(productId)) {
            repository.deleteById(productId);
        } else {
            throw new NoEntityException(productId.toString());
        }
    }


}
