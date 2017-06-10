package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.OldQuery;
import com.mauriciotogneri.query.delete.Delete;

import org.junit.Test;

public class DeleteTest extends BaseTest
{
    @Test
    public void delete()
    {
        OldQuery insert = new Delete().from("Person").where("age >= 18");

        check("DELETE FROM Person WHERE (age >= 18);", insert);
    }
}