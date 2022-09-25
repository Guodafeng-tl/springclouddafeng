package web.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2020-12-17 14:03:41
 */
@Data
public class Teacher implements Serializable {
    private static final long serialVersionUID = 489916060062539940L;
    
    private Integer id;
    
    private Integer age;
    
    private String name;

    private BigDecimal percent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}