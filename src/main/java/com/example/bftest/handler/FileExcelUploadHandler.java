package com.example.bftest.handler;

import com.example.bftest.pojo.BfQuestion;
import com.example.bftest.pojo.BfUser;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/1 16:53
 * @Description: 沈泽鹏写点注释吧
 */

public interface FileExcelUploadHandler {
    List<BfUser> getUserPojo(MultipartFile file, Short type);
    List<BfQuestion> getBfQuestion(MultipartFile file,Long teacherId);
}
