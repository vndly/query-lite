package com.mauriciotogneri.query.test;

import static org.junit.Assert.assertEquals;

class BaseTest
{
    void check(String expected, Object actual)
    {
        assertEquals(expected, actual.toString());
    }
}