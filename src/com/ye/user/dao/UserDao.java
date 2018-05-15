package com.ye.user.dao;

import com.ye.user.domain.User;
import com.ye.user.utiles.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UserDao {
    public void save(User user) {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?)";
        Object [] para = {user.getUid(),user.getUsername(),user.getPassword()
        ,user.getEmail(),user.getName(),user.getSex()};
        System.out.println(user.getUsername()+user.getName());
        try {
            queryRunner.update(sql,para);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
