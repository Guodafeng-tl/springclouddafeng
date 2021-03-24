package web.dao;

import java.util.List;

/**
 * @author : dafeng.guo
 * @date : 16:17 2021/2/24
 **/
public class Student {
    private String id;
    private String name;
    private int age;
    private String test;
    private List<Teacher> list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public List<Teacher> getList() {
        return list;
    }

    public void setList(List<Teacher> list) {
        this.list = list;
    }
}
