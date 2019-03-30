package com.space.controller;

import com.space.config.DefinedConfig;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
    @Value("${file.uploadPath}")
    private String uploadPath;

    @Value("${file.downLoadPath}")
    private String downLoadPath;

    /** 处理文件上传 支持多文件*/
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public @ResponseBody List<DocumentInfo> upload(@RequestParam("multipartFile") MultipartFile[] martFile
            ,@RequestParam(value = "documentType",required =true) Integer documentType
            ,@RequestParam(value="refSequenceNo",required =false,defaultValue ="0") Integer refSequenceNo
            , HttpServletRequest request) throws Exception {
        List<DocumentInfo> documents =new ArrayList<>();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = multipartRequest.getFiles("file");
       // Map<String, MultipartFile>  ss=multipartRequest.getFileMap();
        if(files.size()>0){
            for(MultipartFile file:files){
                //文件名称
                String fileName = file.getOriginalFilename();
                //文件类型
                String contentType = file.getContentType();
                //后缀名
                String substring =fileName.substring(fileName.lastIndexOf("."));
                //文件名
                String transFileName = UUID.randomUUID().toString().replaceAll("-", "")+substring;
                String filePath =uploadPath;// config.getUploadPath();// request.getSession().getServletContext().getRealPath("file/upload/");
                FileUtil.uploadFile(file.getBytes(), filePath, transFileName);
                //添加到文档库
                String projectPath= System.getProperty("user.dir");
                DocumentInfo documentInfo=new DocumentInfo();
                documentInfo.setDocumentId("doc"+ UUID.randomUUID().toString().replaceAll("-", ""));
                documentInfo.setContentType(contentType);
                documentInfo.setUrl("file/upload/"+transFileName);
                documentInfo.setDocumentType(documentType);
                documentInfo.setTitle(fileName);
                documentInfo.setRefSequenceNo(refSequenceNo);
                documentService.add(documentInfo);
                documents.add(documentInfo);
            }
        }
        //返回json
        return documents;
    }

}
