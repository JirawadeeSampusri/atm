package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class BankAccountService {

    private List<BankAccount> accountList;
    private RestTemplate restTemplate;


    public BankAccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<BankAccount> getCustomerBankAccount(int customerId) {
        String url = "http://localhost:8091/api/bankaccount/customer/" +
                customerId;
        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }

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
