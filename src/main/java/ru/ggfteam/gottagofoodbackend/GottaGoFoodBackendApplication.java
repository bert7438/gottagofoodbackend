package ru.ggfteam.gottagofoodbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class GottaGoFoodBackendApplication extends HttpServlet {

    @RequestMapping("/")
    public String default_page(HttpServletRequest request, HttpServletResponse response){
        String page = "<!DOCTYPE html>\n" +
                "<html lang=\"ru\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Добро пожаловать в Spring!</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<a href=\"http://mirea.ru\">Посетите наш официальный вебсайт!</a>\n" +
                "<h3>Можно отправлять запросы по этому адресу, чтобы добавлять, удалять, изменять и смотреть записи в базе данных!</h3>\n" +
                "<h4>User</h4>\n" +
                "<p>/user/add?name=\"name\" - добавляет в БД пользователя с именем \"name\"</p>\n" +
                "<p>/user/del?id=\"id\" - удаляет из БД пользователя с идентификатором(не токеном!) \"id\"</p>\n" +
                "<p>/user/get?id=\"id\" - получает JSON-строковое представление записи с идентификатором(не токеном!) \"id\"</p>\n" +
                "<p>/user/getall - получает <b>ВСЕ</b> записи БД в JSON-строковом представлении</p>\n" +
                "</body>\n" +
                "</html>";
        return page;
    }
    public static void main(String[] args) {
        SpringApplication.run(GottaGoFoodBackendApplication.class, args);
    }

}
