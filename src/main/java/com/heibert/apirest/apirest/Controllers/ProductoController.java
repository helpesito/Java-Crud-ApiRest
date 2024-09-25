package com.heibert.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heibert.apirest.apirest.Repositories.ProductRepository;
import com.heibert.apirest.apirest.Entities.Product;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productUpdate){
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));

        product.setName(productUpdate.getName());
        product.setPrice(productUpdate.getPrice());

        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el id: " + id));

        productRepository.delete(product);
        return "El producto con el ID: " + id + "fue eliminado correctamente.";

    }


}
