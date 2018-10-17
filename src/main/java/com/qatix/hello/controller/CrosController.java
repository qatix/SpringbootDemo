package com.qatix.hello.controller;

import com.qatix.hello.entity.Supplier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cros")
public class CrosController {

    @GetMapping("/form")
    public String addForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "cros";
    }

    //开启cros的两种方法
    //方法1：在对方服务函数上开启CrossOrigin即可，如下
//    @CrossOrigin(origins = "http://localhost:8080")
//    @RequestMapping("/test2")
//    public Object testGet2(@RequestParam(value = "name",defaultValue = "world") String name){
//        return String.format("{\"name\":\"" + name +"\",\"dd:\":123}");
//    }

    //方法2：在对方服务的Application class中添加如下的bean，对全局的一些接口进行授权
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/hello/*").allowedOrigins("http://localhost:8080");
//            }
//        };
//    }

    //方法3：使用CrosFilter

}
