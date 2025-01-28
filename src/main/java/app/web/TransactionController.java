package app.web;

import app.transaction.model.Transaction;
import app.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ModelAndView getAllTransactions() {

        List<Transaction> transactions = transactionService.getAllByOwnerId(UUID.fromString("8af834fa-dbc9-4876-a3eb-c0a39e1d4919"));

        ModelAndView mav = new ModelAndView();
        mav.setViewName("transactions");
        mav.addObject("transactions", transactions);

        return mav;
    }
}
