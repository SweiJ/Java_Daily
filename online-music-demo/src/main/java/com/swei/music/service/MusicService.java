package com.swei.music.service;

import com.swei.music.model.Music;
import com.swei.music.util.Res;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-09
 * Time: 9:50
 * @author SweiPC
 */
public interface MusicService {
    /**
     * 上传音乐(歌手和文件)
     * @param singer
     * @param file
     * @param request
     * @return
     */
    Res<Boolean> insetMusic(String singer, MultipartFile file, HttpServletRequest request);

    /**
     * 播放音乐
     * @param title
     * @return
     */
    ResponseEntity<byte[]> get(String title);

    /**
     * 删除音乐
     * @param id
     * @return
     */
    Res<Boolean> delMusicById(Integer id, HttpServletRequest request);

    /**
     * 获取音乐
     * @param musicName
     * @return
     */
    Res<List<Music>> getMusic(String musicName);

}
