package ru.ggfteam.gottagofoodbackend.repositories;

import org.springframework.jdbc.core.RowMapper;
import ru.ggfteam.gottagofoodbackend.entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductID(rs.getInt("productID"));
        product.setName(rs.getString("name"));
        product.setSize(rs.getString("size"));
        product.setEnergy_value(rs.getDouble("energy_value"));
        product.setProteins(rs.getDouble("proteins"));
        product.setFats(rs.getDouble("fats"));
        product.setCarbohydrates(rs.getDouble("carbohydrates"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}
