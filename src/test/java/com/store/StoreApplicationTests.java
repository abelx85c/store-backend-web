package com.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void getConnection() throws SQLException {
        System.out.println("================");
        System.out.println("測試資料庫連接");
        System.out.println(dataSource.getConnection());
        System.out.println("成功");
    }
}
