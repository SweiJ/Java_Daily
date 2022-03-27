package singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-27
 * Time: 9:41
 */

import java.util.IdentityHashMap;

/**
 * 实现单例模式 懒汉模式
 * @author SweiPC
 */
public class Idler {
    /**
     *  调用时不立即创建 volatile保证内存可见性
     */
    private volatile static Idler instance = null;

    /**
     *  设为私有
     */
    private Idler() {
    }

    /**
     * 当需要对象时才创建对象
     * 此时读和写会造成线程不安全问题
     * 需要加synchronized
     * @return
     */
    public static Idler getInstance() {
        if(instance == null) {
            synchronized (Idler.class) {
                if (instance == null) {
                    instance = new Idler();
                }
            }
        }
        return instance;
    }
}
