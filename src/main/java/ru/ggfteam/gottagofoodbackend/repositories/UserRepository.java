package ru.ggfteam.gottagofoodbackend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Component
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createUser(String name){
        UUID token = UUID.randomUUID();
        Date reg_date = new Date();
        return jdbcTemplate.update("INSERT INTO users values(default, ?, ?, ?);", name, token, reg_date);
    }
}
