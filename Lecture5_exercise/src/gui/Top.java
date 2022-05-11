package gui;

import javafx.scene.layout.VBox;

public class Top extends VBox {
	Top_Topic topic = new Top_Topic();
	Top_Date date = new Top_Date();
	
	public Top() {
		this.setSpacing(3);
		this.getChildren().addAll(topic,date);
	}
	public Top_Topic getTopic() {
		return topic;
	}
	public Top_Date getDate() {
		return date;
	}
}
