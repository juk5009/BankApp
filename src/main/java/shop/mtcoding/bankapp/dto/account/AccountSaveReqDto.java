package shop.mtcoding.bankapp.dto.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountSaveReqDto {
    private int id;
    private String number;
    private String password;
}
