package web.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author : dafeng.guo
 * @date : 14:08 2021/1/18
 **/
@Component
@Data
@Document(collection = "testConlllection")
public class testConlllection {

    private String id;
    private String color;
    private String description;
}
