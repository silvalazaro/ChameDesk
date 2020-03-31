package com.silvalazaro.chamedesk;

import com.silvalazaro.chamedesk.dao.SolucaoDAOTest;
import com.silvalazaro.chamedesk.dao.ProblemaDAOTest;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Lazaro
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    ProblemaDAOTest.class,
    SolucaoDAOTest.class
})
public class ChameDeskTest {

    @AfterClass
    public static void encerrarTestes() throws ClassNotFoundException, SQLException {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true;user=demo;password=demo");
        } catch (Exception e) {
        }
    }

}
