package com.github.marinets.jdbcexample;

import com.github.marinets.AnimalTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTableIT {
    private AnimalTable animal = new AnimalTable("jdbc:h2:./target/example");

    @BeforeAll
    static  void setUp() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    @Test
    void selectTwoColomns() throws SQLException {
        assertEquals(Optional.of("name: JACK, age: 5"), animal.getNameAndAge());
    }
}
