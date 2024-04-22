package cn.oza.logistic.ssm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = -2216376969256287108L;

    private Long userId;

    private String username;

    private String realname;

    private String password;

    private String salt;

    private Integer status;

    //该注解可以让 Date 对象格式化成对应的时间格式，而不是返回时间戳
    @JsonFormat(pattern = "YYYY-MM-dd",timezone = "GMT+8")
    private Date createDate;

    private Long roleId;

    private Role role;

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public User(Long userId, String username, String realname, String password, String salt, Integer status, Date createDate, Long roleId) {
        this.userId = userId;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.salt = salt;
        this.status = status;
        this.createDate = createDate;
        this.roleId = roleId;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", roleId=" + roleId +
                ", role=" + role +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}