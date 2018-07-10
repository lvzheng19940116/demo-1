package ad.controller;

import com.alibaba.fastjson.JSON;
import ad.bean.UserInfo;
import ad.service.MybatisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc: mybatis示例用法
 * @Author: ZhangYue
 * @Date: create in 2018/1/15
 * @copyright Navi WeCloud
 */
@RestController
@RequestMapping("mybatis/")
public class MybatisController {

    @Autowired
    private MybatisService mybatisService;

    /**
     * 添加用户信息
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("add")
    public String add(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserInfo test = new UserInfo();
        test.setUsername(username);
        test.setPassword(password);
        mybatisService.add(test);
        return "ok";
    }

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    @RequestMapping("queryById")
    public String queryById(@RequestParam("id") Integer id) {
        UserInfo test = mybatisService.queryById(id);
        return JSON.toJSONString(test);
    }

    /**
     * 更新用户信息
     * @return
     */
    @RequestMapping(value = "update")
    public String update(@RequestBody UserInfo test) {
        mybatisService.update(test);
        return "ok";
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer id) {
        mybatisService.delete(id);
        return "ok";
    }


}
