package com.qatix.hello.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/oss")
public class OSSUploaderController {


    private static final String file_dir = "tmp/file_uploads/";

    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = "your_keyid";
    private static String accessKeySecret = "your_keysecret";
    private static String bucketName = "buck";

    @GetMapping("/form")
    public String listUploadedFiles(Model model) throws IOException {
        return "oss_form";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        System.out.println("Getting Started with OSS SDK for Java\n");

//        Path path = Paths.get(file_dir);
//        try {
//            if(Files.exists(path)){
//                System.out.println("file dir already exist");
//            }else{
//                System.out.println("file dir not exist,create");
//                Files.createDirectories(path);
//            }
//
//            String filename = StringUtils.cleanPath(file.getOriginalFilename());
//            Files.copy(file.getInputStream(),path.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
//
//            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//            String key = String.format("java-test/%s",filename);
//            System.out.println("oss key:" + key);
//            String localFile = file_dir + filename;
//            System.out.println("file path:" + localFile);
//            ossClient.putObject(bucketName, key, new FileInputStream(localFile));
//
//            String urlname = "http://static.qatix.com/java-test/" + filename;
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded " + file.getOriginalFilename() + " to OSS!\n" + urlname);
//
//            ossClient.shutdown();
//            return "redirect:/oss/form";
//        } catch (IOException e) {
//            redirectAttributes.addFlashAttribute("message",
//                    "You failed to uploaded " + file.getOriginalFilename() + ":" + e.toString());
//
//            return "redirect:/oss/form";
//        }

//
        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            String key = String.format("java-test/%s",filename);
            System.out.println("oss key:" + key);
            ossClient.putObject(bucketName, key, file.getInputStream());

            String urlname = "http://static.qatix.com/java-test/" + filename;
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + " to OSS!\n" + urlname);

            ossClient.shutdown();
            return "redirect:/oss/form";
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message",
                    "You failed to uploaded " + file.getOriginalFilename() + ":" + e.toString());

            return "redirect:/oss/form";
        }
    }

}
