package com.swei.music.controller;

import com.swei.music.model.Music;
import com.swei.music.service.LoveMusicService;
import com.swei.music.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-09
 * Time: 15:49
 */
@RestController
@RequestMapping("/lovemusic")
public class LoveMusicController {

    @Autowired
    private LoveMusicService loveMusicService;

    @RequestMapping("/likemusic")
    public Res<Boolean> likeMusic(Integer id, HttpServletRequest request) {
        return loveMusicService.likeMusic(id, request);
    }

    @RequestMapping("/findlovemusic")
    public Res<List<Music>> getLoveMusic(@RequestParam(required = false) String musicName,
                                         HttpServletRequest request) {
        return loveMusicService.getLoveMusic(musicName, request);
    }

    @RequestMapping("/deletemusic")
    public Res<Boolean> delLoveMusic(@RequestParam Integer id, HttpServletRequest request) {
        return loveMusicService.delLoveMusic(id, request);
    }
}
