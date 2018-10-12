//package io.lenovo.localsales.contract.filter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//
///**
//*以动手实践为荣,以只看不练为耻.
//*以打印日志为荣,以出错不报为耻.
//*以局部变量为荣,以全局变量为耻.
//*以单元测试为荣,以手工测试为耻.
//*以代码重用为荣,以复制粘贴为耻.
//*以多态应用为荣,以分支判断为耻.
//*以定义常量为荣,以魔法数字为耻.
//*以总结思考为荣,以不求甚解为耻.
//*
//* @author LvZheng
//* 创建时间：2018年6月20日 下午6:17:09
//*/
//@Component
//public class CharlesRequestInterceptor implements RequestInterceptor {
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void apply(RequestTemplate template) {
//        // feign 不支持 GET 方法传 POJO, json body转query
//        if (template.method().equals("GET") && template.body() != null) {
//            try {
//                JsonNode jsonNode = objectMapper.readTree(template.body());
//                template.body(null);
//
//                Map<String, Collection<String>> queries = new HashMap<>();
//                buildQuery(jsonNode, "", queries);
//                template.queries(queries);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void buildQuery(JsonNode jsonNode, String http, Map<String, Collection<String>> queries) {
//        if (!jsonNode.isContainerNode()) {   // 叶子节点
//            if (jsonNode.isNull()) {
//                return;
//            }
//            Collection<String> values = queries.get(http);
//            if (null == values) {
//                values = new ArrayList<>();
//                queries.put(http, values);
//            }
//            values.add(jsonNode.asText());
//            return;
//        }
//        if (jsonNode.isArray()) {   // 数组节点
//            Iterator<JsonNode> it = jsonNode.elements();
//            while (it.hasNext()) {
//                buildQuery(it.next(), http, queries);
//            }
//        } else {
//            Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
//            while (it.hasNext()) {
//                Map.Entry<String, JsonNode> entry = it.next();
//                if (StringUtils.hasText(http)) {
//                    buildQuery(entry.getValue(), http + "." + entry.getKey(), queries);
//                } else {  // 根节点
//                    buildQuery(entry.getValue(), entry.getKey(), queries);
//                }
//            }
//        }
//    }
//}
//
