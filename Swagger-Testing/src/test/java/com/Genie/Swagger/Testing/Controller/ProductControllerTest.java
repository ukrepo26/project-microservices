package com.Genie.Swagger.Testing.Controller;

import com.Genie.Swagger.Testing.Entity.Product;
import com.Genie.Swagger.Testing.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
  private ProductController productController;

    @BeforeEach
   void setup()
    {
        System.out.println("Hello buddy i am running..");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllProduct() {
        List<Product> moklist = List.of(
                new Product(1L, "pen", 10),
                new Product(2L, "NoteBook", 30)
        );

        when(productService.getAll()).thenReturn(moklist);
    List<Product> allProduct= productController.getAllProduct();

    assertEquals(2,allProduct.size());
    assertEquals("pen", allProduct.get(0).getName());

    }

    @Test
    void testGetProductById()
    {
        Product product=new Product(4L,"Laptop",100000);
        when(productService.getProductById(4L)).thenReturn(product);

        Product productById=productController.getAllProductById(4L);
        assertEquals("Laptop",productById.getName());
        assertEquals(100000,productById.getPrice());


    }

}
