package ${basePackage}.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.stereotype.Service;

/**
 * Created by ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends ServiceImpl<${modelNameUpperCamel}Mapper,${modelNameUpperCamel}> implements I${modelNameUpperCamel}Service {

}
