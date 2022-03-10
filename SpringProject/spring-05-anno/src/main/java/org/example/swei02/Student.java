package org.example.swei02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-10
 * Time: 15:33
 */

/**
 * @Component 这个注解相当于配置文件中的bean标签 可以创建对象
 * @Component(value = "mystudent")等价于 <bean id = "mystudent" class = "org.example.Stduent" />
 * 除了Component可以创建对象还有三个其他的
 * 1) @Repository: 放在dao接口的事项类上面, 表示创建dao对象, 持久层对象 能访问数据库
 * 2) @Service: 放在业务层接口的实现类上面, 表示创建业务层对象, 业务层对象有事务的功能
 * 3) @Controller: 放在控制器类上面, 表示创建控制器对象, 属于表示层对象
 *                  控制器对象能接受请求, 把请求的处理结果显示给用户
 */
// 可以提供value
//@Component(value = "mystudent")
// 可以直接写值
@Component("mystudent")

// 默认不写 框架默认名称 类型首字母小写
//@Component
public class Student {

    /**
     * 用注解给属性赋值 分为两种方式
     * 1. 直接在属性上面赋值 这种方式不用set方法
     * 2. 在set方法上面赋值
     */
    // 也可以不到value=""  注意value的值是String类型的
//    @Value(value = "xiaojiang")
    // 通过外部配置文件读取要添加的值
    @Value("${myname}")
    private String name;
//    @Value(value = "22")
    @Value("${myage}")
    private int age;

    /**
     *  引用类型赋值 @Autowired 这个支持自动写入 支持byType, byName 默认是byType
     *  使用byName赋值 需要 @Qualifier(value = "mystudent") value是容器中bean的id值
     * @Autowired 有一个参数required为boolean类型 默认为true
     *            区别: true:  spring在创建容器 创建对象时候 会检查引用类型是否赋值成功没有赋值成功会报错
     *                  false: 如果赋值没有成功 不会报错 会将当前的引用类型赋值为null
     */
//    @Autowired
//    @Qualifier(value = "mystudent")
    /**
     * @Resource 首先会用byName赋值 找不到会用byType
     * 如果使用byName赋值 需要对name进行赋值
      */
    @Resource(name = "myschool")
//    @Resource
    private School school;

    public Student() {
        System.out.println("this code is run--");
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
