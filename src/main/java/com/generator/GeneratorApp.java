package com.generator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeneratorApp extends Application {
    @Override /* Override the start method in the Application class */
    public void start(Stage primaryStage) {
        GeneratorModel model = new GeneratorModel();/* creaza modelul */
        GeneratorView view = new GeneratorView();/* creaza interfata */
        GeneratorController controller = new GeneratorController(model, view);

        /* Create a scene and place it in the stage */
        Scene scena = new Scene(view, 800, 600);/* creează scena */
        primaryStage.setScene(scena);/* setează scena */
        primaryStage.setTitle("GenApp");/* set the stage title */
        primaryStage.show();/* afiseaza fereastra */
    }

    public static void main(String[] args) {
        launch(args);
    }
}
