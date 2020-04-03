package com.example.bftest.utils;

import com.example.bftest.bo.TestInfoBo;
import com.example.bftest.bo.UserInfoBo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/1 13:56
 * @Description: 题目信息导入？
 * */
@Slf4j
@Component
public class ExcelTestIfnoToDBUtils {
    public static synchronized List<TestInfoBo> getExcelToDb(MultipartFile multipartFile) {
        List<TestInfoBo> userInfoBoList = new ArrayList<>();
        try {
            //原文件名
            String fileName = multipartFile.getOriginalFilename();
            InputStream inputStream = multipartFile.getInputStream();
            List<List<Cell>> bankListByExcel = ImportExcelUtil.getBankListByExcel(inputStream, fileName);
            if (!CollectionUtils.isEmpty(bankListByExcel)){
                for (List<Cell> cellList:bankListByExcel){
                    TestInfoBo testInfoBo = cellListToExcelBo(cellList);
                    if (!StringUtils.isEmpty(testInfoBo.getCode())&&
                    !StringUtils.isEmpty(testInfoBo.getQuestion())) {
                        userInfoBoList.add(testInfoBo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoBoList;
    }

    private static TestInfoBo cellListToExcelBo(List<Cell> cellList){
        TestInfoBo testInfoBo=new TestInfoBo();
        Cell cell = null;
        Cell cell1 = null;
        try  {
            cell = cellList.get(0);
            cell1 = cellList.get(1);
        }catch (Exception e){
            log.info("该信息没有相关内容----{}",e.getMessage());
        }

        if (cell!=null){
            //如何防止数字变成科学计数法的形式
            DecimalFormat df = new DecimalFormat("0");
            String whatYourWant = df.format(cell.getNumericCellValue());
            testInfoBo.setCode(whatYourWant);
        }
        if (cell1!=null){
            testInfoBo.setQuestion(CleanLinefeedUtils.replaceBlank(cell1.toString()));
        }
        log.info("testInfoBo-{}",JsonUtils.objectToJson(testInfoBo));
        return testInfoBo;
    }
}
