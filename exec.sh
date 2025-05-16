#!/bin/bash
mvn compile exec:java -Dexec.mainClass=com.craftinginterpreters.lox.Lox -Dexec.args=main.lox
