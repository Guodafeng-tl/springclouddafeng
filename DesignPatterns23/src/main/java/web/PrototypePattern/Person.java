package web.PrototypePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dafeng.guo
 * @date : 15:27 2021/5/26
 **/
public class Person implements Cloneable{

    private String name;
    private List<String> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }

    protected Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

   protected Person deepClone() throws CloneNotSupportedException {
       Person clonePerson = (Person) super.clone();
       List<String> newFriends = new ArrayList<>();
       for (String friend : clonePerson.getFriends()){
           newFriends.add(friend);
       }
       clonePerson.setFriends(newFriends);
       return clonePerson;
   }
}
