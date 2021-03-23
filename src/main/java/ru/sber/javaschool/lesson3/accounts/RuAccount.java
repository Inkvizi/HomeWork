package ru.sber.javaschool.lesson3.accounts;
import lombok.Data;
import ru.sber.javaschool.lesson3.accounts.bik.BIK;

@Data
public class RuAccount extends AccountDefault {
    private BIK bik;

    RuAccount(BIK bik) {
        this.bik = bik;
    }

    @Override
    public boolean withdraw(double Amount) {
        if (bik.check()) {
            return super.withdraw(Amount);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean put(double Amount) {
        if (bik.check()) {
            return super.put(Amount);
        }
        else {
            return false;
        }
    }
}
