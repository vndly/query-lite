package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.Query;
import com.mauriciotogneri.query.delete.Delete;

import org.junit.Test;

public class DeleteTest extends BaseTest
{
    @Test
    public void delete()
    {
        Query delete = new Delete()
                .from("person")
                .where("age >= ?");

        check("DELETE FROM person WHERE (age >= 18);", delete, 18);
    }
}