package se.lexicon.di_workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.di_workshop.config.ComponentScanConfig;
import se.lexicon.di_workshop.data_access.StudentDao;
import se.lexicon.di_workshop.data_access.StudentDaoImpl;
import se.lexicon.di_workshop.models.Student;
import se.lexicon.di_workshop.util.ScannerInputService;
import se.lexicon.di_workshop.util.UserInputService;


public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);


        System.out.println("Enter a name: ");
        String name = userInputService.getString();
        System.out.println("Now enter an ID: ");
        int id = userInputService.getInt();
        studentDao.save(new Student(id, name));
        studentDao.findAll().forEach(System.out::println);
    }

}
