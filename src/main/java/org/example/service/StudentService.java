package org.example.service;

import org.example.dto.Student;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public void addStudent(String name, String surname, String phone, String birthDate) {
        Student exists = studentRepository.getStudentByPhone(phone);
        if (exists != null) {
            System.out.println("Student phone exists.");
        }

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setPhone(phone);
        student.setBirthDate(LocalDate.parse(birthDate));

        int n = studentRepository.save(student);

        if (n != 0) {
            System.out.println("Student added successfully");
            return;
        } else {
            System.out.println("ERROR");
        }
    }
}
