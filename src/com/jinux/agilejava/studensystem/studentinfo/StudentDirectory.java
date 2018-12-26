package com.jinux.agilejava.studensystem.studentinfo;

import com.jinux.agilejava.studensystem.studentinfo.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentDirectory {
    private Map<String, Student> map = new HashMap<>();

    public void add(Student student) {
        map.put(student.getId(), student);
    }

    public Student findById(String id) {
        return map.get(id);
    }
}
