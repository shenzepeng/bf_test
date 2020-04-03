package com.example.bftest.handler.impl;

import com.example.bftest.bo.TestInfoBo;
import com.example.bftest.bo.UserInfoBo;
import com.example.bftest.constants.BfTestConstants;
import com.example.bftest.handler.FileExcelUploadHandler;
import com.example.bftest.pojo.BfQuestion;
import com.example.bftest.pojo.BfUser;
import com.example.bftest.utils.ExcelTestIfnoToDBUtils;
import com.example.bftest.utils.ExcelUserIfnoToDBUtils;
import com.example.bftest.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 16:54
 * @Description: 获取excel的内容
 */
@Service
@Slf4j
public class FileExcelUploadHandlerImpl implements FileExcelUploadHandler {
  
    @Override
    public List<BfUser> getUserPojo(MultipartFile file, Short type) {
        List<UserInfoBo> excelToDb = ExcelUserIfnoToDBUtils.getExcelToDb(file);
        log.info("excelToDb-{}", JsonUtils.objectToJson(excelToDb));
        List<UserInfoBo> collect = excelToDb.stream().filter(t -> !t.getChinese().equals(BfTestConstants.CHINESE_NAME)).collect(Collectors.toList());
        List<BfUser> list=collect.stream()
                .map((t) -> new BfUser(t.getPhoneNumber(), t.getPhoneNumber(),type, t.getNumber(), t.getChinese()))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<BfQuestion> getBfQuestion(MultipartFile file, Long teacherId) {
        List<TestInfoBo> excelToDb = ExcelTestIfnoToDBUtils.getExcelToDb(file);
        List<TestInfoBo> testInfoList = excelToDb.stream().filter(t -> !t.getQuestion().equals(BfTestConstants.QUESTION)).collect(Collectors.toList());
        List<BfQuestion> collect = testInfoList.stream().map(t -> new BfQuestion(t.getQuestion(), teacherId, t.getCode()))
                .collect(Collectors.toList());
        return collect;
    }
}
