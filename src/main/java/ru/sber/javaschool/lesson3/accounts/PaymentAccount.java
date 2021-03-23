package ru.sber.javaschool.lesson3.accounts;

import ru.sber.javaschool.lesson3.accounts.bik.BIK;

public class PaymentAccount extends RuAccount {
    private boolean isBlocked;
    private double overDraft;
    private double currentOverDraft;

    PaymentAccount(BIK bik) {
        super(bik);
    }

    public void block() {
        this.isBlocked = true;
    }

    public  void unBlock() {
        this.isBlocked = false;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public double getCurrentOverDraft() {
        return currentOverDraft;
    }

    public void setOverDraft(double overDraft) {
        if (Double.compare(currentOverDraft, this.overDraft) != 0) {
            double diff = this.overDraft - overDraft;
            this.overDraft = overDraft;
            currentOverDraft = currentOverDraft - diff;
        }
        else {
            this.overDraft = overDraft;
            currentOverDraft = overDraft;
        }

    }

    @Override
    public boolean withdraw(double Amount) {
        if (!isBlocked && (getBalance() >= Amount)) {
            if (Amount > super.getBalance()) {
                double DiffAmount = Amount - super.getBalance();
                currentOverDraft -= DiffAmount;
                return super.withdraw(Amount - DiffAmount);
            }
            else {
                return super.withdraw(Amount);
            }
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean put (double Amount) {
        if (!isBlocked) {
            if (currentOverDraft != overDraft) {
                double diffOverdraft = (overDraft - currentOverDraft);
                if (diffOverdraft > Amount) {
                    currentOverDraft += Amount;
                    return true;
                }
                double newAmount = Amount - diffOverdraft;
                boolean isOperationValid = super.put(newAmount);
                if (isOperationValid) {
                    currentOverDraft = overDraft;
                }
                return isOperationValid;
            }
            return super.put(Amount);
        }
        else {
            return false;
        }
    }

    @Override
    public double getBalance() {
        return super.getBalance() + currentOverDraft;
    }
}
