package web.entity;

import java.io.Serializable;

/**
 * @author : dafeng.guo
 * @date : 12:21 2021/3/7
 **/

public class Student implements Serializable {
    private String id;
    private String name;

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
}
