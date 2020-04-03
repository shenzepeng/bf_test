package com.example.bftest.utils;

import com.example.bftest.bo.UserInfoBo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2019-09-04 13:41
 * @Description: 导入信息
 */
@Slf4j
public class ExcelUserIfnoToDBUtils {
    public static synchronized List<UserInfoBo> getExcelToDb(MultipartFile multipartFile) {
        List<UserInfoBo> userInfoBoList = new ArrayList<>();
        try {
            //原文件名
            String fileName = multipartFile.getOriginalFilename();
            InputStream inputStream = multipartFile.getInputStream();
            List<List<Cell>> bankListByExcel = ImportExcelUtil.getBankListByExcel(inputStream, fileName);
            if (!CollectionUtils.isEmpty(bankListByExcel)) {
                for (List<Cell> cellList : bankListByExcel) {
                    UserInfoBo userInfoBo = cellListToExcelBo(cellList);
                    if (!StringUtils.isEmpty(userInfoBo.getChinese()) &&
                            !StringUtils.isEmpty(userInfoBo.getNumber()) &&
                            !StringUtils.isEmpty(userInfoBo.getPhoneNumber())) {
                        userInfoBoList.add(userInfoBo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoBoList;
    }

    private static UserInfoBo cellListToExcelBo(List<Cell> cellList) {
        UserInfoBo userInfoBo = new UserInfoBo();
        Cell cell = null;
        Cell cell1 = null;
        Cell cell2 = null;

        try {
            cell = cellList.get(0);
            cell1 = cellList.get(1);
            cell2 = cellList.get(2);
            log.info("cell-{},cell1-{},cell2-{}",JsonUtils.objectToJson(cell.toString()), JsonUtils.objectToJson(cell1.toString()),JsonUtils.objectToJson(cell2.toString()));
        } catch (Exception e) {
            log.info("该信息没有相关内容----{}", e.getMessage());
        }

        if (cell != null) {
            //如何防止数字变成科学计数法的形式
            DecimalFormat df = new DecimalFormat("0");
            String whatYourWant = df.format(cell.getNumericCellValue());
            userInfoBo.setNumber(whatYourWant);
        }
        if (cell1 != null) {
            userInfoBo.setChinese(CleanLinefeedUtils.replaceBlank(cell1.toString()));
        }
        if (cell2 != null) {
            DecimalFormat df = new DecimalFormat("0");
            String whatYourWant = df.format(cell2.getNumericCellValue());
            userInfoBo.setPhoneNumber(whatYourWant);
        }
        log.info("userInfoBo-{}",JsonUtils.objectToJson(userInfoBo));
        return userInfoBo;
    }
}
