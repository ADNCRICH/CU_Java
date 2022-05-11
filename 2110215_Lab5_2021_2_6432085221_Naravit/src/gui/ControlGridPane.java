package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ControlGridPane extends VBox {
	private final String miningImageURL;
	private ControlPane controlPane;
	
	public ControlGridPane(ControlPane controlPane) {
		this.controlPane = controlPane;
		miningImageURL = "bitcoin.png";
		ImageView imageView = new ImageView(ClassLoader.getSystemResource(miningImageURL).toString());
		imageView.setFitHeight(150);
		imageView.setFitWidth(150);
		BorderPane pane = new BorderPane();
		pane.setPrefWidth(150);
		pane.setPrefHeight(200);
		pane.setCenter(imageView);
		this.getChildren().addAll(pane,this.controlPane);
		//this.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

	}

}
