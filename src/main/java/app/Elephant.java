package app;

import app.dto.Food;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Elephant implements Animal {
    private boolean hungry = true;

    @Override
    public void voice() {
        System.out.println("Uuu");
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
        return Arrays.asList(FoodType.PLANTS);
    }

    @Override
    public String toString() {
        return "Elephant";
    }
}
