package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import main.Main;
import gui.Top_Topic;

public class Bottom extends HBox {
	private Button OKK = new Button();
	private Button Clear = new Button();
	private Top_Topic topicText;
	private Top_Date date;
	private TextArea textArea;
	
	public Bottom(Top_Topic tt,Top_Date dd,TextArea aa) {
		topicText = tt;
		date = dd;
		textArea = aa;
		this.setAlignment(Pos.BOTTOM_RIGHT);
		this.setSpacing(3);
		OKK.setPrefWidth(60);
		OKK.setText("OK");
		OKK.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg) {
				OKKHandler();
			}
		});
		Clear.setPrefWidth(60);
		Clear.setText("Clear");
		this.getChildren().addAll(OKK, Clear);
	}

	private void OKKHandler() {
		Alert popAlert = new Alert(AlertType.INFORMATION);
		popAlert.setTitle("Message");
		popAlert.setHeaderText("Message");
		popAlert.setContentText("Topic : " + topicText.getText()+"\nDate : " + date.getText() + "\nDescription : " + textArea.getText());
		popAlert.show();
	}
}
