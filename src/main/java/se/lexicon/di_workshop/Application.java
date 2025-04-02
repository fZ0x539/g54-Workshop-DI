package se.lexicon.di_workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.di_workshop.config.ComponentScanConfig;
import se.lexicon.di_workshop.data_access.StudentDao;
import se.lexicon.di_workshop.data_access.StudentDaoImpl;
import se.lexicon.di_workshop.models.Student;
import se.lexicon.di_workshop.service.StudentManagement;
import se.lexicon.di_workshop.service.StudentManagementConsoleImpl;
import se.lexicon.di_workshop.util.ScannerInputService;
import se.lexicon.di_workshop.util.UserInputService;


public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
//        StudentDao studentDao = context.getBean(StudentDao.class);
//        UserInputService userInputService = context.getBean(UserInputService.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        //create
        Student student2 = studentManagement.create();
        //save
        Student student1 = studentManagement.save(new Student(100, "Botond"));
        //findAll
        studentManagement.findAll();
        //edit
        student1 = studentManagement.edit(student1);
        //find
        studentManagement.find(student1.getId());
        //remove
        studentManagement.remove(student1.getId());
        studentManagement.findAll();
    }

}
