package web.PrototypePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dafeng.guo
 * @date : 15:29 2021/5/26
 **/

public class PrototypeMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person personA= new Person();
        List<String> friends = new ArrayList<>();
        friends.add("大红");
        friends.add("大黄");
        personA.setName("www");;
        personA.setFriends(friends);
        System.out.println("未向friends加新元素前personA的值为："+personA.toString());
        Person shallowClonePerson = personA.shallowClone();
        System.out.println("未向friends加新元素前shallowClonePerson的值为："+shallowClonePerson.toString());
        //向personA中加元素
        friends.add("PersonA1");
        //向personA中加元素
        shallowClonePerson.getFriends().add("shallowClonePerson1");
        System.out.println("浅拷贝后 friends中添加新元素后shallowClonePerson的值为："+shallowClonePerson.toString());
        System.out.println("浅拷贝后 friends中添加新元素后personA的值为："+personA.toString());

        Person deepClonePerson = personA.deepClone();
        //向personA中加元素
        friends.add("PersonA2");
        //向personA中加元素
        deepClonePerson.getFriends().add("deepClonePerson2");
        System.out.println("深拷贝后 friends中添加新元素后deepClonePerson的值为："+deepClonePerson.toString());
        System.out.println("深拷贝后 friends中添加新元素后personA的值为："+personA.toString());
    }
}
