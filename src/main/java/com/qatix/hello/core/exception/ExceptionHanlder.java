package com.qatix.hello.core.exception;

import com.qatix.hello.core.CommonConstant;
import com.qatix.hello.core.CommonConstant;
import com.qatix.hello.core.RetEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("exceptionHandler")
public class ExceptionHanlder extends DefaultHandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHanlder.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response,
                                              Object handler,
                                              Exception ex) {
        logger.error("handle error:", ex);

        RetEntity retEntity = new RetEntity();
        retEntity.setCode(CommonConstant.RESULT_CODE_EXPECTATION_FAILED);
        retEntity.setMessage(ex.toString());

        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject(retEntity);
        return model;

        //以下方式不行
//        try {
//            response.reset();
//            response.setCharacterEncoding("UTF-8");
//            response.setHeader("Content-type", "application/json;charset=UTF-8");
//            PrintWriter writer = response.getWriter();
//            writer.print(retEntity);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            logger.error("write response error", e);
//        }
//        return null;
    }
}
