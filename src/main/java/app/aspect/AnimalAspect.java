package app.aspect;

import app.FoodType;
import app.dto.Food;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Aspect
@Component
public class AnimalAspect {

    @Pointcut("execution(* app.Animal.eat(..))")
    public void eatPoint() {}

    @Pointcut("within(app.Fish)")
    public void fishPoint() {}

    @AfterThrowing(value = "eatPoint()", throwing = "ex")
    public void eatFailed(Throwable ex) {
        System.out.println("Failed to feed the animal: " + ex.getMessage());
    }

    @Around(value = "eatPoint() && args(food)")
    public Object eatAround(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        String target = proceedingJoinPoint.getTarget().toString();
        if (LocalDateTime.now().isAfter(food.getExpirationDate())){
            return false;
        }

        System.out.println(target + " began to eat " + food.getFoodType().toString());
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println(target + " has finished eating " + food.getFoodType().toString());
            System.out.println(target + " is fed\n");
            return result;
        } catch (Throwable e) {
            System.out.println(target + " is not fed: " + e.getMessage());
            throw e;
        }
    }

    @Around(value = "eatPoint() && args(food) && fishPoint()")
    public Object validateEat(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        if (Objects.equals(food.getFoodType(), FoodType.FISH)) {
            return false;
        } else {
            return eatAround(proceedingJoinPoint, food);
        }
    }
}
