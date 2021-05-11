package com.github.marinets.JDBCFunction;

import java.sql.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public class ExampleJDBC {

    public static CheckedBiFunction<Supplier<String>, Supplier<String>, Optional<String>> makeSelector(Supplier<String> getConnectionString) {
        CheckedSupplierFunction<Connection> connection = () -> getConnection(getConnectionString.get()).orElseThrow(JDBCConnectionException::new);
        return (getTableName, getColumnNames) -> {
            try(Statement statement = connection.apply().createStatement()) {
                try(ResultSet resultSet = statement.executeQuery(
                        formatSelect(getTableName.get(), getColumnNames.get()))) {
                    if (resultSet.next()) {
                        return Optional.of(formatAnswer(resultSet, getColumnNames.get()));
                    } else {
                        return Optional.empty();
                    }
                }
            }
        };
    }

    private static Optional<Connection> getConnection(String url) throws SQLException {
        return Optional.ofNullable(DriverManager.getConnection(url));
    }

    private static String formatSelect(String tableName, String columnNames) {
        return  "select " + columnNames.toLowerCase() + "  from " + tableName.toLowerCase();
    }

    private static String formatAnswer(ResultSet resultSet, String columNames) throws SQLException {
        String[] columns = columNames.split(",");
        if (columns.length == 1) {
            return resultSet.getString(columns[0]);
        }
        return Arrays.stream(columns).reduce("", (result, columnName) -> {
            try {
                if (result.equals("")) {
                    return String.format("%s: %s", columnName, resultSet.getString(columnName.trim().toUpperCase()));
                } else {
                    return result + String.format(", %s: %s", columnName, resultSet.getString(columnName.trim().toUpperCase()));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return "";
        });
    }
}
