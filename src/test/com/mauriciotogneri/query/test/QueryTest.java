package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.Select;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryTest
{
    @Test
    public void selectAll()
    {
        Select select = new Select();

        assertEquals("SELECT *", select.toString());
    }

    @Test
    public void selectFields()
    {
        Select select = new Select("name", "age", "weight");

        assertEquals("SELECT name, age, weight", select.toString());
    }
}