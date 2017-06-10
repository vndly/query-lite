package com.mauriciotogneri.query.create;

public class Create
{
    public CreateTable table(String name)
    {
        return new CreateTable(name);
    }

    public CreateIndex index(String name)
    {
        return new CreateIndex(name);
    }
}