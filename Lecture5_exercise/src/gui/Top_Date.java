package gui;

import java.time.format.DateTimeFormatter;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Top_Date extends HBox {
	private Label label = new Label();
	private DatePicker datePicker = new DatePicker();
	
	public Top_Date() {
		label.setText("Date : ");
		datePicker.setPrefWidth(150);
		
		this.getChildren().addAll(label,datePicker);
	}
	
	public String getText() {
		return datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-dd-MM"));
	}
}