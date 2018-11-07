package com.zr.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成mybatis映射文件
 * @Package: com.zr.generator
 * @Class: MybatisGenerator
 * @Author: 冯前进
 * @date: 2018/11/6 16:16
 * @Description: TODO
 * @Param: param
 * @ReturnType:
 * @Exception
 **/
public class MybatisGenerator {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        InputStream is = MybatisGenerator.class.getClassLoader().getResource("generator/generatorConfig.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("生成代码成功，只能执行一次，以后执行会覆盖掉mapper,pojo,xml 等文件上做的修改");
    }
}
