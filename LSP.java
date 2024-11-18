import java.util.*;
import java.lang.*;
import java.io.*;

public interface DuckBehavior {
    void quack();
    void swim();
}
public class Duck implements DuckBehavior {
    @Override
    public void quack() {
        System.out.println("Duck is quacking!");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming!");
    }
}
public class ElectronicDuck implements DuckBehavior {
    private boolean _on;

    public void turnOn() {
        _on = true;
        System.out.println("Electronic duck is turned on.");
    }

    public void turnOff() {
        _on = false;
        System.out.println("Electronic duck is turned off.");
    }

    @Override
    public void quack() {
        if (_on) {
            System.out.println("Electronic duck is quacking!");
        } else {
            System.out.println("Electronic duck is off and cannot quack.");
        }
    }

    @Override
    public void swim() {
        if (_on) {
            System.out.println("Electronic duck is swimming!");
        } else {
            System.out.println("Electronic duck is off and cannot swim.");
        }
    }
}
public class Pool {
    public void run() {
        System.out.println("Pool is running!");
    }

    public void quack(DuckBehavior... ducks) {
        for (DuckBehavior duck : ducks) {
            duck.quack();
        }
    }

    public void swim(DuckBehavior... ducks) {
        for (DuckBehavior duck : ducks) {
            duck.swim();
        }
    }
}
