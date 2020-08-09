package org.vtb.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.vtb.edu.database.dto.Product;
import org.vtb.edu.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProduct(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "all_products";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping({"/product/{id}", "/product"})
    public String showProduct(@PathVariable(required = false) Long id, Model model) {
        if (id == null) id = 0L;
        Product product = productService.getProductById(id);
        model.addAttribute("frontProduct", product);
        return "product";
    }
}
