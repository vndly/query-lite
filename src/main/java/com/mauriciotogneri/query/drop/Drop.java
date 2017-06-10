package com.mauriciotogneri.query.drop;

public class Drop
{
    public DropTable table(String name)
    {
        return new DropTable(name);
    }

    public DropIndex index(String name)
    {
        return new DropIndex(name);
    }
}