package com.mauriciotogneri.query.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AlterTest.class,
        CreateTest.class,
        DeleteTest.class,
        DropTest.class,
        InsertTest.class,
        SelectTest.class,
        UpdateTest.class
})
public class TestSuite
{
}