package com.friday.School.controller;

import com.friday.School.entity.Subject;
import com.friday.School.entity.Teacher;
import com.friday.School.service.SubjectService;
import com.friday.School.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(subjectService.findAllSubjects(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        return new ResponseEntity<>(subjectService.createSubject(subject), HttpStatus.CREATED);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public ResponseEntity<Subject> assignTeacherToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long teacherId) {

        Optional<Subject> currentSubject = subjectService.findSubject(subjectId);

        if(!currentSubject.isPresent()) {
            return new ResponseEntity<>(currentSubject.get(), HttpStatus.NOT_FOUND);
        }

        Optional<Teacher> currentTeacher = teacherService.findTeacher(teacherId);

        if (!currentTeacher.isPresent()) {
            return new ResponseEntity<>(currentSubject.get(), HttpStatus.NOT_FOUND);
        }

        currentSubject.get().setTeacher(currentTeacher.get());

        Subject subject = subjectService.createSubject(currentSubject.get());

        return new ResponseEntity<>(subject, HttpStatus.OK);



    }

}








