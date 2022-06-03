package com.platzimarket.web.controller;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @GetMapping("/scarse/{quantity}")
    public Optional<List<Product>> getScarseProducts(@PathVariable("quantity") int quantity){
        return productService.getScarseProducts(quantity);
    }

    @GetMapping("price/{price}")
    public List<Product> findByPrice(@PathVariable("price") double price){
        return productService.findByPrice(price);
    }

    //alt + j = Seleccion multilinea
    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
