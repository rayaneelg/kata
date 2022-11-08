package coopr.kata.accountManager;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @Test
    void checkNegativeDeposit() throws IOException {
        var operation = new Operations();
        assertEquals(1, operation.checkDeposit(-100));
    }

    @Test
    void checkNulDeposit() throws IOException {
        var operation = new Operations();
        assertEquals(1, operation.checkDeposit(0));
    }

    @Test
    void checkCorrectDeposit() throws IOException {
        var operation = new Operations();
        assertEquals(0, operation.checkDeposit(100));
    }

    @Test
    void withdrawMoney() {
    }

    @Test
    void depositMoney() {
    }

    @Test
    void checkAccount() {
    }
}