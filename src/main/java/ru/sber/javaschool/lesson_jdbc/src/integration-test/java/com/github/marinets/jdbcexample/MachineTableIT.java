package com.github.marinets.jdbcexample;

import com.github.marinets.MachineTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MachineTableIT {
    private MachineTable machine = new MachineTable("jdbc:h2:./target/example");

    @BeforeAll
    static  void setUp() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    @Test
    void selectExample() throws SQLException {

        assertEquals(Optional.of("VW"),machine.getName());
        System.out.println("done");
    }
}
