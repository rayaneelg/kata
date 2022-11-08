package coopr.kata.accountManager;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InfoAccountTest {

    @Test
    void checkBalance() throws IOException {
        var accountManager = new InfoAccount();
        assertNotEquals((Float) null, accountManager.checkBalance());
    }

    @Test
    void didDepositUpdateAccountInfo() throws IOException {
        var accountManager = new InfoAccount();
        assertEquals( 2000, accountManager.updateAccountBalance("deposit", 2000, 2000));
    }

    @Test
    void didUpdateAccountInfo() throws IOException {
        var accountManager = new InfoAccount();
        accountManager.updateAccountBalance("withdraw", 1000, 1000);
        assertEquals(1000, accountManager.checkBalance());
    }

}