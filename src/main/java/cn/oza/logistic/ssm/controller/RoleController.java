package cn.oza.logistic.ssm.controller;

import cn.oza.logistic.ssm.pojo.*;
import cn.oza.logistic.ssm.service.PermissionService;
import cn.oza.logistic.ssm.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/list")
    @RequiresPermissions("role:list")
    public String roleList() {
        return "role/list";
    }

    @ResponseBody
    @RequestMapping("/getRoles")
    @RequiresPermissions("role:list")
    public PageInfo<Role> getAdmins(String keyWord,
                                    @RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        //开始分页，这里启动并设置页码，和每页结果数量后，后续结果会自动为分页后结果
        PageHelper.startPage(pageNum, pageSize);

        RoleExample roleExample = new RoleExample();
        /**
         * StringUtils.isNotBlank 可以判断 ""/" "/null 为 false
         */
        if (StringUtils.isNotBlank(keyWord)) {
            //角色条件
            RoleExample.Criteria criteriaUserName = roleExample.createCriteria();
            criteriaUserName.andRolenameLike("%" + keyWord + "%");
        }

        List<Role> roles = roleService.selectByExample(roleExample);
        //获得分页对象
        PageInfo<Role> pageInfo = new PageInfo<>(roles);

        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("role:delete")
    public Map<String, String> delete(Long[] roleIds) {
        HashMap<String, String> map = new HashMap<>();
        if (roleIds.length == 1) {
            int res = roleService.deleteByPrimaryKey(roleIds[0]);
            if (res == 1) {
                map.put("status", "true");
                map.put("info", "删除成功！");
                return map;
            }
            map.put("status", "false");
            map.put("info", "删除失败！角色已经不存在");
            return map;
        }
        //批量删除
        int success = 0;
        int total = roleIds.length;
        for(Long roleId : roleIds) {
            success += roleService.deleteByPrimaryKey(roleId);
        }
        map.put("status", "true");
        map.put("info", "成功删除选中 " + total + " 个角色中的 " + success + " 个角色");
        return map;
    }

    @RequestMapping("/add")
    @RequiresPermissions("role:insert")
    public String addRole() {
        return "role/add";
    }

    @ResponseBody
    @RequestMapping("/getTree")
    public List<Permission> getTree(){
        ArrayList<Permission> permissions = (ArrayList<Permission>) permissionService.selectByExample(new PermissionExample());
        return permissions;
    }

    @ResponseBody
    @RequestMapping("/insert")
    @RequiresPermissions("role:insert")
    public Boolean insert(Role role){
        int res = roleService.insert(role);
        if (res == 1)
            return true;
        return false;
    }

    @ResponseBody
    @RequestMapping("/checkRole")
    @RequiresPermissions("role:list")
    public Boolean checkRole(String name, String curName) {
        if (curName != null && name.equals(curName)) {
            return true;
        }
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRolenameEqualTo(name);
        if (roleService.selectByExample(roleExample).size() != 0) {
            return false;
        }
        return true;
    }

    @RequestMapping("/edit")
    @RequiresPermissions("role:update")
    public String edit(Model m, Long roleId) {
        m.addAttribute("role", roleService.selectByPrimaryKey(roleId));
        return "role/edit";
    }

    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("role:update")
    public Boolean update(Role role) {
        int res = roleService.updateByPrimaryKeySelective(role);
        if (res == 1) {
            return true;
        }
        return false;
    }
}
