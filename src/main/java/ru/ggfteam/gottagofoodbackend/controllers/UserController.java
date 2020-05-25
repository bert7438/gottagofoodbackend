package ru.ggfteam.gottagofoodbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ggfteam.gottagofoodbackend.entities.User;
import ru.ggfteam.gottagofoodbackend.repositories.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository user;
    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = "text/plain")
    public int createUser(@RequestBody String param){
        String name = null;
        try{
            JSONObject json = new JSONObject(param);
            name = json.getString("name");
        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return user.createUser(name);
    }
    @RequestMapping(value="update",method=RequestMethod.POST,consumes="text/plain")
    public int updatePerson(@RequestBody String param){
        User u = new User();
        try{
            JSONObject json = new JSONObject(param);
            u.setUserID(json.getInt("userID"));
            u.setName(json.getString("name"));
        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return user.updateUser(u);
    }
}
