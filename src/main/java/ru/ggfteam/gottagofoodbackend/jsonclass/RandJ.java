package ru.ggfteam.gottagofoodbackend.jsonclass;

import java.util.List;
import java.util.Random;

public class RandJ {
    int rv;
    String[] hashes = new String[4];

    public RandJ(){
        this.rv = (int) (Math.random()*32768);
        for (int i = 0; i < 4; i++) {
            String s = gen_hash();
            this.hashes[i] = s;
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
