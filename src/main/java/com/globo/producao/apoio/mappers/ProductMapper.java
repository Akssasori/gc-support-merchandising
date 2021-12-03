package com.globo.producao.apoio.mappers;

import com.globo.producao.apoio.dtos.requests.ProductRequestDTO;
import com.globo.producao.apoio.dtos.response.ProductResponseDTO;
import com.globo.producao.apoio.models.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productRequestDTOToProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO productToProductResponseDTO(Product product);

    List<ProductResponseDTO> productListToProductResponseDTOList(List<Product> products);


}
