package shop.mtcoding.bankapp.model.account;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    public int insert(Account Account);

    public int updateById(Account account);

    public int deleteById(int id);

    public List<Account> findAll();

    public Account findById(int id);

    public List<Account> findByUserId(int id);

    public Account findByNumber(String number);
}