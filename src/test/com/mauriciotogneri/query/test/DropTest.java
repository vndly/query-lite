package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.drop.Drop;

import org.junit.Test;

public class DropTest extends BaseTest
{
    @Test
    public void dropTable()
    {
        Query create = new Drop()
                .table("Person");

        check("DROP TABLE Person;", create);
    }

    @Test
    public void dropTableIfExist()
    {
        Query create = new Drop()
                .table("Person")
                .ifExist();

        check("DROP TABLE IF EXISTS Person;", create);
    }

    //==============================================================================================

    @Test
    public void dropIndex()
    {
        Query create = new Drop()
                .index("index_name");

        check("DROP INDEX index_name;", create);
    }

    @Test
    public void dropIndexIfExist()
    {
        Query create = new Drop()
                .index("index_name")
                .ifExist();

        check("DROP INDEX IF EXISTS index_name;", create);
    }
}