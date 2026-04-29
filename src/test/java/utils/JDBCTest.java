package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        System.out.println("Lets get started!");

        // establish connection:
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/HR_productions",
                "postgres",
                "admin"
        );

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("Select * from regions");

//        while(resultSet.next()){
//            System.out.println("----------------");
//            System.out.println("first_name: " + resultSet.getString("first_name"));
//            System.out.println("last_name: " + resultSet.getString("hire_date"));
//            System.out.println("phone: " + resultSet.getString("phone_number"));
//            System.out.println("salary: $" + resultSet.getString("salary"));
//        }

        ResultSetMetaData rsmeta = resultSet.getMetaData();

//        System.out.println(rsmeta.getColumnCount());
//        System.out.println(rsmeta.getColumnName(1));
//
//        for(int i = 1; i <= rsmeta.getColumnCount(); i++){
//            System.out.println(rsmeta.getColumnName(i));
//        }
//
        List<Map<String, Object>> tableData = new ArrayList<>();

        while(resultSet.next()){
            Map<String, Object> rowData = new HashMap<>();
            for(int i = 1; i <= rsmeta.getColumnCount(); i++){
                rowData.put(rsmeta.getColumnName(i), resultSet.getString(rsmeta.getColumnName(i)));
            }
            tableData.add(rowData);
        }

        for(Map<String,Object> el : tableData) System.out.println(el);

    }
}
