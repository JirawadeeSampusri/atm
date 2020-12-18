package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private List<BankAccount> accountList;

    @PostConstruct
    public void postConstruct() {
        this.accountList = new ArrayList<>();
    }

    public void createBankAccount(BankAccount bankaccount) {
        accountList.add(bankaccount);
    }

    public List<BankAccount> getbankaccount() {
        return new ArrayList<>(this.accountList);
    }

    public BankAccount findBankAccount(int id) {
        for (BankAccount customer : accountList) {
            if (customer.getId() == id)
                return customer;
        }
        return null;
    }
}
