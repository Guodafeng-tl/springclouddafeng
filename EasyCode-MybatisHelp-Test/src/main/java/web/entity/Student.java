package web.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author dafeng.guo
 * @since 2020-12-09 14:55:45
 */
@Data
@Builder
public class Student implements Serializable {
    private static final long serialVersionUID = -86463662954000624L;
    
    private Integer id;
    
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}