package org.example;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;
import coopr.kata.accountManager.Operations;


public class Main {

    //can clear the code by splitting function in multiple files
    //every functionality are implemented

    public static void main(String[] args) throws IOException {
        welcome();
        workflowSelection();
    }

    public static void welcome( ) {
        System.out.println("Welcome ! \n");
        System.out.println("Insert card");
        checkCreditCardInfo();
        System.out.println("Enter Pin");
        checkPin();
    }

    protected static void workflowSelection() throws IOException {
        int workflow = 0;

        Operations operationsManager = new Operations();

        System.out.println("\nPress 1 to Deposit money.");
        System.out.println("Press 2 to Withdraw money.");
        System.out.println("Press 3 to check your operations.");
        System.out.println("Press anything else to exit.");

        Scanner userInt = new Scanner(System.in);
        String userInp = userInt.nextLine();
        if (userInp.matches("\\d")){// Checks if userInp is a single digit

            workflow = Integer.parseInt(userInp); // Turns the userInp(String) into the userNumber (Integer)
            switch (workflow) {
                case 1:
                    operationsManager.depositMoney();
                    break;
                case 2:
                    operationsManager.withdrawMoney();
                    break;
                case 3:
                    operationsManager.checkAccount();
                    break;
                default :
                    break;
            }
        }
        else {
            System.out.println("Thank you, have a nice day !\n");
        }

    }

    private static void checkCreditCardInfo( ) {
        //implement business logic here to check on card infos
    }
    private static void checkPin( ) {
        //implement business logic here to check credit card PIN
        System.out.println("correct PIN");
    }

}