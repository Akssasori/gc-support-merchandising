package com.globo.producao.apoio.services.Impls;

import com.globo.producao.apoio.mappers.ProductMapper;
import com.globo.producao.apoio.models.Product;
import com.globo.producao.apoio.repositories.ProductRepository;
import com.globo.producao.apoio.services.interfaces.ProductService;
import com.globo.producao.apoio.utils.exceptions.DeleteDataException;
import com.globo.producao.apoio.utils.exceptions.NoEntityException;
import com.globo.producao.apoio.utils.exceptions.UpdateDataException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Product save(Product product) {

        Product productDB = repository.findByName(product.getName());

        if (Objects.nonNull(productDB) && Objects.equals(productDB.getName().trim().toUpperCase(), product.getName().trim().toUpperCase())){
            return productDB;
        } else {

            return repository.save(product);
        }

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

        Product productDB = repository.findByName(product.getName());

        if (Objects.nonNull(productDB) && Objects.equals(product.getName().trim().toUpperCase(), productDB.getName().trim().toUpperCase())){
            return productDB;
        } else {

            productDB.setId(productId);
            productDB.setName(product.getName());
            return repository.save(productDB);

        }

    }

    @Override
    public Product findByName(String name) {
        return repository.findByName(name.trim().toUpperCase());
    }

    @Override
    @SneakyThrows
    public void delete(Long productId) {
        try {
            if(repository.existsById(productId)){
                repository.deleteById(productId);
            } else {
                ResponseEntity.notFound();
            }
        } catch (Exception e) {
            throw new DeleteDataException(e.getMessage());
        }

    }
}
