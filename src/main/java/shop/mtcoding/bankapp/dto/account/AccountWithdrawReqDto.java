package shop.mtcoding.bankapp.dto.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountWithdrawReqDto {
    private Long amount;
    private String WAccountNumber;
    private String WAccountPassword;
}