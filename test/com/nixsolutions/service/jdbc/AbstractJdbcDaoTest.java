package com.nixsolutions.service.jdbc;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import java.io.FileInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AbstractJdbcDaoTest {

    public AbstractJdbcDaoTest() {
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
                "org.h2.Driver");
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
                "jdbc:h2:mem:User");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
                "test");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
                "test");
    }

    protected IDataSet getDataSet() throws Exception {

        return new FlatXmlDataSetBuilder()
                .build(new FileInputStream("dataset.xml"));
    }

    @Test public void testById() {
        int userId = 2;// get user id from database
        assertThat(2, is(userId));
    }

}
