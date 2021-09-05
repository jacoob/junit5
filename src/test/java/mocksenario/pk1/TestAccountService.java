package mocksenario.pk1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author : mahdi ,  Date : 9/5/2021
 */
public class TestAccountService {
    @Test
    public void testTransferOk() {

        //1- setup : we create the MockAccountManager object and define what it should return when it’s called for the two accounts we manipulate
        // (the sender and beneficiary accounts).
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);

        MockAccountManager mockAccountManager = new MockAccountManager();
        mockAccountManager.addAccount("1", senderAccount);
        mockAccountManager.addAccount("2", beneficiaryAccount);

        //We have succeeded in testing the AccountService code in isolation from the other domain object, AccountManager, which in this case
        // did not exist but could have been implemented with JDBC in real life.
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);

        //2- execution : setting the expectations of the mockAccountManager object by adding two accounts to it transforms it into our own defined mock.
        accountService.transfer("1", "2", 50);

        //3- verification of the results
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }
}
