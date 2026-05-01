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
                "",
                "",
                ""
        );

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("Select * from regions");

        ResultSetMetaData rsmeta = resultSet.getMetaData();

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
