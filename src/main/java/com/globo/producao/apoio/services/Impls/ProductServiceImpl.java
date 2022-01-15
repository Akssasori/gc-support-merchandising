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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    @SneakyThrows
    public Product save(Product product) {

        Optional<Product> productDB;

        try {

            productDB = repository.findByName(product.getName());

            if (productDB.isPresent()) {

                if (!product.getName().isEmpty() && Objects.equals(productDB.get().getName().trim().toUpperCase(),
                        product.getName().trim().toUpperCase())) {
                    return productDB.get();
                }

            } else {
                if (Objects.isNull(product.getName()) || product.getName().trim().isEmpty()) {
                    Product productDefault = repository.findById(1L).get();
                    return productDefault;

                } else {
                    return repository.save(product);

                }
            }

        } catch (Exception e) {
            throw new InsertDataException(e.getMessage());
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

        Optional<Product> productDB;

        try {
            productDB = repository.findById(productId);

            if (productDB.isPresent()) {

                if (Objects.isNull(product.getName())) {

                    Product productDefault = repository.findById(1L).get();
                    return productDefault;
                }

                if (Objects.equals(product.getName().trim().toUpperCase(),
                        productDB.get().getName().trim().toUpperCase())) {
                    return productDB.get();
                }

                if (product.getName().trim().isEmpty()) {
                    return productDB.get();

                } else {
                    productDB.get().setId(productId);
                    productDB.get().setName(product.getName());
                    return repository.save(productDB.get());
                }
            } else {
                return productDB.get();
            }

        } catch (Exception e) {
            throw new UpdateDataException( e.getMessage());
        }


    }

    @Override
    public Product findByName(String name) {
        return repository.findByName(name.trim().toUpperCase()).get();
    }

    @Override
    @SneakyThrows
    public void delete(Long productId) {
        try {
            if (repository.existsById(productId)) {
                repository.deleteById(productId);
            } else {
                ResponseEntity.notFound();
            }
        } catch (Exception e) {
            throw new DeleteDataException(e.getMessage());
        }

    }
}
