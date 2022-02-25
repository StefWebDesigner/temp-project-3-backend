package com.revature.controllers;

import com.revature.models.Category;
import com.revature.models.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class CategoryControllersTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void testGetCategoryById() throws Exception {
        Mockito.when(categoryService.getAllCategories().thenReturn(new Category(1, "Food")));

        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/products/category/1"));
        ra.andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.when(categoryService.getCategoryById(3).thenReturn(null));
        ra = mvc.perform(MockMvcRequestBuilders.get("/products/category/3"));
        ra.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
