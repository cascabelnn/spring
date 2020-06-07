package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Zoo {
    private Animal dog;
    private Animal cat;


    private Animal fish;
    private Animal elephant;
    private final List<Animal> animals;

    @Autowired
    public Zoo(Animal dog, Animal cat, Animal elephant, Animal fish, List<Animal> animals) {
        this.dog = dog;
        this.cat = cat;
        this.fish = fish;
        this.elephant = elephant;
        this.animals = animals;
    }

    public Animal getDog() {
        return dog;
    }

    public Animal getCat() {
        return cat;
    }

    public Animal getFish() {
        return fish;
    }

    public Animal getElephant() {
        return elephant;
    }

    public void setDog(Animal dog) {
        this.dog = dog;
    }

    public void setCat(Animal cat) {
        this.cat = cat;
    }

    public void setFish(Animal fish) {
        this.fish = fish;
    }

    public void setElephant(Animal elephant) {
        this.elephant = elephant;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
