package com.example.bftest.controller;

import com.example.bftest.common.SzpJsonResult;
import com.example.bftest.constants.BfTestConstants;
import com.example.bftest.handler.FileExcelUploadHandler;
import com.example.bftest.pojo.BfQuestion;
import com.example.bftest.pojo.BfUser;
import com.example.bftest.response.IntegerResultResponse;
import com.example.bftest.service.QuestionService;
import com.example.bftest.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.logging.Handler;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 12:57
 * @Description: 写点注释
 */
@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private FileExcelUploadHandler fileExcelUploadHandler;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;
    /**
     * 上传考试题目
     */
    @ApiOperation("上传考试题目")
    @PostMapping("question")
    public SzpJsonResult<IntegerResultResponse> uploadQuestion(MultipartFile file, Long teacherId) {
        List<BfQuestion> bfQuestion = fileExcelUploadHandler.getBfQuestion(file, teacherId);
        return SzpJsonResult.ok(questionService.addQuestionByFileList(bfQuestion));
    }

    /**
     * 上传老师名单
     */

    @ApiOperation("上传老师名单")
    @PostMapping("teacher/list")
    public SzpJsonResult<IntegerResultResponse> uploadTeacherList(MultipartFile file) {
        List<BfUser> userPojo = fileExcelUploadHandler.getUserPojo(file, BfTestConstants.TEACHER_TYPE);
        return SzpJsonResult.ok(userService.addUserList(userPojo));
    }

    /**
     * 上传学生名单
     */
    @ApiOperation("上传学生名单")
    @PostMapping("children/list")
    public SzpJsonResult<IntegerResultResponse> uploadChildrenList(MultipartFile file) {
        List<BfUser> userPojo = fileExcelUploadHandler.getUserPojo(file, BfTestConstants.STUDENT_TYPE);
        return SzpJsonResult.ok(userService.addUserList(userPojo));
    }
}
