package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.insert.Insert;

import org.junit.Test;

public class InsertTest extends BaseTest
{
    @Test
    public void insert()
    {
        Query insert = new Insert()
                .into("Person")
                .set("email", "john.doe@email.com")
                .set("name", "John Doe")
                .set("age", 45)
                .set("weight", 81.2);

        check("INSERT INTO Person (email, name, age, weight) VALUES (\"john.doe@email.com\", \"John Doe\", 45, 81.2);", insert);
    }
}