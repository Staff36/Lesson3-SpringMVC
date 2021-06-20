package com.tronin.spring.mvc.services;


import com.tronin.spring.mvc.model.Counter;
import com.tronin.spring.mvc.model.Product;
import com.tronin.spring.mvc.repositories.Products;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductDAOImpl implements IDAO<Product, Integer> {

    @Autowired
    Products products;
    List<Product> productList;
    @Autowired
    Counter counter;


    @PostConstruct
    public void init(){
        productList = products.getProductList();
    }

    @Override
    public boolean create(Product entity) {
        entity.setId(counter.incrementAndAssign());
        if (productList.stream()
                .anyMatch(x -> x.getName().equals(entity.getName()))){
            return false;
        }
        productList.add(entity);
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        return productList.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public Product getEntityById(Integer id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product update(Product entity, Integer id) {
        productList.stream().filter(product -> product.getId().equals(entity.getId()))
                .forEach(product -> product = entity);
        return getEntityById(entity.getId());
    }

    @Override
    public List<Product> getAll() {
        return Collections.unmodifiableList(productList);
    }
}
