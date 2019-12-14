package com.tennis;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class DbConnectorTest {

    @Test
    public void dbConnectorTest() throws SQLException {
        //When
        DbConnector dbConnector = DbConnector.getInstance();

        //Then
        assertNotNull(dbConnector.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbConnector dbManager = DbConnector.getInstance();

        //When
        String sqlQuery = "SELECT * FROM TENNIS_PRODUCTS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int count = 0;
        while(rs.next()) {
            System.out.println(rs.getLong("ID") + ", " +
                    rs.getString("PRODUCT_NAME") + ", " +
                    rs.getString("DESCRIPTION") + ", " +
                    rs.getBigDecimal("PRODUCT_PRICE"));
            count++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(1, count);
    }
}