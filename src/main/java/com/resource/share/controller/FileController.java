package com.resource.share.controller;


import com.resource.share.entity.Resource;
import com.resource.share.service.ResourceService;
import com.resource.share.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.path}")
    private String filePath;

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/upload")
    public Result<Resource> upload(MultipartFile file,Resource resource) throws Exception {
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + extName;
        FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(filePath + fileName)));
        resource.setRealName(fileName);
        resourceService.insertResource(resource);
        Result<Resource> result = new Result<>();
        result.setCode(200);
        result.setMsg("上传文件成功！");
        result.setData(resource);
        return result;
    }

    @GetMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response,Integer id) {
        Resource resource = resourceService.queryResourceById(id);
        String fileName = resource.getRealName();  // 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            String realPath = filePath;
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/pdf");//
                response.setHeader("content-type", "application/pdf");
                response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
