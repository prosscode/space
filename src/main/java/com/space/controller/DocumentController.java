package com.space.controller;

import com.space.entity.Commodity;
import com.space.entity.DocumentInfo;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;

import com.space.service.DocumentService;
import com.space.service.PartsellSetInfoService;
import com.space.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.Document;
import java.util.*;

/**
 * @describe: 文档
 * @author: 吕涛pross
 * @date: 2019/02/21
 */

@RestController
@RequestMapping(value = "/document")
@Api(tags="文档管理")
public class DocumentController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private DocumentService documentService;

    /** 处理文件上传 支持多文件*/
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public @ResponseBody List<DocumentInfo> upload(@RequestParam("files") MultipartFile[] files
            ,@RequestParam("documentType") Integer documentType
            ,@RequestParam("refSequenceNo") Integer refSequenceNo
            , HttpServletRequest request) {
        List<DocumentInfo> documents =new ArrayList<>();
        if(files.length>0){
            for(MultipartFile file:files){
                String path="";
                //文件名称
                String fileName = file.getOriginalFilename();
                //文件类型
                String contentType = file.getContentType();
                //后缀名
                String substring =fileName.substring(fileName.lastIndexOf("."));
                String transFileName = UUID.randomUUID().toString().replaceAll("-", "")+"."+substring;
                String filePath = request.getSession().getServletContext().getRealPath("file/upload/");
                try {
                    FileUtil.uploadFile(file.getBytes(), filePath, transFileName);
                    //添加到文档库
                    DocumentInfo documentInfo=new DocumentInfo();
                    documentInfo.setDocumentId("doc"+ UUID.randomUUID().toString().replaceAll("-", ""));
                    documentInfo.setContentType(contentType);
                    documentInfo.setUrl("file/upload/"+transFileName);
                    documentInfo.setDocumentType(documentType);
                    documentInfo.setTitle(fileName);
                    documentService.add(documentInfo);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
        //返回json
        return documents;
    }

}
