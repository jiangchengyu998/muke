package com.java0829.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "INSERT INTO `tbl_user` (`username`, `age`) VALUES (?, ?)";
        String userName = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, userName, 19);
    }
}
