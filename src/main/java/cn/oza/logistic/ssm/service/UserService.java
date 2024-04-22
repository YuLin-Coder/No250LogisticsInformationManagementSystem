package cn.oza.logistic.ssm.service;



import cn.oza.logistic.ssm.pojo.User;
import cn.oza.logistic.ssm.pojo.UserExample;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
