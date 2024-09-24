package com.heibert.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heibert.apirest.apirest.Entities.Product;

public interface ProductRepository  extends JpaRepository <Product, Long>{

    

}
