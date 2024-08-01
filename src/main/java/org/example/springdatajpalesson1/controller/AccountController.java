package org.example.springdatajpalesson1.controller;

import org.example.springdatajpalesson1.entity.Account;
import org.example.springdatajpalesson1.service.AccountService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

   @RequestMapping(value = "/register",method = RequestMethod.GET)
   // @GetMapping("/registration")
    public String registrationGet() {
        return "registrationform";
   }

    @PostMapping("/reg_post")
    public String registrationPost(@RequestParam String login,
                                   @RequestParam String password,
                                   @RequestParam String repeatPassword,
                                   @RequestParam String email
                                   )
    {
        System.out.println("Start");
        if (password.equals(repeatPassword)) {
            Account account = new Account();
            account.setLogin(login);
            account.setPassword(password);
            account.setEmail(email);
            accountService.addAccount(account);
        }
        System.out.println("End");


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
