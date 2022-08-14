package com.swei.music.service.impl;

import com.swei.music.mapper.LoveMusicMapper;
import com.swei.music.model.Music;
import com.swei.music.model.User;
import com.swei.music.service.LoveMusicService;
import com.swei.music.util.Constant;
import com.swei.music.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-09
 * Time: 15:52
 */
@Service
public class LoveMusicServiceImpl implements LoveMusicService {

    @Autowired
    private LoveMusicMapper loveMusicMapper;

    /**
     * 收藏音乐
     * @param id
     * @param request
     * @return
     */
    @Override
    public Res<Boolean> likeMusic(Integer id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute(Constant.USERINFO_LOGIN_KEY) == null) {
            return new Res<>(-1, "未登录!", false);
        }

        User user = (User) session.getAttribute(Constant.USERINFO_LOGIN_KEY);
        int userid = user.getId();

        Music music = loveMusicMapper.getLoveMusicByMusicIdAndUserId(userid, id);
        if(music != null) {
            return new Res<>(-1, "该用户收藏过该音乐!", false);
        } else {
            if (loveMusicMapper.insertLoveMusic(userid, id)) {
                return new Res<>(0, "点赞音乐成功", true);
            } else {
                return new Res<>(-1, "点赞音乐失败", false);
            }
        }
    }

    @Override
    public Res<List<Music>> getLoveMusic(String musicName, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute(Constant.USERINFO_LOGIN_KEY) == null) {
            return new Res<>(-1, "未登录!", null);
        }

        User user = (User) session.getAttribute(Constant.USERINFO_LOGIN_KEY);
        int userid = user.getId();

        List<Music> musics = new ArrayList<>();
        if(musicName != null) {
            musics = loveMusicMapper.findLoveMusicBykeyAndUID(musicName,userid);
        }else {
            musics = loveMusicMapper.findLoveMusicByUserId(userid);
        }
        return new Res<>(0,"查询到了所有的收藏的音乐",musics);
    }

    @Override
    public Res<Boolean> delLoveMusic(Integer id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute(Constant.USERINFO_LOGIN_KEY) == null) {
            return new Res<>(-1, "未登录!", null);
        }

        User user = (User) session.getAttribute(Constant.USERINFO_LOGIN_KEY);
        int userid = user.getId();

        int ret = loveMusicMapper.delLoveMusic(userid, id);
        if(ret == 1) {
            return new Res<>(0, "取消收藏成功!", true);
        } else {
            return new Res<>(-1, "取消收藏失败!", false);
        }
    }
}
