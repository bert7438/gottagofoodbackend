package ru.ggfteam.gottagofoodbackend.repositories;

import org.springframework.jdbc.core.RowMapper;
import ru.ggfteam.gottagofoodbackend.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UsersMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserID(rs.getInt("id"));
        user.setName(rs.getString("name"));

        //getting uuid from string? hope that works
        UUID tkn = UUID.fromString(rs.getString("token"));
        user.setToken(tkn);
        user.setReg_date(rs.getDate("reg_date"));
        return user;
    }
}
