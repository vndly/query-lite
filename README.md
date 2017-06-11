[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/mauriciotogneri/query-lite/blob/master/LICENSE.md)
[![Download](https://api.bintray.com/packages/mauriciotogneri/maven/querylite/images/download.svg)](https://bintray.com/mauriciotogneri/maven/querylite/_latestVersion)

# Query Lite
Query builder library for SQLite.

## Examples

### Create table

```java
Query create = new Create()
                .table("Person")
                .ifNotExist()
                .columns(new Column("id", DataType.INT).primary().autoincrement().notNull(),
                         new Column("name", DataType.TEXT).notNull(),
                         new Column("age", DataType.INT).notNull().check("age >= 0"),
                         new Column("weight", DataType.REAL).notNull().check("weight >= 0"));
```

Generates:

```sql
CREATE TABLE IF NOT EXISTS Person (id INT PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL, age INT NOT NULL CHECK (age >= 0), weight REAL NOT NULL CHECK (weight >= 0));
```

## Installation

Add the following code to your **pom.xml**:

```xml
<repositories>
    <repository>
        <id>jcenter</id>
        <url>https://jcenter.bintray.com</url>
    </repository>
</repositories>
```

and the dependency:

```xml
<dependency>
    <groupId>com.mauriciotogneri</groupId>
    <artifactId>query</artifactId>
    <version>0.3.0</version>
</dependency>
```

or if you use Gradle:

```groovy
dependencies
{
    compile 'com.mauriciotogneri:query:0.3.0'
}
```