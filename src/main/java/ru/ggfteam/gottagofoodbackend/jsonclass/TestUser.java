package ru.ggfteam.gottagofoodbackend.jsonclass;

public class TestUser {
    public int amount;
    public int[] postsSettings;

    public TestUser() {
        this.amount = 6;
        this.postsSettings = new int[]{4, 3, 5, 6, 1, 2};
    }
}
