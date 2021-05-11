package com.github.marinets.JDBCFunction;

import java.sql.SQLException;

@FunctionalInterface
public interface CheckedSupplierFunction<T> {
    T apply() throws SQLException;
}
