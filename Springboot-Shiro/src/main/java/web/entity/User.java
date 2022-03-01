package web.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-03-23 14:53:55
 */
@Builder
@Data
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 127611527100522503L;
    
    private Integer id;
    
    private String name;
    
    private String pwd;
    
    private String role;


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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}