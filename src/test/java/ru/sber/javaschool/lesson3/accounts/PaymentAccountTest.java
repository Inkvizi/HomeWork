package ru.sber.javaschool.lesson3.accounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaymentAccountTest {
    private PaymentAccount account;

    @Before
    public void setUp() {
        account = new PaymentAccount();
    }

    @Test
    public void testBlock() {
        Assert.assertFalse(account.getIsBlocked());
        account.block();
        Assert.assertTrue(account.getIsBlocked());
    }

    @Test
    public void testUnblock() {
        account.block();
        Assert.assertTrue(account.getIsBlocked());
        account.unBlock();
        Assert.assertFalse(account.getIsBlocked());
    }

    @Test
    public void checkWithdrawOnBlockedAccoung() {
        boolean isOperationValid = account.put(100);
        Assert.assertTrue(isOperationValid);
        account.block();
        isOperationValid = account.withdraw(10);
        Assert.assertFalse(isOperationValid);
    }

    @Test
    public void checkWithdrawOnUnBlockedAccoung() {
        boolean isOperationValid = account.put(100);
        Assert.assertTrue(isOperationValid);
        account.unBlock();
        isOperationValid = account.withdraw(10);
        Assert.assertTrue(isOperationValid);
    }

    @Test
    public void checkWithdrawWithOverDraftOverflow() {
        account.setOverDraft(200);
        boolean isOperationValid = account.put(100);
        Assert.assertTrue(isOperationValid);
        isOperationValid = account.withdraw(1000);
        Assert.assertFalse(isOperationValid);
    }

    @Test
    public void checkWithdrawWithOverDraft() {
        account.setOverDraft(200);
        boolean isOperationValid = account.put(100);
        Assert.assertTrue(isOperationValid);
        isOperationValid = account.withdraw(250);
        Assert.assertTrue(isOperationValid);
    }

    @Test
    public void checkWithdrawWithOverDraftAllowAndOverdraftOverflow() {
        account.setOverDraft(200);
        boolean isOperationValid = account.put(100);
        Assert.assertTrue(isOperationValid);
        isOperationValid = account.withdraw(200); //overdraft allow
        Assert.assertTrue(isOperationValid);
        isOperationValid = account.withdraw(200); //overdraft overflow
        Assert.assertFalse(isOperationValid);
    }

    @Test
    public void checkPutOnBlockedAccount() {
        Assert.assertEquals(0, Double.compare(0, account.getBalance()));
        account.block();
        boolean isOperationValid = account.put(100);
        Assert.assertFalse(isOperationValid);
    }

    @Test
    public void checkPutOnUnBlockedAccount() {
        Assert.assertEquals(0, Double.compare(0, account.getBalance()));
        account.unBlock();
        boolean isOperationValid = account.put(100);
        Assert.assertTrue(isOperationValid);
    }

    @Test
    public void checkPutOnUnBlockedAccountWithOverdraftFilling() {
        account.unBlock();
        account.setOverDraft(200);
        account.put(100);
        Assert.assertEquals(0, Double.compare(300, account.getBalance()));
        boolean isOperationValid = account.withdraw(250);
        Assert.assertTrue(isOperationValid);
        Assert.assertEquals(0, Double.compare(50, account.getCurrentOverDraft()));
        Assert.assertEquals(0, Double.compare(50, account.getBalance()));
        isOperationValid = account.put(100);
        Assert.assertTrue(isOperationValid);
        Assert.assertEquals(0, Double.compare(150, account.getCurrentOverDraft()));
        Assert.assertEquals(0, Double.compare(150, account.getBalance()));
        isOperationValid = account.put(100);
        Assert.assertTrue(isOperationValid);
        Assert.assertEquals(0, Double.compare(200, account.getCurrentOverDraft()));
        Assert.assertEquals(0, Double.compare(250, account.getBalance()));
    }
}