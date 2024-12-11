package org.example.lab_1.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public class Ellipse implements Serializable {
    private final double x;
    private final double y;
    private final double a;
    private final double b;

    public Ellipse(double x, double y, double a, double b) {
        this.x = x;
        this.y = y;
        this.a = a; // Radius for x
        this.b = b; // Radius for Y
    }

    public void draw(GraphicsContext gc) {
        gc.beginPath();
        // From zero to 2Pi. 0.1 step
        for (double t = 0; t <= 2 * Math.PI; t += 0.1) {
            double xPos = x + a * Math.cos(t);
            double yPos = y + b * Math.sin(t);
            if (t == 0) { // First point
                gc.moveTo(xPos, yPos);
            } else {
                gc.lineTo(xPos, yPos);
            }
        }
        gc.closePath();
        gc.stroke();
    }
}
