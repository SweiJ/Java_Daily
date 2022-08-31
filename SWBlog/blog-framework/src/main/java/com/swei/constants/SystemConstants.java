package com.swei.constants;

import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-24 16:01
 */
public class SystemConstants {

    /**
     * 文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     * 文章是正常发布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 文章评论类型
     */
    public static final String ARTICLE_COMMENT_TYPE = "0";

    /**
     * 友联评论类型
     */
    public static final String LINK_COMMENT_TYPE = "1";

    /**
     * 友联正常状态
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 友联未审核
     */
    public static final String LINK_STATUS_NOT_REVIEW = "2";

    /**
     * 友联已审核
     */
    public static final String LINK_STATUS_REVIEW = "1";

    /**
     * redis中文章浏览量的键值
     */
    public static final String ARTICLEVIEWCOUNT = "article:viewCount";

    /**
     * redis中博客登录的键值
     */
    public static final String BLOGLOGIN = "bloglogin:";

    /**
     * redis中后台登录的键值
     */
    public static final String ADMINLOGIN = "adminlogin:";

    /**
     * 获取请求头字段
     */
    public static final String TOKEN = "token";

    /**
     * 菜单
     */
    public static final String MENU = "C";

    /**
     * 按钮
     */
    public static final String BUTTON = "F";

    /**
     * 删除标记 未删除
     */
    public static final int NOT_DEL_FLAG = 0;

    /**
     * 删除标记 已删除
     */
    public static final int IS_DEL_FLAG = 1;

    /**
     * 角色id
     */
    public static final String ROLE_ID_TYPE = "2";

    /**
     * 用户类型 普通
     */
    public static final String USER_COMMON_TYPE = "0";

    /**
     * 用户类型 管理员
     */
    public static final String USER_ADMIN_TYPE = "1";

}
