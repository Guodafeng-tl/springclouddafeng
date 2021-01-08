package web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : dafeng.guo
 * @date : 10:39 2021/1/4
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    String id;
    String name;
}
