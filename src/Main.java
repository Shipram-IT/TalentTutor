import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        //initialize program
        Company myCompany;
        try {
            myCompany = new Company();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Menu mainMenu = new Menu(myCompany) ;

        while (true) {
            mainMenu.displayMenu();
            int choice = mainMenu.scanner.nextInt();
            mainMenu.processChoice(choice);
        }
    }
}

