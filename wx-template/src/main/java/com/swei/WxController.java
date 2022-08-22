package com.swei;

import org.springframework.web.bind.annotation.RestController;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import org.springframework.web.bind.annotation.GetMapping;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-22 18:24
 */
@RestController
public class WxController {

    /*
     * 登陆公众平台测试账号系统   测试公众号消息推送接口
     */
    @GetMapping("/push")
    public void push() {
        //配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("");
        wxStorage.setSecret("");
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        //推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("")//要推送的用户openid
                .templateId("")//模版id
                .url("")//点击模版消息要访问的网址
                .build();
        //如果是正式版发送模版消息，类似上图序号2模板，需要配置你的模板数据 上图中序号1模板不用配置
        templateMessage.addData(new WxMpTemplateData("DAY", "21", "#FF00FF"));
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }

    }
}
