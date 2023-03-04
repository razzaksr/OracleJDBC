package org.example;

import oracle.jdbc.OracleDriver;

import java.sql.*;

public class DAO {
    private static DAO dao=new DAO();
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
    private Driver driver=null;
    private Connection connection=null;
    private String query="";
    private DAO(){
        try {
            driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            System.out.println("Driver is connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static DAO getDao(){return dao;}
    public void check(){
        query="select * from hai";
        try {
            preparedStatement= connection.prepareStatement(query);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+" "+resultSet.getString("name")+" "+resultSet.getInt("price"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
