package com.example.bftest;

import com.example.bftest.response.GetAllFinishResponse;
import com.example.bftest.response.GetNewExamResponse;
import com.example.bftest.service.ExamService;
import com.example.bftest.service.StudentService;
import com.example.bftest.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BftestApplicationTests {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ExamService examService;
    @Test
    void contextLoads() {
        GetNewExamResponse examByUserId = examService.getExamByUserId(42L);
       // GetAllFinishResponse list = studentService.getList(42L);
        System.out.println(JsonUtils.objectToJson(examByUserId));
    }

}
