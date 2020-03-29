package com.silvalazaro.chamedesk;

import com.silvalazaro.chamedesk.dao.ConexaoDB;
import com.silvalazaro.chamedesk.dao.ProblemaDAOTest;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Lazaro
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ProblemaDAOTest.class})
public class ChameDeskTest {

    @AfterClass
    public static void encerrarTestes() throws ClassNotFoundException, SQLException {
        ConexaoDB.getInstancia().encerrar();
    }

}
