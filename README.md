# SQLiteQueryBuilder

[![Build Status](https://travis-ci.org/alexfu/SQLiteQueryBuilder.svg?branch=master)](https://travis-ci.org/alexfu/SQLiteQueryBuilder)
[![Coverage Status](https://coveralls.io/repos/alexfu/SQLiteQueryBuilder/badge.svg?branch=master)](https://coveralls.io/r/alexfu/SQLiteQueryBuilder?branch=master)
[![Join the chat at https://gitter.im/alexfu/SQLiteQueryBuilder](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/alexfu/SQLiteQueryBuilder?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

This project is aimed at providing a simple API to build SQLite query statements. This library does nothing but build statements; it's not an ORM. The API syntax is inspired from the jOOQ library.

Currently, SQLiteQueryBuilder is under active development so you may find some features missing. If this is the case, please file an issue or open a pull request.

## Motivation
Although this project is written in Java and bears no dependencies to external frameworks (so far), it is/was developed specifically to be used on the Android platform. There are a few reasons why I started this project...

- Building SQLite statements in pure Java can be cumbersome and very unreadable at times
- Androids own SQLiteQueryBuilder is also cumbersome to use at times.
- Although the jOOQ library has a great API for building SQL statements, it comes with an entire suite of tools to build statements, connect to databases, write/read models to/from databases, etc. Due to the current nature of Dalvik (Androids application VM), there is a 64k method reference limit. jOOQ can contain over 10,000 referenced methods when in use. This may not seem like much in comparison to the limit, but if you consider other large libraries commonly used (such as Guava and Google Play Services), hitting that 64k limit becomes much easier.

## Usage
```java
String sql = SQLiteQueryBuilder
	.select("*")
	.from("accounts")
	.where("id = 1")
	.toString();
```

You can view more examples in the [src/test/java](https://github.com/alexfu/SQLiteQueryBuilder/tree/master/src/test/java) folder.

To use this library, you'll have to generate the jar file and copy it to your projects lib directory (until I get the chance to publish to Maven Central)...

```
./gradlew jar
cp build/libs/SQLiteQueryBuilder-VERSION.jar /path/to/my/project/libs
```
