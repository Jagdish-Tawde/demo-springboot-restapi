package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class studentServiceTest {

    @Mock
    private studentRepository studentRepository;
    private studentService studentServiceUnderTest;
    // commented code is for Mockito
  //  private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() {
      //   autoCloseable = MockitoAnnotations.openMocks(this);
        studentServiceUnderTest = new studentService(studentRepository);
    }

   /* @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }*/

    @Test
    void canGetAllStudent() {
        //when
        studentServiceUnderTest.getStudent();
        //then
        verify(studentRepository).findAll();
    }

    @Test
    void registerNewStudent() {
        //given
        Student student = new Student("jad", "aj@jj", LocalDate.of(1996, Month.JULY, 2));
        //when
        studentServiceUnderTest.registerNewStudent(student);
        //then
        ArgumentCaptor<Student> studentArgumentCaptor=
                ArgumentCaptor.forClass(Student.class);

        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student capturedValue = studentArgumentCaptor.getValue();

        assertThat(capturedValue).isEqualTo(student);

    }


    @Test
    @Disabled
    void deleteStudentById() {
    }
}