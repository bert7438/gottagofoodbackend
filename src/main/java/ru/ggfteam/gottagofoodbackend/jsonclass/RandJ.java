package ru.ggfteam.gottagofoodbackend.jsonclass;

import java.util.List;
import java.util.Random;

public class RandJ {
    int rv;
    List<String> hashes;

    public RandJ(){
        rv = (int) (Math.random()*32768);
        for (int i = 0; i < 4; i++) {
            hashes.add(gen_hash());
        }
    }

    private String gen_hash(){
        StringBuilder s = new StringBuilder();
        char[] set = "1234567890ABCDEF".toCharArray();
        for (int i = 0; i < 4; i++) {
            s.append(set[(int) (Math.random()*16)]);
        }
        return s.toString();
    }
}
