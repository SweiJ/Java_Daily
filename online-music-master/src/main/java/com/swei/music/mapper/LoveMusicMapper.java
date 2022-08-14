package com.swei.music.mapper;

import com.swei.music.model.Music;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-09
 * Time: 15:47
 */
@Mapper
public interface LoveMusicMapper {
    /**
     * 检查是否已经收藏过该音乐
     * @param userId
     * @param musicId
     * @return
     */
    Music getLoveMusicByMusicIdAndUserId(int userId, int musicId);
    /**
     * 点赞/收藏音乐
     * @param userId
     * @param musicId
     * @return
     */
    boolean insertLoveMusic(int userId, int musicId);

    /**
     * 如果没有传入具体的歌曲名，显示当前用户收藏的所有音乐
     * @param userId
     * @return
     */
    List<Music> findLoveMusicByUserId(int userId);
    /**
     * 根据某个用户的ID和歌曲名称查询，某个用户收藏的音乐
     * @param musicName
     * @param userId
     * @return
     */
    List<Music> findLoveMusicBykeyAndUID(String musicName, int userId);

    /**
     * 删除音乐
     * @param userId
     * @param musicId
     * @return
     */
    int delLoveMusic(Integer userId, Integer musicId);

    /**
     * 根据musicid删除音乐
     * @param musicId
     * @return
     */
    int delLoveMusicByMusicId(Integer musicId);
}
