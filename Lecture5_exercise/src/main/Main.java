package main;

import java.io.ObjectInputStream.GetField;

import gui.Bottom;
import gui.Top;
import gui.Top_Topic;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPadding(new Insets(10, 5, 10, 5));
		root.setSpacing(8);
		root.setPrefHeight(300);
		root.setPrefWidth(270);
		
		Top topp = new Top();
		TextArea textArea = new TextArea();
		Bottom bott = new Bottom(topp.getTopic(),topp.getDate(),textArea);
		
		root.getChildren().addAll(topp,textArea,bott);
		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MyNote");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
