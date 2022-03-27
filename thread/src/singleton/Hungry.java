package singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-27
 * Time: 9:39
 */

/**
 * 实现单例模式 饿汉模式
 * @author SweiPC
 */
public class Hungry {
    /**
     * instance 对应唯一实例 调用时立即创建
     */
    private static Hungry instance = new Hungry();

    /**
     * 为了防止被 new 对象 设为私有
     */
    private Hungry() {
    }

    /**
     * 返回这个唯一实例
     * @return
     */
    public static Hungry getInstance() {
        return instance;
    }
}
