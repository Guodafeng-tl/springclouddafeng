package web.simpleFactoty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * @author : dafeng.guo
 * @date : 13:58 2021/4/22
 * 创建一个工厂，生成基于给定信息的实体类的对象
 **/
@Slf4j
public class ShapeFactory {
        public static Shape getShape(String shapeType) {
            if (StringUtils.isEmpty(shapeType)){
                return null;
            }
            if(shapeType.equalsIgnoreCase("CIRCLE")){
                return new Circle();
            } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
                return new Rectangle();
            } else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new Square();
            }
            return null;
        }
}
