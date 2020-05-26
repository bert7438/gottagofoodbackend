package ru.ggfteam.gottagofoodbackend;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ggfteam.gottagofoodbackend.entities.Product;
import ru.ggfteam.gottagofoodbackend.repositories.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
@RestController
public class ListMaker {
    Gson gson = new Gson();
    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/gen/listdev")
    public String genListDev(HttpServletRequest request, HttpServletResponse response){
        List<Product> main = new ArrayList<Product>();
        int[] mainID = new int[]{1,2,4,11,23,30,34,47,50,55,56,57,59};
        int[] supportID = new int[]{10,16,22,44,54};
        int[] drinkID = new int[]{13,27,33,40,48};
        int main_mealID = mainID[(int) (Math.random()*mainID.length)];
        int support_mealID = supportID[(int) (Math.random()*supportID.length)];
        int drink_mealID = drinkID[(int)(Math.random()*drinkID.length)];
        Product mainProduct = productRepository.getProduct(main_mealID);
        Product supportProduct = productRepository.getProduct(support_mealID);
        Product drinkProduct = productRepository.getProduct(drink_mealID);
        main.add(mainProduct);
        main.add(supportProduct);
        main.add(drinkProduct);
        return gson.toJson(main);
    }
}
