package cn.oza.logistic.ssm.controller;

import cn.oza.logistic.ssm.pojo.Role;
import cn.oza.logistic.ssm.pojo.RoleExample;
import cn.oza.logistic.ssm.pojo.User;
import cn.oza.logistic.ssm.pojo.UserExample;
import cn.oza.logistic.ssm.service.RoleService;
import cn.oza.logistic.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    @RequiresPermissions("admin:list")
    public String adminList() {
        return "admin/list";
    }

    /**
     * 该方法返回 admin 集合的 JSON 字符串，使用 PageHelper 工具进行分页
     * @param keyWord 搜索关键字
     * @param pageNum 页数，默认为 1
     * @param pageSize 每个页面用户容量，默认为 10/页
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAdmins")
    @RequiresPermissions("admin:list")
    public PageInfo<User> getAdmins(String keyWord,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
        //开始分页，这里启动并设置页码，和每页结果数量后，后续结果会自动为分页后结果
        PageHelper.startPage(pageNum, pageSize);

        UserExample userExample = new UserExample();

        /**
         * StringUtils.isNotBlank 可以判断 ""/" "/null 为 false
         */
        if (StringUtils.isNotBlank(keyWord)) {
            //用户名条件
            UserExample.Criteria criteriaUserName = userExample.createCriteria();
            criteriaUserName.andUsernameLike("%" + keyWord + "%");

            //真实名字条件
            UserExample.Criteria criteriaRealName = userExample.createCriteria();
            criteriaRealName.andRealnameLike("%" + keyWord + "%");

            //将两个条件用 or 组合
            userExample.or(criteriaRealName);
        }

        List<User> users = userService.selectByExample(userExample);
        //获得分页对象
        PageInfo<User> pageInfo = new PageInfo<>(users);

        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("admin:delete")
    public Map<String, String> delete(Long[] userIds) {
        HashMap<String, String> map = new HashMap<>();
        if (userIds.length == 1) {
            int res = userService.deleteByPrimaryKey(userIds[0]);
            if (res == 1) {
                map.put("status", "true");
                map.put("info", "删除成功！");
                return map;
            }
            map.put("status", "false");
            map.put("info", "删除失败！用户已经不存在");
            return map;
        }
        //批量删除
        int success = 0;
        int total = userIds.length;
        for(Long userId : userIds) {
            success += userService.deleteByPrimaryKey(userId);
        }
        map.put("status", "true");
        map.put("info", "成功删除选中 " + total + " 个用户中的 " + success + " 个用户");
        return map;
    }

    @RequiresPermissions("admin:insert")
    @RequestMapping("/add")
    public String addAdmin(Model m) {
        RoleExample roleExample = new RoleExample();
        List<Role> roles = roleService.selectByExample(roleExample);
        m.addAttribute("roles", roles);
        return "admin/add";
    }

    @ResponseBody
    @RequestMapping("/checkUsername")
    @RequiresPermissions("admin:list")
    public Boolean checkUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        System.out.println(userService.selectByExample(userExample));
        if (userService.selectByExample(userExample).size() != 0) {
            return false;
        }
        return true;
    }

    @ResponseBody
    @RequestMapping("/insert")
    @RequiresPermissions("admin:insert")
    public Boolean insert(User user){
        String salt = UUID.randomUUID().toString().substring(0, 4);
        String hashedPassword = new SimpleHash("md5", user.getPassword(), salt,3).toString();
        user.setSalt(salt);
        user.setPassword(hashedPassword);
        user.setCreateDate(new Date());
        int res = userService.insert(user);
        if (res == 1) {
            return true;
        }
        return false;
    }

    @RequestMapping("/edit")
    @RequiresPermissions("admin:update")
    public String edit(Model m, Long userId) {
        m.addAttribute("user", userService.selectByPrimaryKey(userId));
        m.addAttribute("roles", roleService.selectByExample(new RoleExample()));
        return "admin/edit";
    }

    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("admin:update")
    public Boolean update(User user) {
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword(null);
        } else {
            String salt = UUID.randomUUID().toString().substring(0, 4);
            String hashedPassword = new SimpleHash("md5", user.getPassword(), salt, 3).toString();
            user.setPassword(hashedPassword);
            user.setSalt(salt);
        }
        int res = userService.updateByPrimaryKeySelective(user);
        if (res == 1) {
            return true;
        }
        return false;
    }
}

