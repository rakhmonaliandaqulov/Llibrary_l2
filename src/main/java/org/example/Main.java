package org.example;

import org.example.config.Config;
import org.example.controller.LoginController;
import org.example.db.Database;
import org.example.db.InitDatabase;
import org.example.entity.BookEntity;
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

        BookEntity e1 = new BookEntity();
        e1.setId(1);
        e1.setTitle("Gaurav");
        e1.setAuthor("Chawla");
        e1.setPublishYear("2003");
        e1.setVisible(true);
        e1.setAmount(123);

        session.save(e1);
        transaction.commit();

        factory.close();
        session.close();


    }
}