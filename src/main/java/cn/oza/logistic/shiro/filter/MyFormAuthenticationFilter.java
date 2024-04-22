package cn.oza.logistic.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 重写此方法用于解决已登录，再次手动进入登陆界面登录的问题
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //判断是否是登录请求
        if (isLoginRequest(request, response)) {
            //判断是否是登录提交状态
            if (isLoginSubmission(request, response)){
                //获取当前 subject
                Subject subject = this.getSubject(request,response);
                //如果当前subject有principal，则logout
                if (subject.getPrincipal() != null) {
                    subject.logout();
                }
            }
        }

        return super.isAccessAllowed(request, response, mappedValue);
    }
}
