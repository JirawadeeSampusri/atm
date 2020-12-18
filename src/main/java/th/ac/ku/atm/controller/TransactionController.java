package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.Transaction;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.service.TransactionService;


@Controller
@RequestMapping("/transaction")

public class TransactionController {
    private TransactionService transactionService;
    private BankAccountService accountService;

    public TransactionController(BankAccountService accountService,TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }
    @PostMapping
    public String changeBalance(@ModelAttribute Transaction transaction, Model model) {
        transactionService.changeBalance(transaction);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:bankaccount";
    }

}
