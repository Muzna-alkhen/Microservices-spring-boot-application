package com.body.photoprocessingservice.files;

import java.util.*;

public class Shapes {
    List<String> shapes = new ArrayList<>();

    public Shapes(){
        shapes.add("rounded");
        shapes.add("triangle");
        shapes.add("rectangle");
        shapes.add("inverted");
        shapes.add("hourglass");
    }

    public List<String> getShapes() {
        return shapes;
    }

    public void setShapes(List<String> shapes) {
        this.shapes = shapes;
    }
}
