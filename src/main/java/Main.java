import app.FoodType;
import app.configuration.AnnotationConfiguration;
import app.dto.Food;
import app.service.ZooService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext();
        feedAnimal(context);
    }

    public static void feedAnimal(ApplicationContext context) {
        ZooService service = context.getBean(ZooService.class);
        Food food = new Food();
        food.setFoodType(FoodType.FISH);
        food.setExpirationDate(LocalDateTime.now().plusHours(6));
        service.feed(food);

    }

    public static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }
}
