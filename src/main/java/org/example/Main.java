package org.example;

import org.example.config.Config;
import org.example.controller.LoginController;
import org.example.db.Database;
import org.example.db.InitDatabase;
import org.example.entity.BookEntity;
import org.example.entity.StudentEntity;
import org.example.entity.StudentsBookEntity;
import org.example.enums.GeneralStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
       // Database.initTable();
       // ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        //InitDatabase initDatabase = (InitDatabase) context.getBean("initDatabase");
        //initDatabase.adminInit();
        //LoginController loginController = (LoginController) context.getBean("loginController");
       // loginController.start();
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        StudentEntity e2 = new StudentEntity();
        e2.setId(1);
        e2.setName("Admin");
        e2.setSurname("Adminov");
        e2.setPhone("+998998887766");
        e2.setBirthDate(LocalDate.parse("2000-12-12"));
        e2.setStatus("ADMIN");

        session.save(e2);
        transaction.commit();

        factory.close();
        session.close();
    }
}