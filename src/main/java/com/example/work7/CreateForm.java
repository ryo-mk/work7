package com.example.work7;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateForm {
    @NotBlank
    @Size(max = 20)
    private String name;
    
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
