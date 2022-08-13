package com.swei.music.service;

import com.swei.music.model.Music;
import com.swei.music.util.Res;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-09
 * Time: 15:50
 * @author SweiPC
 */
public interface LoveMusicService {

    /**
     * 喜欢音乐
     * @param id
     * @param request
     * @return
     */
    Res<Boolean> likeMusic(Integer id, HttpServletRequest request);

    /**
     * 获取收藏的音乐
     * @param musicName
     * @param request
     * @return
     */
    Res<List<Music>> getLoveMusic(String musicName, HttpServletRequest request);

    /**
     * 删除音乐
     * @param id
     * @param request
     * @return
     */
    Res<Boolean> delLoveMusic(Integer id, HttpServletRequest request);

}
