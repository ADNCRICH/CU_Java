package gui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Top_Topic extends HBox {
	private Label label = new Label();
	private TextField text = new TextField("");
	
	public Top_Topic() {
		label.setText("Topic : ");
		text.setPrefWidth(200);
		
		this.getChildren().addAll(label,text);
	}
	
	public String getText() {
		return text.getText();
	}
}
