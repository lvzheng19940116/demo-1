package path;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Map;

import static freemarker.template.Configuration.AUTO_DETECT_TAG_SYNTAX;


/**
 * @author LvZheng
 * 创建时间：2021/3/3 下午4:20
 */
public class HtmlUtil {
    public static String mygetHtmlString(String templateString, Map<String, Object> data) {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setTagSyntax(AUTO_DETECT_TAG_SYNTAX);
        cfg.setClassicCompatible(true);
        cfg.setDefaultEncoding("utf-8");
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate("myTemplate", templateString);
        cfg.setTemplateLoader(stringLoader);
        StringWriter writer = new StringWriter();
        Template template = null;
        try {
            template = cfg.getTemplate("myTemplate", "utf-8");
            template.process(data, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writer.toString();

    }
}
