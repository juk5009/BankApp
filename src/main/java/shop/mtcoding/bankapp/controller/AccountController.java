package shop.mtcoding.bankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping({ "/", "/account" })
    public String main() {

        // throw new CustomException("인증되지 않았습니다", HttpStatus.UNAUTHORIZED);
        return "account/main";
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
