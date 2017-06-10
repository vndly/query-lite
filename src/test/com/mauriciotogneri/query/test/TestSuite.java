package com.mauriciotogneri.query.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SelectTest.class,
        CreateTest.class,
        InsertTest.class,
        DeleteTest.class,
        UpdateTest.class,
        DropTest.class,
        AlterTest.class
})
public class TestSuite
{
}