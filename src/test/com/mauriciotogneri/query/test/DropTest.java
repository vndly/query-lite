package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.drop.Drop;

import org.junit.Test;

public class DropTest extends BaseTest
{
    @Test
    public void dropTable()
    {
        Query drop = new Drop()
                .table("Person");

        check("DROP TABLE Person;", drop);
    }

    @Test
    public void dropTableIfExist()
    {
        Query drop = new Drop()
                .table("Person")
                .ifExist();

        check("DROP TABLE IF EXISTS Person;", drop);
    }

    //==============================================================================================

    @Test
    public void dropIndex()
    {
        Query drop = new Drop()
                .index("index_name");

        check("DROP INDEX index_name;", drop);
    }

    @Test
    public void dropIndexIfExist()
    {
        Query drop = new Drop()
                .index("index_name")
                .ifExist();

        check("DROP INDEX IF EXISTS index_name;", drop);
    }
}