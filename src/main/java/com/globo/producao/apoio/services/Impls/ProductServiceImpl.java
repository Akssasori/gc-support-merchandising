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

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
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

        Product productDB = repository.findById(productId).orElseThrow(() -> new NoEntityException(productId.toString()));

        try {
            productDB.setId(productId);
            productDB.setName(product.getName());
            return repository.save(productDB);
        } catch (Exception e) {
            throw new UpdateDataException(e.getMessage());
        }
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
