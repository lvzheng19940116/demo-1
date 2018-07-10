package ad.service;

import ad.bean.UserInfo;
import ad.mapper.UserInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc: mybatis示例Service
 * @Author: ZhangYue
 * @Date: create in 2018/1/15
 * @copyright Navi WeCloud
 */
@Service
public class MybatisService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public void add(UserInfo test) {
        userInfoMapper.insert(test);
    }

    public UserInfo queryById(int id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }


    public void update(UserInfo test) {
        userInfoMapper.updateByPrimaryKeySelective(test);
    }

    public void delete(Integer id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }
}
