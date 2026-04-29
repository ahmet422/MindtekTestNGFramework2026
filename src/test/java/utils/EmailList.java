package utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmailList extends TestBase {

    // test if every email ends with @sqltutorial.org
    @Test
    public void testEmailValidity() throws SQLException {
        JDBCUtils.establishConnection();
        List<Map<String,Object>> data =  JDBCUtils.runQuery("Select email from employees");
        for(Map<String,Object> el : data){
            String db_email = el.get("email").toString();
            String emailEnding = db_email.substring(db_email.indexOf('@'));
//            Assert.assertTrue(el.get("email").toString().endsWith("@sqltutorial.org"));
            Assert.assertEquals(emailEnding,"@sqltutorial.org");
        }
    }
}
