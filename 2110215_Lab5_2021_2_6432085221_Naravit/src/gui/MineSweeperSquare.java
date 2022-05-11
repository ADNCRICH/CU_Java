package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane {
	private boolean isDrawn;
	private Color baseColor;
	private int xPosition;
	private int yPosition;
	private final String oURL;
	private final String oneURL;
	private final String mineURL;
	private final String flagURL;

	public MineSweeperSquare(int x, int y) {
		this.oURL = "o.png";
		this.oneURL = "one.png";
		this.mineURL = "mine.png";
		this.flagURL = "flag.png";
		this.setxPosition(x);
		this.setyPosition(y);
		this.setPrefWidth(100);
		this.setPrefHeight(100);
		this.setMinWidth(100);
		this.setMinHeight(100);
		this.setBaseColor(Color.MOCCASIN);
		this.initializeCellColor();
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				onClickHandler();
			}
		});
	}

	private void onClickHandler() {
		if (GameLogic.getInstance().isGameEnd())
			return;
		if (!GameLogic.getInstance().isSecureMode()
				&& GameLogic.getInstance().getBoardState()[xPosition][yPosition] != SquareState.REVEALED) {
			if (GameLogic.getInstance().getBoardMark()[xPosition][yPosition] == SquareMark.ONE) {
				this.draw(new Image(ClassLoader.getSystemResource(oneURL).toString()), Color.ORANGE);
				this.setDrawn(true);
			} else if (GameLogic.getInstance().getBoardMark()[xPosition][yPosition] == SquareMark.NOTHING) {
				this.draw(new Image(ClassLoader.getSystemResource(oURL).toString()), Color.YELLOW);
				this.setDrawn(true);
			} else if (GameLogic.getInstance().getBoardMark()[xPosition][yPosition] == SquareMark.MINE) {
				this.draw(new Image(ClassLoader.getSystemResource(mineURL).toString()), Color.RED);
				this.setDrawn(true);
			}
			GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.REVEALED);
		} else if (GameLogic.getInstance().isSecureMode() && !this.isDrawn()) {
			this.draw(new Image(ClassLoader.getSystemResource(flagURL).toString()), Color.GREEN);
			GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.SECURED);
		}
	}

	public void initializeCellColor() {
		this.setBackground(new Background(new BackgroundFill(baseColor, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setDrawn(false);
	}

	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = { bgFill };
		BackgroundSize bgSize = new BackgroundSize(100, 100, false, false, false, false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = { bgImg };
		this.setBackground(new Background(bgFillA, bgImgA));
		this.setDrawn(true);
	}

	public boolean isDrawn() {
		return isDrawn;
	}

	public Color getBaseColor() {
		return baseColor;
	}

	public int getxPosition() {
		return xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public String getoURL() {
		return oURL;
	}

	public String getOneURL() {
		return oneURL;
	}

	public String getMineURL() {
		return mineURL;
	}

	public String getFlagURL() {
		return flagURL;
	}

	public void setDrawn(boolean isDrawn) {
		this.isDrawn = isDrawn;
	}

	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

}
