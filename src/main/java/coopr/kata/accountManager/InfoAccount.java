package coopr.kata.accountManager;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InfoAccount {

    // account is managed with a static float here, but would be a API GET value in reality
    public static float accountAmount = 0;

    public float checkBalance() {

        //would make an api call to check the balance here, but to make the project easy to run for everyone I used a simple txt file
        try {
            File myObj = new File("./src/main/resources/accountinfos.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                accountAmount = Float.parseFloat(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return accountAmount;
    }

    public float updateAccountBalance(String operation, float accountAmount, float amount)
            throws IOException {
        String str = String.valueOf(accountAmount);
        BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/resources/accountinfos.txt"));
        writer.write(str);
        writer.close();
        updateOperations(operation, amount);

        accountAmount = checkBalance();
        return accountAmount;
    }
    public int checkOperation() {

        //would make an api call to check the balance here, but to make the project easy to run for everyone I used a simple txt file

        System.out.println("Current Account Balance :  " + accountAmount + " euros");

        try {
            File myObj = new File("./src/main/resources/operationHistoric.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println("Historic of operations : ");
            while (myReader.hasNextLine()) {
                System.out.println(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0;

    }

    public void updateOperations(String action , float amount)
            throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String operationDate = dtf.format(now);

        BufferedWriter writer = new BufferedWriter(new FileWriter( new File("./src/main/resources/operationHistoric.txt"), true ));
        writer.append("Date : " + operationDate + "\n" + action + " " + amount + " euros.\n");
        writer.close();
    }
}
