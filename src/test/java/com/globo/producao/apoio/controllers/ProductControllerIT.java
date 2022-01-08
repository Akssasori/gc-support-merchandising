package com.globo.producao.apoio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globo.producao.apoio.config.BaseTest;
import com.globo.producao.apoio.fakerModal.ProductFaker;
import com.globo.producao.apoio.fakerModal.ProgramFaker;
import com.globo.producao.apoio.mappers.ProductMapper;
import com.globo.producao.apoio.services.interfaces.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProductControllerIT extends BaseTest {

    private final String URI_LIST_PRODUCT = "/product";
    private final String URI_PRODUCT_BY_ID = "/product/1";
    private final String URI_SAVE_PRODUCT = "/product/save";
    private final String URI_DELETE = "/product/1";
    private final String URI_UPDATE = "/product/1";


    @MockBean
    ProductService service;

    @MockBean
    ProductMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return list products with success.")
    public void shouldReturnListProductResponseDtoWithSuccess() throws Exception {

        doReturn(List.of(ProductFaker.getProduct())).when(service).findAll();

        mockMvc.perform(get(URI_LIST_PRODUCT)).andExpect(status().isOk());
    }
    @Test
    @DisplayName("Should return one product when pass id.")
    public void shouldReturnProductFindByIdWithSuccess() throws Exception {

        doReturn(ProductFaker.getProduct()).when(service).findById(1L);

        mockMvc.perform(get(URI_PRODUCT_BY_ID)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should save product with success.")
    public void shouldReturnProductSavedWithSuccess() throws Exception {

        doReturn(ProductFaker.getProduct()).when(service).save(ProductFaker.getProduct());

        mockMvc.perform(post(URI_SAVE_PRODUCT)
                        .content(new ObjectMapper().writeValueAsString(ProductFaker.getProduct()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should delete program with success.")
    public void shouldDeleteProductWithSuccess() throws Exception {

        doNothing().when(service).delete(1L);

        mockMvc.perform(delete(URI_DELETE)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should update with success.")
    public void shouldReturnUpdateProductWithSuccess() throws Exception {

        doReturn(ProductFaker.getProduct()).when(service).update(1L,ProductFaker.getProduct());

        mockMvc.perform(put(URI_UPDATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(ProductFaker.getProduct())))
                .andExpect(status().isOk());


    }


}
