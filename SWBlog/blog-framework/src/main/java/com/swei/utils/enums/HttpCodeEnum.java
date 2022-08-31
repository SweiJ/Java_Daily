package com.swei.utils.enums;

/**
 * Created with IntelliJ IDEA.
 * Description: 返回值枚举类
 *
 * @author: SweiPC
 * @data: 2022-08-24 13:35
 */
public enum HttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"), EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    LOGIN_ERROR(505,"用户名或密码错误"),
    COMMENT_NOT_NULL(506,"评论信息不为空"),
    FILE_TYPE_ERROR(507, "文件类型错误, 请上传png文件"),
    USERNAME_NOT_NULL(508, "用户名不能为空!"),
    PASSWORD_NOT_NULL(509, "密码不能为空!"),
    EMAIL_NOT_NULL(510, "邮箱不能为空!"),
    NICKNAME_NOT_NULL(511, "昵称不能为空!"),
    NICKNAME_EXIST(512, "昵称已存在"),
    TAG_IS_NULL(513, "标签不存在"),
    LINK_IS_NULL(513, "友联不存在"),
    ARTICLE_IS_NULL(514, "文章不存在"),
    CATEGORY_IS_NULL(515, "分类不存在"),
    USER_IS_NULL(516, "用户不存在"),
    ROLE_IS_NULL(516, "角色不存在"),
    MENU_IS_NULL(517, "菜单不存在"),
    ROLE_BIND_USER(518, "删除失败, 当前角色有绑定的用户");
    int code;
    String msg;

    HttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
