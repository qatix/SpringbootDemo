package com.qatix.hello.controller;

import com.qatix.hello.storage.StorageFileNotFoundException;
import com.qatix.hello.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/simpleupload")
public class SimpleUploaderController {


    private static final String file_dir = "tmp/file_uploads";

    @GetMapping("/form")
    public String listUploadedFiles(Model model) throws IOException{
        return "simpleupload_form";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
        Path path = Paths.get(file_dir);
        try {
            if(Files.exists(path)){
                System.out.println("file dir already exist");
            }else{
                System.out.println("file dir not exist,create");
                Files.createDirectories(path);
            }

            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            Files.copy(file.getInputStream(),path.resolve(filename), StandardCopyOption.REPLACE_EXISTING);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");

            return "redirect:/simpleupload/form";
        }catch (IOException e){
            redirectAttributes.addFlashAttribute("message",
                    "You failed to uploaded " + file.getOriginalFilename() + ":"+e.toString());

            return "redirect:/simpleupload/form";
        }
    }

}
