package coopr.kata.accountManager;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InfoAccountTest {

    @Test
    void checkBalance() throws IOException {
        var accountManager = new InfoAccount();
        assertEquals(1, accountManager.checkBalance());
    }

    @Test
    void didWithdrawUpdateAccountInfo() throws IOException {
        var accountManager = new InfoAccount();
        assertEquals( 0, accountManager.updateAccountBalance("withdraw", 1000, 1000));

    }

    @Test
    void didUpdateAccountInfo() throws IOException {
        var accountManager = new InfoAccount();
        accountManager.updateAccountBalance("withdraw", 1000, 1000);
        assertEquals(0, accountManager.checkBalance());
    }

}