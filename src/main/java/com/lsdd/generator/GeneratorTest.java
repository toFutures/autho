package com.lsdd.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GeneratorTest {
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        InputStream is= GeneratorTest.class.getClassLoader().getResource("generatorConfig.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("生成代码成功，刷新项目，查看文件,然后执行TestMybatis.java");

    }
    /*public void testGenerator() throws  IOException,XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings=new ArrayList<String>();
        boolean overWriter=true;
        //指向配置文件　　
        File configFile=new File(GeneratorTest.class.getResource("classPath:setting/generatorConfig.xml").getFile());
        ConfigurationParser cp=new ConfigurationParser(warnings);
        Configuration config=cp.parseConfiguration(configFile);
        DefaultShellCallback callback=new DefaultShellCallback(overWriter);
        MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args)throws Exception {
        GeneratorTest generatorTest=new GeneratorTest();
        generatorTest.testGenerator();
    }*/
}
