package org.example.lab_1.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Painting implements Serializable {
    private List<Object> shapes;

    public Painting() {
        this.shapes = new ArrayList<>();
    }

    public void addElement(Object shape){
        shapes.add(shape);
    }

    // Serialization
    public void serialize(String name) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(name))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Painting deserialize(String name) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name))) {
            return (Painting) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void drawAll(GraphicsContext gc) {
        for (Object shape : shapes) {
            if (shape instanceof Rectangle) {
                ((Rectangle) shape).draw(gc);
            }
            else if (shape instanceof Triangle) {
                ((Triangle) shape).draw(gc);
            }
            else if (shape instanceof Ellipse) {
                ((Ellipse) shape).draw(gc);
            }
            else if (shape instanceof Line) {
                ((Line) shape).draw(gc);
            }
        }
    }
}
