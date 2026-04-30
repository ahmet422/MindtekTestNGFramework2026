package utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest2 {
    public static void main(String[] args) throws SQLException {
        JDBCUtils.establishConnection();
        List<Map<String,Object>> data = JDBCUtils.runQuery("select * from countries where country_name = 'Canada'");
        JDBCUtils.close();

//        System.out.println(data.get(0).get("department_name"));
        for(Map<String,Object> el : data) System.out.println(el);
        for(Map<String,Object> el : data) System.out.println(el);

        for(Map<String,Object> el : data) System.out.println(el);

        for(Map<String,Object> el : data) System.out.println(el);

    }
}
