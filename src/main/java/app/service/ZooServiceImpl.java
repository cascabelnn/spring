package app.service;

import app.Animal;
import app.Zoo;
import app.dto.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZooServiceImpl implements ZooService{
    private final Zoo zoo;

    @Autowired
    public ZooServiceImpl(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public void feed(Food food) {
        List<Animal> hungryAnimals = zoo.getAnimals()
                .stream()
                .peek(animal -> animal.eat(food))
                .filter(Animal::isHungry)
                .collect(Collectors.toList());
        System.out.println(hungryAnimals);
    }
}
