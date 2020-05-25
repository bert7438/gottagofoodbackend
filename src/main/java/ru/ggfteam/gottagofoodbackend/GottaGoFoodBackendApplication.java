package ru.ggfteam.gottagofoodbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@Controller
public class GottaGoFoodBackendApplication extends HttpServlet {

    @RequestMapping("/")
    public String default_page(HttpServletRequest request, HttpServletResponse response){
        return "default_page";
    }
    public static void main(String[] args) {
        SpringApplication.run(GottaGoFoodBackendApplication.class, args);
    }

}
