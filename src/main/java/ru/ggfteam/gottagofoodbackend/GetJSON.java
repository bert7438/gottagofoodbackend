package ru.ggfteam.gottagofoodbackend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ggfteam.gottagofoodbackend.jsonclass.RandJ;
import ru.ggfteam.gottagofoodbackend.jsonclass.TestUser;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController

public class GetJSON extends HttpServlet {

    @GetMapping("/json")
    public TestUser getjson(HttpServletRequest request, HttpServletResponse response){
        return new TestUser();
    }



    @GetMapping("/test")
    public RandJ getrjson(HttpServletRequest request, HttpServletResponse response){
        RandJ e = new RandJ();
        return e;
    }

}