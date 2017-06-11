package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.update.Update;

import org.junit.Test;

public class UpdateTest extends BaseTest
{
    @Test
    public void update()
    {
        Query insert = new Update()
                .table("person")
                .set("age", 18)
                .set("name", "Peter")
                .where("id = ?");

        check("UPDATE person SET age = 18, name = \"Peter\" WHERE (id = 100);", insert, 100);
    }
}