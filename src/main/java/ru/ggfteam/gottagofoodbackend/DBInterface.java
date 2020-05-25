package ru.ggfteam.gottagofoodbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ggfteam.gottagofoodbackend.repositories.UserRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RestController
public class DBInterface extends HttpServlet {
    @Autowired
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
    @RequestMapping("/user/del")
    public String deleteUser(HttpServletRequest request, HttpServletResponse response){
        if(!request.getParameter("id").equals("")){
            String id = request.getParameter("id");
            Integer uid = Integer.valueOf(id);
            userRepository.deleteUser(uid);
            return "DB entry deleted, id = " + id;
        }
        else
            return "No DELETE data id";
    }

}
