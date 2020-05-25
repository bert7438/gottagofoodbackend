package ru.ggfteam.gottagofoodbackend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ggfteam.gottagofoodbackend.entities.Product;

import java.util.List;

@Component
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createProduct(String name, String size, double ev, double prot, double f, double carb){
        return jdbcTemplate.update(
                "INSERT INTO products VALUES(default, ?, ?, ?, ? , ?, ?)", name, size, ev, prot, f, carb);
    }

    public int deleteProduct(Integer productID){
        return jdbcTemplate.update(
                "DELETE FROM products WHERE \"productID\" = ?", productID);
    }

    public Product getProduct(Integer productID){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM products WHERE \"productID\" = ?", new ProductsMapper(), productID);
    }

    public List<Product> getProducts(){
        return jdbcTemplate.query(
                "SELECT * FROM products", new ProductsMapper());
    }
}
