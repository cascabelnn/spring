package app;

import app.dto.Food;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Cat implements Animal {
    private boolean hungry = true;

    @Override
    public void voice() {
        System.out.println("Mi");
    }

    @Override
    public boolean eat(Food food) {
        hungry = false;
        return isHungry();
    }

    @Override
    public boolean isHungry() {
        return hungry;
    }

    @Override
    public List<FoodType> getPossibleFoodTypes() {
        return Arrays.asList(FoodType.FISH, FoodType.MEAT);
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
