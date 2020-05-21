package com.sccddw.test.controller;

import com.sccddw.test.entity.bean.ResultCode;
import com.sccddw.test.entity.bean.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * description
 *
 * @author dell
 * date 2020/5/20 19:48
 * @version 1.0
 **/
@Slf4j
@RestController
@Api(tags = {"FileController"}, description = "文件服务")
public class MyFile {

    private String filePath = "G:\\";

    @PostMapping("/upload")
    @ApiOperation(value="单文件上传")
    public String upload(@RequestParam("file") MultipartFile file) {
        if(file.isEmpty()) {
            return "文件为空";
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String uuidName = UUID.randomUUID() + suffixName;
        File dest  = new File(filePath + uuidName);

        try {
            file.transferTo(dest);
            log.info("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @PostMapping("/multiUpload")
    @ApiOperation(value="多文件上传")
    @ResponseBody
    public String multiUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        for(int i = 0;i<files.size();i++) {
            MultipartFile file = files.get(i);
            if(file.isEmpty()) {
                return "第" + (i++) + "个文件为空";
            }
            String fileName = file.getOriginalFilename();
            File dest  = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                log.info("上传成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "{code: 1, msg: \"123\"}";
    }

    @GetMapping("/download")
    @ApiOperation(value="文件下载")
    public ResultInfo downloadFile(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        ResultInfo resultInfo = new ResultInfo();
        File file = new File(filePath + fileName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
//            response.setContentType("application/force-download");
            response.addHeader("Content-disposition", "attachment;fileName=" + fileName);
            OutputStream outputStream = response.getOutputStream();

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            fileInputStream.close();
            resultInfo.setResultCode(ResultCode.SUCCESS);
            resultInfo.setData("success");
            return resultInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultInfo.setResultCode(ResultCode.FILE_ERROR);
        return resultInfo;
    }

}
