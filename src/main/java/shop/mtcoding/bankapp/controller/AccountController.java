package shop.mtcoding.bankapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.bankapp.dto.account.AccountDepositReqDto;
import shop.mtcoding.bankapp.dto.account.AccountSaveReqDto;
import shop.mtcoding.bankapp.dto.account.AccountWithdrawReqDto;
import shop.mtcoding.bankapp.handler.ex.CustomException;
import shop.mtcoding.bankapp.model.account.Account;
import shop.mtcoding.bankapp.model.account.AccountRepository;
import shop.mtcoding.bankapp.model.user.User;
import shop.mtcoding.bankapp.service.AccountService;

@Controller
public class AccountController {

    @PostMapping("/account/deposit")
    public String deposit(AccountDepositReqDto accountDepositoryReqDto) {
        if (accountDepositoryReqDto.getAmount() == null) {
            throw new CustomException("amount를 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        if (accountDepositoryReqDto.getDAccountNumber() == null
                || accountDepositoryReqDto.getDAccountNumber().isEmpty()) {
            throw new CustomException("계좌번호를 입력해주세요", HttpStatus.BAD_REQUEST);
        }

        int accountId = accountService.계좌입금(accountDepositoryReqDto);

        return "redirect:/account/" + accountId;
    }

    @PostMapping("/account/withdraw")
    public String withdraw(AccountWithdrawReqDto accountWithdrawReqDto) {
        if (accountWithdrawReqDto.getAmount() == null) {
            throw new CustomException("amount를 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        if (accountWithdrawReqDto.getWAccountNumber() == null || accountWithdrawReqDto.getWAccountNumber().isEmpty()) {
            throw new CustomException("계좌번호를 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        if (accountWithdrawReqDto.getWAccountPassword() == null
                || accountWithdrawReqDto.getWAccountPassword().isEmpty()) {
            throw new CustomException("계좌비밀번호를 입력해주세요", HttpStatus.BAD_REQUEST);
        }

        int accountId = accountService.계좌출금(accountWithdrawReqDto);

        return "redirect:/account/" + accountId;
    }

    @Autowired
    private HttpSession session;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/account")
    public String save(AccountSaveReqDto accountSaveReqDto) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            throw new CustomException("로그인을 먼저 해주세요", HttpStatus.UNAUTHORIZED);
        }

        if (accountSaveReqDto.getNumber() == null || accountSaveReqDto.getNumber().isEmpty()) {
            throw new CustomException("number를 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        if (accountSaveReqDto.getPassword() == null || accountSaveReqDto.getPassword().isEmpty()) {
            throw new CustomException("password를 입력해주세요", HttpStatus.BAD_REQUEST);
        }

        accountService.계좌생성(accountSaveReqDto, principal.getId());

        return "redirect:/";
    }

    @GetMapping({ "/", "/account" })
    public String main(Model model) { // model에 값을 추가하면 request에 저장된다
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/loginForm";
        }

        List<Account> accountList = accountRepository.findByUserId(principal.getId());
        model.addAttribute("accountList", accountList);

        return "account/main";
    }

    @GetMapping("/account/{id}")
    public String detail(@PathVariable int id) {
        return "account/detail";
    }

    @GetMapping("/account/saveForm")
    public String saveForm() {
        return "account/saveForm";
    }

    @GetMapping("/account/withdrawForm")
    public String withdrawForm() {
        return "account/withdrawForm";
    }

    @GetMapping("/account/depositForm")
    public String depositForm() {
        return "account/depositForm";
    }

    @GetMapping("/account/transferForm")
    public String transferForm() {
        return "account/transferForm";
    }
}