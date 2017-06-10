package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.update.Update;

import org.junit.Test;

public class UpdateTest extends BaseTest
{
    @Test
    public void update()
    {
        Query insert = new Update().table("Person").set("age = 18", "name = \"Peter\"").where("id = 100");

        check("UPDATE Person SET (age = 18, name = \"Peter\") WHERE (id = 100);", insert);
    }
}