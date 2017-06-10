package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.insert.Insert;

import org.junit.Test;

public class InsertTest extends BaseTest
{
    @Test
    public void insert()
    {
        Query insert = new Insert().into("Person").columns("age", "name").values(20, "Peter");

        check("INSERT INTO Person (age, name) VALUES (20, Peter);", insert);
    }
}