package org.example.repository;

import org.example.db.Database;
import org.example.dto.Book;
import org.example.enums.GeneralStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BookRepository {
    public int save(Book book) {
        Connection connection = Database.getConnection();
        try {
            String sql = "insert into book (title, author, pulish_year, amount) " + " values ('%s','%s','%s','%s')";
            sql = String.format(sql, book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getAmount());

            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }
    public List<Book> getList() {
        List<Book> result = new LinkedList<>();
        try {
            Connection connection = Database.getConnection();
            String sql = "select * from book ";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Integer bookId = resultSet.getInt("id");
                String bookTitle = resultSet.getString("title");
                String author = resultSet.getString("author");
                LocalDate publish_year = resultSet.getDate("publish_year").toLocalDate();
                Integer amount  = resultSet.getInt("amount");
                Boolean visible = resultSet.getBoolean("visible");

                Book book = new Book();
                book.setId(bookId);
                book.setTitle(bookTitle);
                book.setAuthor(author);
                book.setPublishYear(publish_year);
                book.setAmount(amount);
                book.setVisible(visible);

                result.add(book);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
    public int deleteBook(Integer id) {
        try (Connection connection = Database.getConnection()) {
            String sql = String.format("update card set visible = false where  card_number = '%s'", id);

            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }
}
