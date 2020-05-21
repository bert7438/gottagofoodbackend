package ru.ggfteam.gottagofoodbackend;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ggfteam.gottagofoodbackend.repositories.UserRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class DBInterface extends HttpServlet {
    UserRepository userRepository;
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

}
