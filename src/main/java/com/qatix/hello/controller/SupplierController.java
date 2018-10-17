package com.qatix.hello.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qatix.hello.core.Result;
import com.qatix.hello.core.ResultCode;
import com.qatix.hello.core.ResultGenerator;
import com.qatix.hello.entity.Product;
import com.qatix.hello.entity.Supplier;
import com.qatix.hello.service.IProductService;
import com.qatix.hello.service.ISupplierService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/supplier")
@Controller
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier/form";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam Integer id, Model model) {
        Supplier supplier = supplierService.selectById(id);

        if (supplier != null) {
            model.addAttribute("supplier", supplier);
            return "supplier/form";
        } else {
            model.addAttribute("id", id);
            return "supplier/not_found";
        }
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id, Model model) {
        Supplier supplier = supplierService.selectById(id);
        if (supplier != null) {
            model.addAttribute("supplier", supplier);
            return "supplier/detail";
        } else {
            model.addAttribute("id", id);
            return "supplier/not_found";
        }
    }

    @PostMapping("/save")
    public String saveSubmit(@ModelAttribute Supplier supplier) {
        if (supplier.getId() != null) {
            supplierService.updateById(supplier);
        } else {
            supplierService.insert(supplier);
        }

        return "supplier/result";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Supplier supplier) {
        System.out.println("Delete supplier:" + supplier.toString());
        supplierService.deleteById(supplier.getId());
        return "redirect:/supplier/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("list suppliers");
        List<Supplier> list = supplierService.selectList(new EntityWrapper<Supplier>());
        model.addAttribute("suppliers", list);
        return "supplier/list";
    }

    //导出csv
    @GetMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        File temp = File.createTempFile("supplier-data-" + this.getCurrentDate(),".csv");

        List<Supplier> suppliers = supplierService.selectList(new EntityWrapper<>());
        StringBuffer sb = new StringBuffer();
        sb.append("ID");
        sb.append("姓名");
        sb.append("电话");
        sb.append("创建时间"+"\r\n");
        for(Supplier supplier:suppliers){
            sb.append(supplier.getId()+",");
            sb.append(supplier.getName()+",");
            sb.append(supplier.getPhone()+",");
            sb.append(supplier.getCreateTime()+"\r\n");
        }

        System.out.println("sb:\n"+sb.toString());

        FileOutputStream fos  = new FileOutputStream(temp);

        // 写入bom头
        byte[] uft8bom={(byte)0xef,(byte)0xbb,(byte)0xbf};
        fos.write(uft8bom);

        PrintWriter pw = new PrintWriter(fos);
        pw.write(sb.toString());
        pw.flush();
        pw.close();
        fos.close();

        File downloadFile = new File(temp.getAbsolutePath());
        System.out.println("temp file:"+temp.getAbsolutePath());

        String mimeType = "application/octet-stream";

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=%s",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // Copy the stream to the response's output stream.
        try {
            InputStream myStream = new FileInputStream(temp);
            IOUtils.copy(myStream, response.getOutputStream());
            myStream.close();
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            temp.delete();
        }
    }

    private String getCurrentDate(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        return fmt.format(new Date());
    }
}
