package com.tronin.spring.mvc.controllers;

import com.tronin.spring.mvc.model.Product;
import com.tronin.spring.mvc.services.ProductDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductDAOImpl productsDAO;

    @Autowired
    public ProductsController(ProductDAOImpl productsDAO) {
        this.productsDAO = productsDAO;
    }

    @GetMapping()
    public String index(Model model){
            model.addAttribute("prods", productsDAO.getAll());
        return "products/products";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") Integer id, Model model){
    model.addAttribute("product", productsDAO.getEntityById(id));
    return "products/show";
}

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("prod", new Product());
        return "products/new";
     }

    @PostMapping()
    public String createProduct(@ModelAttribute("prod") Product product) {
        productsDAO.create(product);
        return "redirect:/products";
    }

}
