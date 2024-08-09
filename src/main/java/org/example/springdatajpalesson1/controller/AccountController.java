package org.example.springdatajpalesson1.controller;

import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.example.springdatajpalesson1.entity.Account;
import org.example.springdatajpalesson1.service.AccountService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
public class AccountController {


    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }

    @GetMapping("/user")
    public String accountGet(Model model, @RequestParam long account_id) {
        Account account = accountService.getAccount(account_id);
        model.addAttribute("account", account);
        return "account";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    // @GetMapping("/registration")
    public String registrationGet(Model model) {
        model.addAttribute("account", new Account());
        return "registrationform";
    }

    @PostMapping("/reg_post")
    public String registrationPost(@Valid final @ModelAttribute Account account,
                                   final BindingResult bindingResult,
                                   final @RequestParam String repeatPassword,
                                   final Model model) {



        if (bindingResult.hasErrors()) {
            return "registrationform";
        }

        if (!account.getPassword().equals(repeatPassword)) {
            bindingResult.rejectValue("password", "Passwords do not match");
            return "registrationform";
        }

        accountService.addAccount(account);
        return "registrationform";
    }

    @GetMapping("/users")
    public String usersGet(Model model) {
        List<Account> accounts = accountService.getAccounts();
        model.addAttribute("accounts", accounts);
        return "accounts";
    }

    @GetMapping("/")
    public String homeGet(Model model) {
        return "home";
    }

    @GetMapping("/update")
    public String updateGet(Model model, @RequestParam long id) {
        Account account = accountService.getAccount(id);
        model.addAttribute("account", account);
        return "updateform";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Account account) {
        accountService.addAccount(account);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deletePost(@RequestParam long id) {
        accountService.deleteAccount(id);
        return "redirect:/users";
    }

}
