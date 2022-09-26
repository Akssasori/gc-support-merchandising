package com.globo.producao.apoio.controllers;

import com.globo.producao.apoio.dtos.requests.ProductRequestDTO;
import com.globo.producao.apoio.dtos.response.ProductResponseDTO;
import com.globo.producao.apoio.mappers.ProductMapper;
import com.globo.producao.apoio.models.Product;
import com.globo.producao.apoio.services.interfaces.ProductService;
import com.globo.producao.apoio.utils.exceptions.InsertDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    private final ProductMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {

        return ResponseEntity.ok().body(mapper.productListToProductResponseDTOList(new HashSet<>(service.findAll())));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable final Long id){
        return ResponseEntity.ok().body(mapper.productToProductResponseDTO(service.findById(id)));
    }

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProductResponseDTO> saveProduct
            (@Valid @RequestBody final ProductRequestDTO productRequestDTO) throws InsertDataException {

        return status(HttpStatus.CREATED).body(mapper.productToProductResponseDTO(
                service.save(mapper.productRequestDTOToProduct(productRequestDTO))));

    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct (@PathVariable("id") final Long id,
                                                             @Valid @RequestBody final ProductRequestDTO productRequestDTO){
        return ResponseEntity.ok().body(mapper.productToProductResponseDTO(service
                .update(id, mapper.productRequestDTOToProduct(productRequestDTO))));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete (@PathVariable("id") final Long id){

        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
