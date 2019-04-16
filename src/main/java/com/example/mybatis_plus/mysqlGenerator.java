package com.example.mybatis_plus;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author Gatsby.Luo
 * @date 2019-04-16
 */
public class mysqlGenerator extends BaseGenerator {

    public static void main(String[] args) {
        // 代码生成器
        String projectPath = System.getProperty("user.dir");
        AutoGenerator autoGenerator = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOpen(false)
                        .setOutputDir(projectPath + "/src/main/java")
                        .setAuthor("gatsby.Luo")
                        .setFileOverride(true)
                        .setSwagger2(true)
                        .setMapperName("%sMapper")
                        .setXmlName("%sDao")
                        .setIdType(IdType.AUTO)
        ).setDataSource(
                //数据源配置
                new DataSourceConfig()
                        .setUrl("jdbc:mysql://localhost:3306/jpa?" +
                                "useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC")
                        .setDriverName("com.mysql.jdbc.Driver")
                        .setUsername("root")
                        .setPassword("123456")
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        .setModuleName(scanner("模块名"))
                        .setParent("com.example.mybatis_plus")

        ).setStrategy(
                // 数据库表配置
                new StrategyConfig()
                        .setNaming(NamingStrategy.underline_to_camel)
                        .setColumnNaming(NamingStrategy.underline_to_camel)
                        .setEntityLombokModel(true)
                        // .setSuperEntityClass(BaseEntity.class)
                        .setSuperEntityClass("com.example.mybatis_plus.common.BaseEntity")
                        .setSuperControllerClass("com.example.mybatis_plus.common.BaseController")
                        .setInclude(scanner("表名"))
                        .setSuperEntityColumns("id")
                        .setControllerMappingHyphenStyle(true)
                        .setRestControllerStyle(true)
                        .setEntityTableFieldAnnotationEnable(true)
        ).setTemplateEngine(
                // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
                new FreemarkerTemplateEngine()
        ).setTemplate(
                new TemplateConfig()
                // .setEntity("com.example.mybatis_plus.common.BaseEntity")
        );

        autoGenerator.execute();
    }
}
