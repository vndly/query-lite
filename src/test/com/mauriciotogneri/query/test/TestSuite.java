package com.mauriciotogneri.query.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SelectTest.class,
        CreateTableTest.class,
        CreateIndexTest.class,
        InsertTest.class
})
public class TestSuite
{
}