package br.com.agenda.factory;

import com.sun.tools.javac.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/agenda?characterEncoding=latin1&useConfigs=maxPerformance";


    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }

    public static void main(String[] args) throws Exception {
       Connection connection = getConnection();
       if (connection !=null){
           System.out.println("conectado com sucesso");
           connection.close();
       }
    }

}
