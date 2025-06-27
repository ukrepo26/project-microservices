package com.Genie.Swagger.Testing.Controller;

import com.Genie.Swagger.Testing.Entity.Product;
import com.Genie.Swagger.Testing.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API",description = "Operations related to product")
public class ProductController {

    @Autowired
   private ProductService productService;

  @GetMapping
  @Operation(summary = "get All products ",description = "return All Products")
    public List<Product>  getAllProduct()
    {
        System.out.println("get all product controller running..");
       return  productService.getAll();

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Product By Id",description = "returns Product by id")
    public  Product  getAllProductById(@PathVariable Long id)
    {
        System.out.println("get all product by Id controller running..");
         return productService.getProductById(id);

    }

    @PostMapping
    @Operation(summary = "Adding new product",description = "Add a new product")
    public Product  addProduct(@RequestBody Product product)
    {
         return productService.addProduct(product);
    }

}
