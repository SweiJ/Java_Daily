package com.swei.music.controller;

import com.swei.music.model.Music;
import com.swei.music.service.MusicService;
import com.swei.music.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-09
 * Time: 9:40
 */
@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    /**
     * 上传音乐
     * @param singer
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    public Res<Boolean> insetMusic(@RequestParam String singer,
                                   @RequestParam("filename") MultipartFile file,
                                   HttpServletRequest request) {

        return musicService.insetMusic(singer, file, request);
    }

    /**
     * 播放音乐
     * @param title
     * @return
     */
    @RequestMapping("/get")
    public ResponseEntity<byte[]> get(String title) {
        return musicService.get(title);
    }

    /**
     * 删除音乐
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public Res<Boolean> delMusicById(Integer id, HttpServletRequest request) {
        return musicService.delMusicById(id, request);
    }

    @RequestMapping("/getmusic")
    public Res<List<Music>> getMusic(@RequestParam(required = false) String musicName) {
        return musicService.getMusic(musicName);
    }
}
