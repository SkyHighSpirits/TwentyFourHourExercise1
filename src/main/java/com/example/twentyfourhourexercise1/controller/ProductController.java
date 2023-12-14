package com.example.twentyfourhourexercise1.controller;

import com.example.twentyfourhourexercise1.model.Product;
import com.example.twentyfourhourexercise1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@CrossOrigin
@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/getallproducts")
    public ResponseEntity<List<Product>> getAllProduct()
    {
        try {
            List<Product> products = productRepository.findAll();
            return ResponseEntity.ok(products);
        } catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getproduct")
    public ResponseEntity<Product> getProduct(@RequestParam int id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent())
        {
            try {
                return ResponseEntity.ok(product.get());
            } catch (Exception e)
            {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getproductbyname")
    public ResponseEntity<Product> getProductByName(@RequestParam String name)
    {
        try {
            Product product = productRepository.findProductByName(name);
            return ResponseEntity.ok(product);
        } catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/addproduct")
    public ResponseEntity<String> addProduct(@RequestParam String name, @RequestParam float price, @RequestParam int weight)
    {
        try
        {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setWeight(weight);
            productRepository.save(product);
            return ResponseEntity.ok("Product Successfully Added");
        } catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @PutMapping("/updateproduct")
    public ResponseEntity<String> updateProduct(@RequestParam int id, @RequestParam String name, @RequestParam float price, @RequestParam int weight)
    {
        try
        {
            Product productToUpdate = productRepository.findById(id).get();
            productToUpdate.setName(name);
            productToUpdate.setPrice(price);
            productToUpdate.setWeight(weight);
            productRepository.save(productToUpdate);
            return ResponseEntity.ok("Product Successfully Updated");
        } catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteproduct")
    public ResponseEntity<String> deleteProduct(@RequestParam int id)
    {
        try
        {
            Optional<Product> checkProduct = productRepository.findById(id);

            if (checkProduct.isPresent()) {
                productRepository.deleteById(id);
                return ResponseEntity.ok("Product deleted");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }



}
