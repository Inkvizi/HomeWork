package ru.sber.javaschool.lesson3.accounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuAccountTest {
    public static final String TESTBIK = "TESTBIK";
    private RuAccount account;

    @Before
    public void setUp() {
        account = new RuAccount();
    }

    @Test
    public void testLombokOnBIK() {
        account.setBIK(TESTBIK);
        Assert.assertEquals(TESTBIK, account.getBIK());
    }
}