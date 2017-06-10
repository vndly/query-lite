package com.mauriciotogneri.query.test;

import com.mauriciotogneri.query.common.OldQuery;
import com.mauriciotogneri.query.common.Query;

import static org.junit.Assert.assertEquals;

class BaseTest
{
    void check(String expected, OldQuery actual)
    {
        assertEquals(expected, actual.toString());
    }

    void check(String expected, Query actual)
    {
        assertEquals(expected, actual.query());
    }
}