package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class studentRepositoryTest {


    @Autowired
    private studentRepository studentRepositoryUnderTest;


    @AfterEach
    void tearDown() {
       studentRepositoryUnderTest.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentEmailExits() {
        //given
        String email = "Ajjjj@jdj";
        Student student = new Student("Ajay", email, LocalDate.of(2021, 7, 9));
        studentRepositoryUnderTest.save(student);
        //when
        Optional<Student> studentByEmail = studentRepositoryUnderTest.findStudentByEmail(email);
        //then
           assertThat(studentByEmail.isPresent()).isTrue();
    }

    @Test
    void itShouldCheckIfStudentDoesNotExist() {
        //given
        String email = "Ajjjj@jdj";
        //when
        Optional<Student> studentByEmail = studentRepositoryUnderTest.findStudentByEmail(email);
        //then
        assertThat(studentByEmail.isPresent()).isFalse();
    }
}