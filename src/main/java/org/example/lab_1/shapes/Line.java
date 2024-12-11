package org.example.lab_1.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public class Line implements Serializable {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public void draw (GraphicsContext gc) {
        gc.moveTo(x1,y1);
        gc.lineTo(x2, y2);
        gc.stroke();
    }
}
