package mocksenario.pk1;

public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
