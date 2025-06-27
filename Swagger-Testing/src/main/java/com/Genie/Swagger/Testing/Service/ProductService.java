package com.Genie.Swagger.Testing.Service;

import com.Genie.Swagger.Testing.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    Product product1=new Product(1L,"AC",40000);
    Product product2=new Product(2L,"TV",30000);

    List<Product> list=new ArrayList<>();


    public List<Product> getAll()
{
    System.out.println("get all product service running..");
    list.add(product1);
    list.add(product2);
    return list;
}

public Product getProductById(Long id)
{
    System.out.println("get all product by Id service running..");
    return new Product(id,"Demo product",122112);
}

public Product addProduct(Product product)
{
    return product;
}



}
