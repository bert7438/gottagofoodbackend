package ru.ggfteam.gottagofoodbackend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ggfteam.gottagofoodbackend.entities.User;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Component
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int createUser(String name){
        UUID token = UUID.randomUUID();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        return jdbcTemplate.update(
                "INSERT INTO users values(default, ?, ?, ?);", name, token, date);
    }
    public int updateUser(User user){
        return jdbcTemplate.update(
                "UPDATE users set name = ? where userID=?;", user.getName(), user.getUserID());
    }
    public int deleteUser(Integer id){
        return jdbcTemplate.update(
                "DELETE FROM users WHERE \"userID\" = ?;", id);
    }
    public User getUser(Integer id){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM users WHERE \"userID\" = ?;", new UsersMapper(), id);
    }

    public List<User> getUsers(){
        return jdbcTemplate.query(
                "SELECT * FROM users;", new UsersMapper());
    }
}
