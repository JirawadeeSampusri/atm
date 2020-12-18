package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Transaction;


@Service
public class TransactionService {

    private RestTemplate restTemplate;

    public TransactionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void changeBalance(Transaction transaction) {
        String url = "http://localhost:8091/api/bankaccount/trasaction";

        restTemplate.postForObject(url, transaction, Transaction.class);
    }


}
