package lab.aikibo.controller;

import lab.aikibo.auth.UserAuthentication;
import lab.aikibo.constant.Status;
import lab.aikibo.entity.Expense;
import lab.aikibo.entity.User;
import lab.aikibo.repo.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tamami on 29/12/16.
 */
@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    @Autowired
    ExpensesRepository expensesRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Expense> getExpenses() {
        return expensesRepository.findByUserOrderByDateDesc(getCurrentUser());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createExpense(@RequestBody Expense expense) {
        expense.setStatus(Status.NEW);
        expense.setUser(getCurrentUser());
        expensesRepository.save(expense);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private User getCurrentUser() {
        return ((UserAuthentication) SecurityContextHolder.getContext().getAuthentication()).getDetails().getUser();
    }



}
