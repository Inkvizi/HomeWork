package com.github.marinets;

import com.github.marinets.JDBCFunction.CheckedBiFunction;
import com.github.marinets.JDBCFunction.ExampleJDBC;

import java.sql.SQLException;
import java.util.Optional;
import java.util.function.Supplier;

public class AnimalTable {
    private static CheckedBiFunction<Supplier<String>, Supplier<String>, Optional<String>> selector;

    public AnimalTable(String connection) {
        selector = ExampleJDBC.makeSelector(() -> {return connection;});
    }
    public Optional<String> getNameAndAge() throws SQLException {
        return selector.apply(() -> getTableName(), () -> {return "name,age";});
    }

    private static String getTableName() {
        return "animal";
    }
}
