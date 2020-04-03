package com.example.bftest.response;

import com.example.bftest.pojo.BfUser;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/4/3 22:56
 * @Description: 沈泽鹏写点注释吧
 */
@Data
public class FindAllUserResponse {
    private List<BfUser> bfUserList=new ArrayList<>();
}
