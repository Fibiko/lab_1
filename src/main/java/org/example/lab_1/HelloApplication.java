package org.example.lab_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.example.lab_1.shapes.*;

import javax.swing.text.Element;
import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BOTTOM_CENTER);

        Canvas canvas = new Canvas(600, 600);
        vBox.getChildren().add(canvas);

        Button buttonSelect = new Button("Cелектор");
        vBox.getChildren().add(buttonSelect);
        VBox.setMargin(buttonSelect, new Insets(30,20,20,30));

        Scene scene = new Scene(vBox);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setMinHeight(650);
        stage.setMinWidth(650);


        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fill();

//        Rectangle rect1 = new Rectangle(150,150,450,450);
//        rect1.draw(gc);
//        Triangle triangle1 = new Triangle(150, 150, 450, 150, 300, 450);
//        triangle1.draw(gc);
//        Ellipse ellipse = new Ellipse(300, 300, 250, 100);
//        ellipse.draw(gc);
//        Line line = new Line(200, 300, 400, 300);
//        line.draw(gc);

        // Creating image on cat.ser
        Painting cat = new Painting();

        cat.addElement(new Ellipse(300, 300, 190,190));
        cat.addElement(new Ellipse(210, 250, 50, 25));
        cat.addElement(new Ellipse(390, 250, 50, 25));
        cat.addElement(new Ellipse(210, 250, 20, 25));
        cat.addElement(new Ellipse(390, 250, 20, 25));
        cat.addElement(new Triangle(300, 375, 280, 350, 320, 350));
        cat.addElement(new Line(300, 375, 280, 400));
        cat.addElement(new Line(280, 400, 230, 385));
        cat.addElement(new Line(300, 375, 320, 400));
        cat.addElement(new Line(320, 400, 370, 385));
        cat.addElement(new Triangle(250, 117, 150, 185, 170, 10));
        cat.addElement(new Triangle(350, 117, 450, 185, 430, 10));

        cat.serialize("cat.ser");

        // Creating image on Forest.ser
        Painting forest = new Painting();

        for (int i = 0; i < 7; i++ ) {
            forest.addElement(new Rectangle(i*100+50, 450, i*100+65, 250));
            forest.addElement(new Triangle(i*100+20, 400, i*100+95, 400, i*100+57, 210));
        }
        forest.addElement(new Line(0, 450, 600, 450));
        forest.addElement(new Ellipse(450, 100, 70, 70));
        forest.addElement(new Ellipse(430, 70, 25, 15));
        forest.addElement(new Ellipse(480, 100, 15, 15));

        forest.addElement(new Ellipse(50, 450, 40,30));
        forest.addElement(new Ellipse(70, 440, 30,35));
        forest.addElement(new Ellipse(90, 460, 30,30));

        forest.addElement(new Ellipse(250, 500, 40,30));
        forest.addElement(new Ellipse(270, 490, 30,35));
        forest.addElement(new Ellipse(290, 510, 30,30));

        forest.addElement(new Ellipse(140, 530, 40,30));
        forest.addElement(new Ellipse(160, 520, 30,35));
        forest.addElement(new Ellipse(180, 540, 30,30));

        forest.addElement(new Ellipse(500, 530, 40,30));
        forest.addElement(new Ellipse(520, 520, 30,35));
        forest.addElement(new Ellipse(530, 540, 30,30));

        forest.serialize("forest.ser");

        // Open selecter on buttonSelect click
        buttonSelect.setOnAction(e ->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized", "*.ser"));

            File file = fileChooser.showOpenDialog(stage);

            // Draw selected file
            if (file != null) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                Painting catDeserialize = Painting.deserialize(file.getName());
                if (catDeserialize != null) {
                    catDeserialize.drawAll(gc);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}