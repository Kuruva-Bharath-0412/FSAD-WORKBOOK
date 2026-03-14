package exp8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import exp8.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Derived queries
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL queries
    @Query("SELECT p FROM Product p ORDER BY p.price")
    List<Product> sortByPrice();

    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findExpensiveProducts(double price);

    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> findProductsByCategory(String category);
}