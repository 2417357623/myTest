package com.liyan.alg.lambda;

/**
 * @ClassName Apple
 * @Description TODO
 * @Author name
 * @Date 2023/4/12
 * @Version 1.0
 **/

public class Apple {
    private String color;

    public Apple(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                '}';
    }
}

