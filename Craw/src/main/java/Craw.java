
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 引入jsoup-1.11.3.jar
 * @author : 谭老师
 * @description: TODO
 */
public class Craw {

    public static void main(String[] args) throws Exception {
        getVideo(1);
    }

    public static void getVideo(int page) throws Exception {
        //1.创建一个链接才能对网页进行请求url    请求--》响应
        //http请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2,发送请求 get post
//        HttpGet httpGet = new HttpGet("https://ibaotu.com/shipin/7-0-0-0-0-" + page + ".html");
        HttpGet httpGet = new HttpGet("https://www.bangongziyuan.com/word/cat1-36-stu-0.html");
        //3,网址响应 200  404  500
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        //4,获取响应结果
        HttpEntity httpEntity = httpResponse.getEntity();
        //5,将响应的结果变成字符串
        String content = EntityUtils.toString(httpEntity, "UTF-8");
        //System.out.println(content);
        //6,解析HTML
        Document document = Jsoup.parse(content);
        //7,选择要爬取的内容
//        Elements elements = document.select("div.media-list div.video-play video");
        Elements elements = document.select("div.ppt-model div.model-cover a.model-back");
        //System.out.println(elements);
        //8,获取src的值



        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);

            String attr = element.attr("src");
            //System.out.println(attr);//获取资源的url //video-qn.ibaotu.com/19/50/18/78Q888piCskV.mp4_10s.mp4
            //9, 将https拼接到资源url
            CloseableHttpResponse httpResponse2 = httpClient.execute(new HttpGet("https:" + attr));
            //获取响应实体
            HttpEntity httpEntity2 = httpResponse2.getEntity();

            //获取mp4内容, 为流
            InputStream stream = httpEntity2.getContent();

            //将流转换成视频文件,保存到在E:/video/目录
            FileUtils.copyToFile(stream, new File("C:/Users/SweiPC/Desktop/craw/" + page + "_" + i + ".pdf"));

            //关闭流
            stream.close();
        }
    }


    //将爬取的数据流, 保存为本地文件
    public static void downloadPic(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        //需要创建一个byte数组b, 用来临时存放读取到的数据
        byte[] tmpBytes = new byte[1024];
        //获取从输入流读取到的字节数，每次读1024字节个数, 并将它们存储到缓冲区tmpBytes
        //read但最后inputStream被read 读完后, 为-1
        //count 指的是读取的有效字节个数
        int count = inputStream.read(tmpBytes);
        //判断inputStream流有没有读完, -1表示被读完了
        while (count != -1) {
            //将从inputStream读取的流, 存放到数组tmpBytes
            fileOutputStream.write(tmpBytes, 0, count);
            //清空缓冲区数据, 数据是先被读到了内存中，然后用数据写到文件中
            //这个方法的作用是把缓冲区的数据强行输出
            fileOutputStream.flush();
            //继续往下读1024, 看还有没有字节, 没有返回-1, 跳出while
            count = inputStream.read(tmpBytes);
        }
        //水龙头关闭
        fileOutputStream.close();
        inputStream.close();

    }
}
