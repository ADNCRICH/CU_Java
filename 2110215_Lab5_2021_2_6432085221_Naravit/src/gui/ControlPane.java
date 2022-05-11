package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;

public class ControlPane extends VBox {
	private Text gameText;
	private Button newGameButton;
	private Button secureModeButton;
	private MineSweeperPane mineSweeperPane;

	public ControlPane(MineSweeperPane mineSweeperPane) {
		this.mineSweeperPane = mineSweeperPane;
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(20);
		initializeGameText();
		initializeNewGameButton();
		initializeSecureModeButton();
		this.getChildren().addAll(gameText, newGameButton, secureModeButton);
	}

	private void initializeGameText() {
		this.gameText = new Text("Tiles left : " + GameLogic.getInstance().getTileCount());
		this.gameText.setFont(Font.font(35));
	}

	public void updateGameText(String text) {
		this.gameText.setText(text);
	}

	private void initializeNewGameButton() {
		this.newGameButton = new Button("New Game");
		this.newGameButton.setPrefWidth(100);
		this.newGameButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				newGameButtonHandler();
			}
		});
	}

	private void initializeSecureModeButton() {
		this.secureModeButton = new Button("Secure mode : OFF");
		this.secureModeButton.setPrefWidth(150);
		this.secureModeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				secureModeButtonHandler();
			}
		});
	}

	private void newGameButtonHandler() {
		GameLogic.getInstance().newGame();
		this.secureModeButton.setText("Secure mode : OFF");
		updateGameText("Tiles left : " + GameLogic.getInstance().getTileCount());
		for (MineSweeperSquare square : this.mineSweeperPane.getAllCells())
			square.initializeCellColor();
	}

	private void secureModeButtonHandler() {
		GameLogic.getInstance().toggleSecureMode();
		if (!GameLogic.getInstance().isSecureMode())
			this.secureModeButton.setText("Secure mode : OFF");
		else
			this.secureModeButton.setText("Secure mode : ON");
	}

}
