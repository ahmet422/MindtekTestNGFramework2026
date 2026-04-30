package utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PhoneList extends TestBase {

    // test if every phone number has a value
    @Test
    public void testPhoneValidity() throws SQLException {
        JDBCUtils.establishConnection();
        List<Map<String,Object>> data =  JDBCUtils.runQuery("Select phone_number from employees where phone_number is not null");
        for(Map<String,Object> el : data){
            Assert.assertNotNull(el.get("phone_number"));
        }
    }

}
