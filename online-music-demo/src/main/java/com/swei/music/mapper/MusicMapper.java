package com.swei.music.mapper;

import com.swei.music.model.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-09
 * Time: 11:00
 */
@Mapper
public interface MusicMapper {

    /**
     * 上传音乐到数据库
     * @param music
     * @return
     */
    int insertMusic(@Param("music") Music music);

    /**
     * 根据歌手和文件名查找是否在数据库中重复
     * @param singer
     * @param title
     * @return
     */
    Music getMusicBySinger(@Param("singer") String singer, @Param("title") String title);

    /**
     * 根据id删除音乐
     * @param id
     * @return
     */
    int delMusicById(Integer id);

    /**
     * 根据id查询音乐
     * @param id
     * @return
     */
    Music getMusicById(Integer id);

    /**
     * 根据歌曲名字，查询音乐
     * @param name
     * @return
     */
    List<Music> getMusicByMusicName(@Param("musicName") String name);

    /**
     * 查询所有的音乐
     * @return
     */
    List<Music> getMusic();
}
