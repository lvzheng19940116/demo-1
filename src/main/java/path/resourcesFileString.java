package path;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author LvZheng
 * 创建时间：2021/3/4 下午6:29
 */
@Slf4j
public class resourcesFileString {


    public void pdf(HttpServletResponse response) {

        File file = null;
        String content = "";
        try {

            //获取文件生成字符串
            ClassPathResource classPathResource = new ClassPathResource("templates/test.html");
            InputStream inputStream = classPathResource.getInputStream();
            String dd = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

            //牛逼工具类
            //todo  FileUtils ResourceUtils IOUtils

            //获取resources下文件
            file = ResourceUtils.getFile("classpath:templates/test.html");
            //文件转字符串
            content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("{}", content);

        Map<String, Object> data = Maps.newHashMap();
        List<Map<String, String>> list = Lists.newArrayList();

        Map<String, String> map = Maps.newHashMap();
        map.put("name", "威士忌");
        map.put("quantity", "1314");

        Map<String, String> map1 = Maps.newHashMap();
        map1.put("name", "伏特加");
        map1.put("quantity", "521");

        list.add(map);
        list.add(map1);

        data.put("list", list);
        data.put("place", "通化");

        log.info("map:{}", JSON.toJSONString(data));

        String s = HtmlUtil.mygetHtmlString(content, data);
        log.info("{}", s);
        try {
            response.getOutputStream().write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
