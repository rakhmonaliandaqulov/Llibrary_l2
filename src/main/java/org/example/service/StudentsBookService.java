package org.example.service;

import org.example.dto.Book;
import org.example.dto.Student;
import org.example.dto.StudentsBook;
import org.example.enums.BookStatus;
import org.example.repository.BookRepository;
import org.example.repository.StudentsBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class StudentsBookService {
    @Autowired
    private StudentsBookRepository studentsBookRepository;
    @Autowired
    private BookRepository bookRepository;
    public void takeBook(Integer id, Integer duration, Student student) {
        int count = studentsBookRepository.getOrderInfoListByStudentId(student.getId()).size();
        Book book = bookRepository.getBookById(id);
        System.out.println(book);
        if (book == null){
            System.out.println("\n Book not found \n Please, try again to another book");
            return;
        } else if (count > 5) {
            System.out.println("You had 5 books!");
            return;
        }
        StudentsBook studentBook = new StudentsBook();
        studentBook.setCreatedDate(LocalDateTime.now());
        studentBook.setStatus(BookStatus.TAKEN);
        LocalDateTime localDateTime = LocalDateTime.now();
        studentBook.setReturnedDate(localDateTime);
        studentBook.setDuration(duration);
        studentBook.setBookId(book.getId(id));
        studentBook.setStudentId(student.getId());

        studentsBookRepository.save(studentBook);
        book.setAmount(book.getAmount() - 1);
        bookRepository.updateBook(book.getId(id),book);

        System.out.println("You taken book.");
    }
}
