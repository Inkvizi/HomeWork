package ru.sber.javaschool.lesson3.accounts;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountDefaultTest {
    private AccountDefault account;

    @Before
    public void setUp() {
        account = new AccountDefault();
    }

    @Test
    public void checkNegativeValueInWithdraw() {
        boolean operationIsValid = account.put(100);
        Assert.assertTrue(operationIsValid);
        operationIsValid = account.withdraw(-1);
        Assert.assertFalse(operationIsValid);
    }

    @Test
    public void checkPositiveValueInWithdraw() {
        boolean operationIsValid = account.put(100);
        Assert.assertTrue(operationIsValid);
        operationIsValid = account.withdraw(1);
        Assert.assertTrue(operationIsValid);
    }

    @Test
    public void checkPositiveOverflowValueInWithdraw() {
        boolean operationIsValid = account.put(100);
        Assert.assertTrue(operationIsValid);
        operationIsValid = account.withdraw(120);
        Assert.assertFalse(operationIsValid);
    }

    @Test
    public void checkNegativeValueInPut() {
        boolean operationIsValid = account.put(-1);
        Assert.assertFalse(operationIsValid);
    }

    @Test
    public void checkPositiveValueInPut() {
        boolean operationIsValid = account.put(100);
        Assert.assertTrue(operationIsValid);
    }

    @Test
    public void testGetBalance() {
        boolean operationIsValid = account.put(100);
        Assert.assertTrue(operationIsValid);
        Assert.assertEquals(0, Double.compare(100, account.getBalance()));
    }

    @Test
    public void checkImmutabilityOfBalanceWhenError() {
        boolean operationIsValid = account.put(50);
        Assert.assertTrue(operationIsValid);
        Assert.assertEquals(0, Double.compare(50, account.getBalance()));
        operationIsValid = account.put(-10);
        Assert.assertFalse(operationIsValid);
        Assert.assertEquals(0, Double.compare(50, account.getBalance()));
    }
}