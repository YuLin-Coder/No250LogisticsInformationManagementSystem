package cn.oza.logistic.ssm.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequiresPermissions("system:index")
    @RequestMapping(value = {"/index", ""})
    public String index() {
        return "index";
    }

    @RequestMapping("/welcome")
    @RequiresPermissions("system:index")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model m) {
        //获取认证失败的错误信息，在Shiro框架的 FormAuthenticationFilter 过滤器中共享
        //共享的属性名称  shiroLoginFailure , 通过 request 获取共享的 shiro 异常的字节码
        String shiroLoginFailure = String.valueOf(request.getAttribute("shiroLoginFailure"));

        if (UnknownAccountException.class.getName().equals(shiroLoginFailure)) {
            m.addAttribute("errorMsg", "账户不存在");
        } else if (IncorrectCredentialsException.class.getName().equals(shiroLoginFailure)) {
            m.addAttribute("errorMsg", "密码错误");
        }

        return "login";
    }

    @RequestMapping("/checkVerifyCode")
    @ResponseBody
    public Boolean checkVerifyCode(String verifyCode, HttpSession session) {
        String randCode = String.valueOf(session.getAttribute("rand"));
        if (randCode.compareToIgnoreCase(verifyCode) == 0) {
            return true;
        }
        return false;
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }
}
