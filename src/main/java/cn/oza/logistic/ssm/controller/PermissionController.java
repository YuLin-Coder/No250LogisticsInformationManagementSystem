package cn.oza.logistic.ssm.controller;

import cn.oza.logistic.ssm.pojo.Permission;
import cn.oza.logistic.ssm.pojo.PermissionExample;
import cn.oza.logistic.ssm.service.PermissionService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/list")
    @RequiresPermissions("permission:list")
    public String permissionList() {
        return "permission/list";
    }

    /**
     * 该方法返回 admin 集合的 JSON 字符串，使用 PageHelper 工具进行分页
     * @param keyWord 搜索关键字
     * @param pageNum 页数，默认为 1
     * @param pageSize 每个页面用户容量，默认为 10/页
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPermissions")
    @RequiresPermissions("permission:list")
    public PageInfo<Permission> getPermissions(String keyWord,
                                               @RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "10") Integer pageSize) {
        //开始分页，这里启动并设置页码，和每页结果数量后，后续结果会自动为分页后结果
        PageHelper.startPage(pageNum, pageSize);

        PermissionExample permissionExample = new PermissionExample();

        /**
         * StringUtils.isNotBlank 可以判断 ""/" "/null 为 false
         */
        if (StringUtils.isNotBlank(keyWord)) {
            //权限名条件
            PermissionExample.Criteria criteriaName = permissionExample.createCriteria();
            criteriaName.andNameLike("%" + keyWord + "%");
        }

        List<Permission> permissions = permissionService.selectByExample(permissionExample);
        //获得分页对象
        PageInfo<Permission> pageInfo = new PageInfo<>(permissions);

        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("permission:delete")
    public Map<String, String> delete(Long[] permissionIds) {
        HashMap<String, String> map = new HashMap<>();
        if (permissionIds.length == 1) {
            int res = permissionService.deleteByPrimaryKey(permissionIds[0]);
            if (res == 1) {
                map.put("status", "true");
                map.put("info", "删除成功！");
                return map;
            }
            map.put("status", "false");
            map.put("info", "删除失败！权限已经不存在");
            return map;
        }
        //批量删除
        int success = 0;
        int total = permissionIds.length;
        for(Long permissionId : permissionIds) {
            success += permissionService.deleteByPrimaryKey(permissionId);
        }
        map.put("status", "true");
        map.put("info", "成功删除选中 " + total + " 个权限中的 " + success + " 个权限");
        return map;
    }

    @RequestMapping("/add")
    @RequiresPermissions("permission:insert")
    public String addAdmin(Model m) {
        PermissionExample permissionExample = new PermissionExample();
        List<Permission> permissions = permissionService.selectByExample(permissionExample);
        m.addAttribute("permissions", permissions);
        return "permission/add";
    }

    @ResponseBody
    @RequestMapping("/checkPermission")
    @RequiresPermissions("permission:list")
    public Boolean checkPermission(String name, String curName) {
        System.out.println(name);
        System.out.println(curName);
        if (curName != null && name.equals(curName)) {
            return true;
        }
        PermissionExample permissionExample = new PermissionExample();
        PermissionExample.Criteria criteria = permissionExample.createCriteria();
        criteria.andNameEqualTo(name);
        if (permissionService.selectByExample(permissionExample).size() != 0) {
            return false;
        }
        return true;
    }

    @ResponseBody
    @RequestMapping("/insert")
    @RequiresPermissions("permission:insert")
    public Boolean insert(Permission permission){
        int res = permissionService.insert(permission);
        if (res == 1) {
            return true;
        }
        return false;
    }

    @RequestMapping("/edit")
    @RequiresPermissions("permission:update")
    public String edit(Model m, Long permissionId) {
        m.addAttribute("myPermission", permissionService.selectByPrimaryKey(permissionId));
        m.addAttribute("permissions", permissionService.selectByExample(new PermissionExample()));
        return "permission/edit";
    }

    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("permission:update")
    public Boolean update(Permission permission) {
        int res = permissionService.updateByPrimaryKeySelective(permission);
        if (res == 1) {
            return true;
        }
        return false;
    }
}
