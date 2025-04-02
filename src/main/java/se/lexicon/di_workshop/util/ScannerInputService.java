package se.lexicon.di_workshop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerInputService implements UserInputService {
    private Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        while(true){
            try{
                return Integer.parseInt(scanner.nextLine()); //Uses nextLine instead of nextInt to avoid common scanner issues with newline cahtacters
            } catch ( NumberFormatException e){
                System.err.println("Invalid input. Please enter a valid integer. " + e.getMessage());
            }
        }
    }
}
