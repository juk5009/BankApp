package shop.mtcoding.bankapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.bankapp.handler.ex.CustomException;

@Controller
public class AccountController {

    // @GetMapping({ "/", "/main" })
    // public String main() {

    // return "account/main";

    // }

    @GetMapping({ "/", "/account" })
    public String main() {

        throw new CustomException("인증되지 않았습니다", HttpStatus.UNAUTHORIZED);
        // return "account/main";
    }

    @GetMapping("/depositoryForm")
    public String depositoryForm() {

        return "account/depositoryForm";
    }

    @GetMapping("/detail")
    public String detail() {

        return "account/detail";
    }

    @GetMapping("/saveForm")
    public String saveForm() {

        return "account/saveForm";
    }

    @GetMapping("/transferForm")
    public String transferForm() {

        return "account/transferForm";
    }

    @GetMapping("/withdrawForm")
    public String withdrawForm() {

        return "account/withdrawForm";
    }

}
