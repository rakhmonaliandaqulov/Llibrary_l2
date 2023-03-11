package org.example.repository;

import org.example.db.Database;
import org.example.dto.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookRepository {
    public int save(Book book) {
        Connection connection = Database.getConnection();
        try {
            String sql = "insert into book (title, author, pulish_year, amount, visible) " + " values ('%s','%s','%s','%s','%s')";
            sql = String.format(sql, book.getTitle(), book.getAuthor(), book.getPublishYear(), book.getAmount(), card.getPhone(), card.getCreatedDate());

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
}
