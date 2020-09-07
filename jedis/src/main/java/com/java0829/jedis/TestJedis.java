package com.java0829.jedis;


import io.rebloom.client.Client;

public class TestJedis {

    public static void main(String[] args) {
        Client client = new Client("localhost", 6378);
        client.add("simpleBloom", "Mark");

    }

}
