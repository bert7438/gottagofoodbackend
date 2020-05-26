package ru.ggfteam.gottagofoodbackend;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ggfteam.gottagofoodbackend.entities.Product;
import ru.ggfteam.gottagofoodbackend.entities.User;
import ru.ggfteam.gottagofoodbackend.repositories.ProductRepository;
import ru.ggfteam.gottagofoodbackend.repositories.UserRepository;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
@RestController
public class DBInterface extends HttpServlet {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    Gson gson = new Gson();
    @RequestMapping("/user/add")
    public String addUser(HttpServletRequest request, HttpServletResponse response){
        if(!request.getParameter("name").equals("")){
            String name = request.getParameter("name");
            userRepository.createUser(name);
            return "Entry to DB added, name = " + name;
        }
        else
            return "No POST data name";
    }

    @RequestMapping("/user/del")
    public String deleteUser(HttpServletRequest request, HttpServletResponse response){
        if(!request.getParameter("id").equals("")){
            String id = request.getParameter("id");
            Integer uid = Integer.parseInt(id);
            userRepository.deleteUser(uid);
            return "DB entry deleted, id = " + id;
        }
        else
            return "No DELETE data id";
    }

    @RequestMapping("/user/get")
    public String getUser(HttpServletRequest request, HttpServletResponse response){
        if(!request.getParameter("id").equals("")){
            User user;
            user = userRepository.getUser(Integer.parseInt(request.getParameter("id")));
            return gson.toJson(user);
        }
        else{
            return "No GET data id";
        }
    }
    @RequestMapping("/user/getall")
    public String getAllUsers(HttpServletRequest request, HttpServletResponse response){
        List<User> users = userRepository.getUsers();
        return gson.toJson(users);
    }

    @RequestMapping("/product/add")
    public String addProduct(HttpServletRequest request, HttpServletResponse response){
        if(!request.getParameter("name").equals("")){
            Double ev = Double.parseDouble(request.getParameter("ev"));
            Double prot = Double.parseDouble(request.getParameter("prot"));
            Double f = Double.parseDouble(request.getParameter("f"));
            Double carb = Double.parseDouble(request.getParameter("carb"));
            Double price = Double.parseDouble(request.getParameter("price"));
            productRepository.createProduct(request.getParameter("name"),
                    request.getParameter("size"), ev, prot, f, carb, price);
            return "Entry to DB added, name = " + request.getParameter("name") + ", size = " +
                    request.getParameter("size") + ", energy value = " + ev +
                    ", proteins = " + prot + ", fats = " + f + ", carbohydrates = " +carb +", price = "+price+".";
        }
        else{
            return "No POST data name";
        }
    }

    @RequestMapping("/product/del")
    public String deleteProduct(HttpServletRequest request, HttpServletResponse response){
        if(!request.getParameter("id").equals("")){
            Integer productID = Integer.parseInt(request.getParameter("id"));
            productRepository.deleteProduct(productID);
            return "DB entry deleted, id = " + productID.toString();
        }
        else{
            return "No DELETE data id";
        }
    }

    @RequestMapping("/product/get")
    public String getProduct(HttpServletRequest request, HttpServletResponse response){
        if(!request.getParameter("id").equals("")){
            Integer productID = Integer.parseInt(request.getParameter("id"));
            Product product;
            product = productRepository.getProduct(productID);
            return gson.toJson(product);
        }
        else{
            return "No GET data id";
        }
    }

    @RequestMapping("/product/getall")
    public String getAllProducts(HttpServletRequest request, HttpServletResponse response){
        List<Product> products = productRepository.getProducts();
        return gson.toJson(products);
    }
}
