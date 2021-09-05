package mocksenario.pk1;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : mahdi ,  Date : 9/5/2021
 */
public class MockAccountManager implements AccountManager {

    private Map<String, Account> accounts = new HashMap<String, Account>();

    public void addAccount(String userId, Account account) {
        this.accounts.put(userId, account);
    }

    @Override
    public Account findAccountForUser(String userId) {
        return this.accounts.get(userId);
    }

    @Override
    public void updateAccount(Account account) {
    // do nothing
    }
}
