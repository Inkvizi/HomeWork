package ru.sber.javaschool.lesson3.accounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.sber.javaschool.lesson3.accounts.bik.BIK;

import static org.junit.Assert.*;

public class RuAccountTest {
    public static final String TESTBIK = "TESTBIK";
    private RuAccount account;
    private BIK bik;

    @Before
    public void setUp() {
        bik = Mockito.mock(BIK.class);
        account = new RuAccount(bik);
    }

    @Test
    public void testLombokOnBIK() {
        account.setBik(bik);
        Assert.assertEquals(bik, account.getBik());
    }

    @Test
    public void checkWithdrawWithEmptyBik() {
        Mockito.when(bik.check()).thenReturn(false);
        boolean isOperationValid = account.withdraw(0);
        Assert.assertFalse(isOperationValid);
        Mockito.verify(bik).check();
    }

    @Test
    public void checkWithdrawWithNotEmptyBik() {
        Mockito.when(bik.check()).thenReturn(true);
        boolean isOperationValid = account.withdraw(0);
        Assert.assertTrue(isOperationValid);
        Mockito.verify(bik, Mockito.times(1)).check();
    }

    @Test
    public void checkPutWithEmptyBik() {
        Mockito.when(bik.check()).thenReturn(false);
        boolean isOperationValid = account.put(100);
        Assert.assertFalse(isOperationValid);
        Mockito.verify(bik).check();
    }

    @Test
    public void checkPutWithNotEmptyBik() {
        Mockito.when(bik.check()).thenReturn(true);
        boolean isOperationValid = account.put(100);
        Assert.assertTrue(isOperationValid);
        Mockito.verify(bik, Mockito.times(1)).check();
    }
}