package org.example.repository;

import org.example.db.Database;
import org.example.dto.Book;
import org.example.dto.Student;
import org.example.enums.GeneralStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int save(Student student) {
        Connection connection = Database.getConnection();
        try {
            String sql = "insert into student (name, surname, phone, status, birth_date, visible) " + " values ('%s','%s','%s','%s','%s')";
            sql = String.format(sql, student.getName(), student.getSurname(), student.getPhone(), student.getStatus(), student.getBirthDate());

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
   /* public void save(Student student) {
        String sql = "insert into student (name,surname, phone, birth_date, status) values ('%s','%s','%s','%s')";
        sql = String.format(sql, student.getName(), student.getSurname(), student.getPhone(), student.getBirthDate(), student.getStatus());
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }*/
   /* public Student geStudentByPhone(String phone) {
        Connection connection = null;
        try {
            connection = Database.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select * from student where phone= '%s';", phone);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
                return student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(-1);
            }

        }
        return null;
    }*/
   /*public Student  getStudentByPhone(String phone) {
       String sql = "SELECT * FROM student where phone =" + phone;
       Student student = (Student) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
       return student;
   }*/
   public Student getStudentByPhone(String phone) {
       Connection connection = null;
       try {
           connection = Database.getConnection();
           Statement statement = connection.createStatement();
           String sql = String.format("Select  * from student where phone= '%s';", phone);
           ResultSet resultSet = statement.executeQuery(sql);

           while (resultSet.next()) {
               Student profile = new Student();
               profile.setId(resultSet.getInt("id"));
               profile.setName(resultSet.getString("name"));
               profile.setSurname(resultSet.getString("surname"));
               profile.setPhone(resultSet.getString("phone"));
               profile.setStatus(GeneralStatus.valueOf(resultSet.getString("status")));
               return profile;
           }

       } catch (SQLException e) {
           e.printStackTrace();
           System.exit(-1);
       } finally {

           try {
               if (connection != null) {
                   connection.close();
               }

           } catch (SQLException e) {
               e.printStackTrace();
               System.exit(-1);
           }

       }
       return null;
   }
    public List<Student> getStudentList() {
        try (Connection connection = Database.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            List<Student> studentList = new LinkedList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setBirthDate(resultSet.getDate("birth_daye").toLocalDate());

                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
