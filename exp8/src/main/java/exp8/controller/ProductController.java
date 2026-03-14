package exp8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import exp8.entity.Product;
import exp8.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping("/category/{category}")
    public List<Product> findByCategory(@PathVariable String category) {
        return repository.findByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam double min, @RequestParam double max) {
        return repository.findByPriceBetween(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> sortedProducts() {
        return repository.sortByPrice();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price) {
        return repository.findExpensiveProducts(price);
    }
}