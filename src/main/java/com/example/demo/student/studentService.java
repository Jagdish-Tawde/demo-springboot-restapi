package com.example.demo.student;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class studentService {

    private final studentRepository studentRepository;

    @Autowired
    public studentService(studentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void registerNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudentById(Long studentId) {
        Optional<Student> byId = studentRepository.findById(studentId);
        if(!byId.isPresent()){
            throw new IllegalStateException("Id does not exit in system StudentId "+ studentId);
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId).
                orElseThrow(()-> new IllegalStateException("student with studentId :" + studentId +" does not exits"));

        if(name!=null && name.length()> 0 && !Objects.equals(student.getName(),name)){
           student.setName(name);
        }

        if(email!=null && email.length()> 0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if(studentByEmail.isPresent()){
                throw new IllegalStateException("Email Id already Exists " + email);
            }
            student.setEmail(email);
        }

    }
}
