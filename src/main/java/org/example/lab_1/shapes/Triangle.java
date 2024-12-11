package org.example.lab_1.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public class Triangle implements Serializable {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1,double x2, double y2,double x3, double y3){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public void draw(GraphicsContext gc) {
        gc.beginPath();
        gc.moveTo(x1, y1);
        gc.lineTo(x2, y2);
        gc.lineTo(x3, y3);
        gc.closePath();
        gc.stroke();
    }
}
