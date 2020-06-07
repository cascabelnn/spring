package app;

import app.dto.Food;

import java.util.List;

public interface Animal {
    void voice();

    boolean eat(Food food);

    boolean isHungry();

    List<FoodType> getPossibleFoodTypes();

    String toString();
}
