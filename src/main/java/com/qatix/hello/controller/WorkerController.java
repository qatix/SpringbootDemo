package com.qatix.hello.controller;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.qatix.hello.core.Result;
import com.qatix.hello.core.ResultGenerator;
import com.qatix.hello.entity.Worker;
import com.qatix.hello.service.IWorkerService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
* Created by CodeGenerator on 2018/04/02.
*/
@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private IWorkerService workerService;

    @PostMapping("/add")
    public Result add(Worker worker) {
        workerService.insert(worker);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        workerService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Worker worker) {
        workerService.updateById(worker);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Worker worker = workerService.selectById(id);
        return ResultGenerator.genSuccessResult(worker);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Worker> list = workerService.selectList(new EntityWrapper<Worker>());
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/list2")
    public Result list2(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Worker> list = workerService.selectListByNameAndSalary();
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/pagelist")
    public Result pageList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        Page<Worker> listPage = workerService.selectPage(new Page<>(page,size),new EntityWrapper<>(new Worker()));
        return ResultGenerator.genSuccessResult(listPage);
    }

    @GetMapping("/like")
    public Object like(@RequestParam(value = "key",defaultValue = "张")String key){
        JSONObject result = new JSONObject();
        Worker w = new Worker();
        w.setName(key);
        result.put("result",workerService.selectList(new EntityWrapper<>(w)));
        return result;
    }

    /**
     * 7、分页 size 一页显示数量  current 当前页码
     * 方式一：http://localhost:8080/worker/page?size=1&current=1<br>
     * 方式二：http://localhost:8080/worker/pagehelper?size=1&current=1<br>
     */

    // 参数模式分页
    @GetMapping("/page")
    public Object page(Page page){
        return workerService.selectPage(page);
    }

    // ThreadLocal 模式分页
    @GetMapping("/pagehelper")
    public Object pagehelper(Page page) {
        PageHelper.setPagination(page);
        page.setRecords(workerService.selectList(null));
        page.setTotal(PageHelper.freeTotal());//获取总数并释放资源 也可以 PageHelper.getTotal()
        return page;
    }

    /**
     * 测试事物
     * 访问如下并未发现插入数据说明事物可靠！！<br>
     * <br>
     * 启动  Application 加上 @EnableTransactionManagement 注解其实可无默认貌似就开启了<br>
     * 需要事物的方法加上 @Transactional 必须的哦！！
     */
    @Transactional
    @GetMapping("/test_transactional_with_err")
    public void testTransactionalWithErr(){
        Worker w = new Worker();
        w.setName("Trans_with_err");
        w.setBaseSalary(BigDecimal.valueOf(1000));
        w.setNo("11111");
        workerService.insert(w);
        throw new RuntimeException();
    }

    @Transactional
    @GetMapping("/test_transactional_without_err")
    public Object testTransactionalWithoutErr(){
        Worker w = new Worker();
        w.setName("Trans_without_err");
        w.setBaseSalary(BigDecimal.valueOf(2000));
        w.setNo("2222");
        workerService.insert(w);
        JSONObject jo = new JSONObject();
        jo.put("worker",w);
        return jo;
    }
}
