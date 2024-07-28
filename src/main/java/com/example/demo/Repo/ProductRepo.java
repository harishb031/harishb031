package com.example.demo.Repo;

import com.example.demo.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {

    Optional<Products> findById(Long id);

    List<Products> findAll();

    void deleteById(long id);

   // Products updateById(long id, Products products);
}
