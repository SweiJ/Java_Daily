package com.swei.music.service.impl;

import com.swei.music.mapper.LoveMusicMapper;
import com.swei.music.mapper.MusicMapper;
import com.swei.music.model.Music;
import com.swei.music.model.User;
import com.swei.music.service.MusicService;
import com.swei.music.util.Constant;
import com.swei.music.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-09
 * Time: 9:53
 */
@Service
public class MusicServiceImpl implements MusicService {

    @Value("${music.local.path}")
    private String SAVE_PATH;

    @Autowired
    private MusicMapper musicMapper;

    @Autowired
    private LoveMusicMapper loveMusicMapper;

    /**
     * 插入音乐到服务器、数据库
     * @param singer
     * @param file
     * @param request
     * @return
     */
    @Override
    public Res<Boolean> insetMusic(String singer, MultipartFile file, HttpServletRequest request) {

        // 验证是否登录
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute(Constant.USERINFO_LOGIN_KEY) == null) {
            System.out.println("没有登录!");
            return new Res<>(-1, "请登录后上传", false);
        }

        User user = (User) session.getAttribute(Constant.USERINFO_LOGIN_KEY);

        // 登录成功

        // xxx.mp4
        String fileNameAndType = file.getOriginalFilename();
        System.out.println("filename: >>>>>" + fileNameAndType);

        // 截取音乐名称
        int lastIndexOf = fileNameAndType.lastIndexOf(".");
        String filename = fileNameAndType.substring(0, lastIndexOf);

        // 查询数据库中, 是否有当前音乐
        Music music = musicMapper.getMusicBySinger(singer, filename);
        if(music != null) {
            return new Res<>(0, "数据库已存在该音乐!", true);
        }

        String path = SAVE_PATH + fileNameAndType;
        File dest = new File(path);

        if(!dest.exists()) {
            dest.mkdirs();
        }

        try {
            // 上传文件到目标
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return new Res<>(-1, "服务器上传失败!", false);
        }

        // 上传文件得到数据库
        Music musicParam = new Music();

        musicParam.setUserid(user.getId());
        musicParam.setSinger(singer);

        // 格式化日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        musicParam.setTime(dateFormat.format(new Date()));

        musicParam.setTitle(filename);

        String url = "/music/get?title=" + filename;
        musicParam.setUrl(url);

        int ret = 0;
        ret = musicMapper.insertMusic(musicParam);
        if(ret == 1) {
            return new Res<>(0, "数据库上传成功!", true);
        } else {
            return new Res<>(-1, "数据库上传失败!", false);
        }
    }

    /**
     * 播放音乐
     * @param title
     * @return
     */
    @Override
    public ResponseEntity<byte[]> get(String title) {
        try {
            byte[] bytes = Files.readAllBytes(new File(SAVE_PATH + File.separator + title + ".mp3").toPath());
            return ResponseEntity.ok(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id删除音乐
     * @param id
     * @param request
     * @return
     */
    @Override
    public Res<Boolean> delMusicById(Integer id, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute(Constant.USERINFO_LOGIN_KEY) == null) {
            return new Res<>(-1, "未登录!", false);
        }

        // 查询当前音乐是否存在
        Music music = musicMapper.getMusicById(id);
        if(music == null) {
            return new Res<>(-1, "当前音乐不存在!", false);
        } else {
            // 删除数据库中的音乐
            int retDelMusic = 0;
            retDelMusic = musicMapper.delMusicById(id);
            if (retDelMusic == 1) {
                // 删除服务器中音乐
                File file = new File(SAVE_PATH + music.getTitle() + ".mp3");
                if(file.delete()) {
                    // 删除账户收藏的音乐
                    loveMusicMapper.delLoveMusicByMusicId(music.getId());

                    return new Res<>(0, "音乐删除成功!", true);
                } else {
                    return new Res<>(-1, "音乐从服务器删除失败!", false);
                }
            } else {
                return new Res<>(-1, "删除失败!", false);
            }
        }
    }

    /**
     * 查询音乐
     * @param musicName
     * @return
     */
    @Override
    public Res<List<Music>> getMusic(String musicName) {
        List<Music> musicList = null;
        if(musicName != null) {
            musicList = musicMapper.getMusicByMusicName(musicName);
        } else {
            musicList = musicMapper.getMusic();
        }


        return new Res<>(0, "查询所有的音乐", musicList);
    }
}
