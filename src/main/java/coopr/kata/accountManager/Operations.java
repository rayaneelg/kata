package coopr.kata.accountManager;

import org.example.Main;

import java.io.IOException;
import java.util.Scanner;

public class Operations extends Main {
    public void withdrawMoney( ) throws IOException {

        InfoAccount accountManager = new InfoAccount();
        System.out.println("\nwithdraw Selected\n");

        int withdrawnAmount = 0;

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Insert cash amount to withdraw");
        withdrawnAmount = reader.nextInt();

        accountManager.checkBalance();

        if (accountManager.accountAmount >= withdrawnAmount && withdrawnAmount > 0) {
            accountManager.accountAmount = accountManager.accountAmount - withdrawnAmount;
            accountManager.updateAccountBalance("withdraw", accountManager.accountAmount,withdrawnAmount);

        } else {
            System.out.println("Insufficient funds, please take your credit card");
            if (withdrawnAmount <= 0)
                System.out.println("Wrong value");
            return;
        }

        //get account balance by api request here
        System.out.println(withdrawnAmount + " euros withdraw confirmed\n" + "Your balance is now " +  accountManager.accountAmount + "euros");
        System.out.println("Please take your credit card and cash");
        workflowSelection();
    }

    public int depositMoney( ) {

        InfoAccount accountManager = new InfoAccount();

        System.out.println("\nDeposit Selected\n");

        int depositAmount = 0;

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Insert cash amount to deposit");
        depositAmount = reader.nextInt();

        try {
            if(checkDeposit(depositAmount) == 1) {
                return 1;
            }
            accountManager.checkBalance();

            accountManager.accountAmount = accountManager.accountAmount + depositAmount;

            accountManager.updateAccountBalance("deposit", accountManager.accountAmount,depositAmount);


            System.out.println(depositAmount + " euros deposit confirmed\n" + "Your balance is now " +  accountManager.accountAmount + " euros");

            workflowSelection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    protected int checkDeposit(float depositAmount ) throws IOException {
        //implement business logic here to check cash deposit
        if(depositAmount <= 0) {
            System.out.println("Incorrect deposit, back to home");
            return 1;
        }
        return 0;
    }

    public void checkAccount() {

        InfoAccount accountManager = new InfoAccount();

        System.out.println("\nChecking account selected\n");

        accountManager.checkBalance();

        accountManager.checkOperation();

        try {
            workflowSelection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
