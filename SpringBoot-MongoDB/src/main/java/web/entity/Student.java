package web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : dafeng.guo
 * @date : 10:34 2021/1/5
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String  id;
    private String name;
    private int age;
}
