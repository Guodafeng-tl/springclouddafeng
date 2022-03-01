package web.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : dafeng.guo
 * @date : 13:07 2021/9/4
 **/
@Data
public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    private String type;
    public Apple(Integer id, String name, BigDecimal money, Integer num,String type) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
        this.type = type;
    }
}
