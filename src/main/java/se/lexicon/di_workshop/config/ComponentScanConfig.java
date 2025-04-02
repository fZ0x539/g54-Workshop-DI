package se.lexicon.di_workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.di_workshop.util.ScannerInputService;
import se.lexicon.di_workshop.util.UserInputService;

import java.util.Scanner;

@Configuration
@ComponentScan("se.lexicon.di_workshop")
public class ComponentScanConfig {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

}
