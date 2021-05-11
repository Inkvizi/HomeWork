package com.github.marinets;

import com.github.marinets.JDBCFunction.CheckedBiFunction;
import com.github.marinets.JDBCFunction.ExampleJDBC;

import java.sql.SQLException;
import java.util.Optional;
import java.util.function.Supplier;

public class MachineTable {
    private static CheckedBiFunction<Supplier<String>, Supplier<String>, Optional<String>> selector;

    public MachineTable(String connection) {
        selector = ExampleJDBC.makeSelector(() -> {return connection;});
    }
    public Optional<String> getName() throws SQLException {
        return selector.apply(() -> getTableName(), () -> {return "name";});
    }

    private static String getTableName() {
        return "machine";
    }
}
