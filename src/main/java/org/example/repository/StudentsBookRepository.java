package org.example.repository;

import org.example.dto.Book;
import org.example.dto.StudentsBook;
import org.example.enums.BookStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int save(StudentsBook studentsBook) {
        String sql = "insert into students_book (created_date,status,returned_date,duration,student_id,book_id) " +
                "values (now(),'%s','%s','%s',%s,%s)";
        sql = String.format(sql, studentsBook.getStatus(),studentsBook.getReturnedDate(),studentsBook.getDuration(),
                studentsBook.getStudentId(), studentsBook.getBookId());
        return jdbcTemplate.update(sql);
    }
    public List<Book> getOrderInfoListByStudentId(Integer id) {
        if (id == null){
            String sql = " select sb.id as sbid, b.id as book_id, b.title as book_title, b.author as book_author,sb.created_date as taken_date," +
                    "s.name as student_name , s.surname as student_surname, s.phone as student_phone from students_book as sb " +
                    "inner join book as b on sb.book_id = b.id " +
                    "inner join student as s on sb.student_id = s.id" +
                    " where sb.status = '" + BookStatus.TAKEN + "' ;";
            List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
            return list;
        }
        return null;
    }

    public List<StudentsBook> userTakenList() {
        String sql = "select sb.id, b.title, b.author, sb.created_date from book as b " +
                "inner join students_book as sb on sb.book_id = b.id " +
                "inner join student as s on s.id = sb.student_id " +
                "where sb.status = 'TAKEN'";
        List<StudentsBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentsBook.class));
        return list;
    }

    public List<StudentsBook> userReturnedList() {
        String sql = "select sb.id, b.title, b.author, sb.created_date from book as b " +
                "inner join students_book as sb on sb.book_id = b.id " +
                "inner join student as s on s.id = sb.student_id " +
                "where sb.status = 'RETURNED'";
        List<StudentsBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentsBook.class));
        return list;
    }

    public List<StudentsBook> userHistoryLibrary() {
        String sql = "select sb.id, b.title, b.author, sb.created_date from book as b " +
                "inner join students_book as sb on sb.book_id = b.id " +
                "inner join student as s on s.id = sb.student_id ";
        List<StudentsBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentsBook.class));
        return list;
    }

    public List<StudentsBook> adminTakenBookStudentList() {
        String sql = "select sb.id, s.name, s.surname, s.phone, b.title, sb.created_date from book as b " +
                "inner join students_book as sb on sb.book_id = b.id " +
                "inner join student as s on s.id = sb.student_id " +
                "where sb.status = 'TAKEN'";
        List<StudentsBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentsBook.class));
        return list;
    }
    public List<StudentsBook> adminBookAllHistory() {
        String sql = "select sb.id, s.name, s.surname, s.phone, b.title, sb.created_date from book as b " +
                "inner join students_book as sb on sb.book_id = b.id " +
                "inner join student as s on s.id = sb.student_id ";
        List<StudentsBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentsBook.class));
        return list;
    }
}
