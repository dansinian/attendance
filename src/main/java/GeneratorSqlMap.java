import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlMap {
    public static void main(String[] args){
        try {
            //找到配置文件
            File file = new File("./src/main/resources/generatorConfig.xml");
            List<String> warnings = new ArrayList<String>();
            //读取配置文件 需要一个翻译官
            ConfigurationParser configurationParser = new ConfigurationParser(warnings);
//            warnings作用是控制控制台输出警告
            //读取
            Configuration configuration = configurationParser.parseConfiguration(file);
            //如果有文件了 是否覆盖
            boolean overwrite = true;
            //翻译工程目录结构 处理重复文件
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            //构造器
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
            //构造开始
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
