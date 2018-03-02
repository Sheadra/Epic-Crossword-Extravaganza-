package ui;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Menus extends Application { // change to another menu after a button is clicked
	String color = "";
	private boolean alreadyGoing = false;

	@Override
	public void start(Stage primaryStage) {
		// MAIN
		StackPane Main = new StackPane(); // creates a StackPane
		StackPane difficultyMenu = new StackPane(); // creates a StackPane
		StackPane settingsMenu = new StackPane(); // creates a StackPane
		StackPane rootC = new StackPane(); // creates a StackPane
		// StackPane PauseMenu = new StackPane();
		FlowPane Game = new FlowPane();
		FlowPane topMenu = new FlowPane();
		FlowPane botMenu = new FlowPane();
		FlowPane rootG = new FlowPane();
		FlowPane boxes = new FlowPane();
		VBox hintDown = new VBox();
		VBox hintSide = new VBox();

		topMenu.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
		topMenu.setStyle("-fx-border-color: black");
		topMenu.setMinWidth(912);

		botMenu.setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
		botMenu.setStyle("-fx-border-color: black");
		botMenu.setMinWidth(912);

		Button playButton = new Button("Play"); // creates play button
		playButton.setMaxSize(200, 50);
		playButton.setStyle("-fx-font-size: 15px;");
		playButton.setTranslateY(-120);

		Button settingsButton = new Button("Settings");// creates settings button
		settingsButton.setMaxSize(200, 50);
		settingsButton.setStyle("-fx-font-size: 15px;");
		settingsButton.setTranslateY(-50);

		Button exitButton = new Button("Quit");// creates quit button
		exitButton.setMaxSize(200, 50);
		exitButton.setStyle("-fx-font-size: 15px;");
		exitButton.setTranslateY(200);

		Text mainTitle = new Text(); // creates title button
		mainTitle.setFont(new Font(30));
		mainTitle.setStyle("-fx-fill: white;" + "-fx-stroke: black;" + "-fx-stroke-width: 0.5px;");
		mainTitle.setText("Epic Crossword Extravaganza");
		mainTitle.setTranslateY(-200);

		Main.getChildren().addAll(mainTitle, playButton, settingsButton, exitButton);
		Scene mainScene = new Scene(Main, 500, 600); // creates window
		//
		//
		//
		//
		// DIFFICULTY
		Button easyButton = new Button("Easy"); // creates play button
		easyButton.setMaxSize(200, 50);
		easyButton.setStyle("-fx-font-size: 15px;");
		easyButton.setTranslateY(-150);

		Button mediumButton = new Button("Medium");// creates medium button
		mediumButton.setMaxSize(200, 50);
		mediumButton.setStyle("-fx-font-size: 15px;");
		mediumButton.setTranslateY(-80);

		Button hardButton = new Button("Hard");// creates hard button
		hardButton.setMaxSize(200, 50);
		hardButton.setStyle("-fx-font-size: 15px;");
		hardButton.setTranslateY(-10);

		Button challengButton = new Button("Challenging");// creates challenging button
		challengButton.setMaxSize(200, 50);
		challengButton.setStyle("-fx-font-size: 15px;");
		challengButton.setTranslateY(60);

		Button difficultyBack = new Button("Back");// creates back button
		difficultyBack.setMaxSize(200, 50);
		difficultyBack.setStyle("-fx-font-size: 15px;");
		difficultyBack.setTranslateY(200);

		Text difficultyTitle = new Text(); // creates title button
		difficultyTitle.setFont(new Font(20));
		difficultyTitle.setText("Choose a difficulty");
		difficultyTitle.setTranslateY(-200);

		difficultyMenu.getChildren().addAll(difficultyTitle, easyButton, mediumButton, hardButton, challengButton, difficultyBack);
		Scene DiffScene = new Scene(difficultyMenu, 500, 600); // creates window
		//
		//
		//
		//
		// SETTINGS
		Text colorInst = new Text(); // creates instruction text
		colorInst.setFont(new Font(15));
		colorInst.setText("Click to change the background color");
		colorInst.setTranslateY(-160);

		ColorPicker colorPicker = new ColorPicker(); // created color picker
		colorPicker.setMaxSize(200, 50);
		colorPicker.setTranslateY(-120);

		Button settingBack = new Button("Back");// creates back button
		settingBack.setMaxSize(200, 50);
		settingBack.setStyle("-fx-font-size: 15px;");
		settingBack.setTranslateY(200);

		Text settingTitle = new Text(); // creates text
		settingTitle.setFont(new Font(20));
		settingTitle.setText("Settings");
		settingTitle.setTranslateY(-200);
		settingsMenu.getChildren().addAll(colorInst, settingTitle, colorPicker, settingBack);
		Scene settingScene = new Scene(settingsMenu, 500, 600); // creates window
		//
		//
		//
		//
		// END GAME
		boolean WinGame = true;
		Text winnerText = new Text(); // shows if they win or lose
		winnerText.setFont(new Font(15));
		if (WinGame) {
			winnerText.setText("WINNER");
		} else {
			winnerText.setText("LOSER");
		}
		winnerText.setTranslateY(-180);

		Button replayButton = new Button("Replay game"); // creates Replay button
		replayButton.setMaxSize(200, 50);
		replayButton.setStyle("-fx-font-size: 15px;");
		replayButton.setTranslateY(-120);

		Button endGameBack = new Button("Back to main menu"); // creates back button
		endGameBack.setMaxSize(200, 50);
		endGameBack.setStyle("-fx-font-size: 15px;");
		endGameBack.setTranslateY(20);

		rootC.getChildren().addAll(winnerText, replayButton, endGameBack);
		Scene endScene = new Scene(rootC, 500, 600); // creates window
		//
		//
		//
		//
		// topMenu
		Button pause = new Button("Pause"); // creates pause button
		pause.setMaxSize(300, 50);
		pause.setStyle("-fx-font-size: 15px;");
		pause.setTranslateX(1);

		Label label = new Label();
		DoubleProperty time = new SimpleDoubleProperty();
		label.textProperty().bind(time.asString("%.0f seconds"));

		BooleanProperty running = new SimpleBooleanProperty();

		AnimationTimer timer = new AnimationTimer() {

			private long startTime = System.currentTimeMillis();
			private long now = System.currentTimeMillis();
			@Override
			public void start() {
				if(alreadyGoing) {
					startTime = System.currentTimeMillis();
					now = System.currentTimeMillis();
				}
				running.set(true);
				alreadyGoing = true;
				super.start();
			}

			@Override
			public void stop() {
				running.set(false);
				super.stop();
			}

			@Override
			public void handle(long timestamp) {
				now = now + 16;
					time.set((now - startTime) / 900); // / 900.0
			}
		};

		label.setStyle("-fx-font-size: 20px;");
		label.setTranslateX(330);
		VBox root = new VBox(10, label);

		topMenu.getChildren().addAll(pause, root);
		//
		//
		//
		//
		// botMenu
		Text wordInst = new Text("	Enter the whole word:	");
		TextField wordField = new TextField();
		wordField.setMinWidth(200);
		wordField.setMinHeight(35);

		wordField.clear();

		botMenu.getChildren().addAll(wordInst, wordField);
		//
		//
		//
		//
		// pause menu
		// Button test = new Button(); //in bad spot,
		// PauseMenu.getChildren().addAll(test);
		Button pauseButton = new Button("Pause");
		BorderPane PauseMenu = new BorderPane(pauseButton);
		//
		//
		//
		//
		// Game
		boxes.setMaxWidth(500);
		hintSide.setPrefWidth(250);
		hintDown.setPrefWidth(250);
		for (int j = 1; j <= 225; j++) {
			Rectangle rec = new Rectangle(25, 25);
			rec.setFill(Color.WHITE);
			rec.setStroke(Color.BLACK);
			boxes.getChildren().addAll(rec);
		}
		Text HorizontalTitle = new Text("Horizontal"); // getHint();
		HorizontalTitle.setFont(new Font(30));
		hintSide.setAlignment(Pos.BASELINE_CENTER);
		hintSide.getChildren().addAll(HorizontalTitle);

		Text VerticalTitle = new Text("Vertical"); // getHint();
		VerticalTitle.setFont(new Font(30));
		hintDown.setAlignment(Pos.BASELINE_CENTER);

		hintDown.getChildren().addAll(VerticalTitle);

		Game.getChildren().addAll(topMenu, boxes, hintDown, hintSide, botMenu, PauseMenu);
		Scene GameScene = new Scene(Game, 912, 460); // creates window //500,600
		primaryStage.setResizable(false);
		//
		//
		//
		//
		//
		primaryStage.setTitle("Menu test");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		// texttext.setText(wordField.getText());

		pause.setOnAction(e -> {
			StackPane pauseRoot = new StackPane();
			hintDown.setEffect(new GaussianBlur(11));
			hintSide.setEffect(new GaussianBlur(11));
			boxes.setEffect(new GaussianBlur(11));
			botMenu.setEffect(new GaussianBlur(11));
			timer.stop();
			
			Text pauseText = new Text("Paused");
			pauseText.setTranslateY(-110);
			
//			pauseRoot.getChildren().add(pauseText);
			pauseRoot.setStyle("-fx-background-color: rgba(128,128,128, 0.9);");
			pauseRoot.setMinWidth(200);
			pauseRoot.setMinHeight(300);
			pauseRoot.setLayoutX(350);
			pauseRoot.setPadding(new Insets(20));

			Button resume = new Button("Resume");
			resume.setMaxSize(200, 50);
			resume.setTranslateY(-55);
			
			Button save = new Button("Save");
			save.setMaxSize(200, 50);
			save.setTranslateY(0);
			
			Button pauseBack = new Button("Back to main menu");
			pauseBack.setMaxSize(200, 50);
			pauseBack.setTranslateY(55);
			
			Button pauseExit = new Button("Exit game");
			pauseExit.setMaxSize(200, 50);
			pauseExit.setTranslateY(110);
			
			pauseRoot.getChildren().addAll(resume, save, pauseBack, pauseExit, pauseText);
			

			Stage popupStage = new Stage(StageStyle.TRANSPARENT);
			popupStage.initOwner(primaryStage);
//			popupStage.initModality(Modality.APPLICATION_MODAL);
			popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));

			resume.setOnAction(event -> {
				hintDown.setEffect(new GaussianBlur(0));
				hintSide.setEffect(new GaussianBlur(0));
				boxes.setEffect(new GaussianBlur(0));
				botMenu.setEffect(new GaussianBlur(0));
				popupStage.hide();
				timer.start();
			});
			save.setOnAction(event2 -> {
				System.out.println("saved");
			});
			pauseBack.setOnAction(event2 -> {
				primaryStage.setScene(mainScene);
				hintDown.setEffect(new GaussianBlur(0));
				hintSide.setEffect(new GaussianBlur(0));
				boxes.setEffect(new GaussianBlur(0));
				botMenu.setEffect(new GaussianBlur(0));
				popupStage.hide();
			});
			
			pauseExit.setOnAction(event3 -> primaryStage.close());
			popupStage.show();
		});

		playButton.setOnAction(e -> primaryStage.setScene(DiffScene)); // play button clicked
		settingsButton.setOnAction(e -> primaryStage.setScene(settingScene)); // settings button clicked
		exitButton.setOnAction(e -> primaryStage.close()); // exit button clicked
		wordField.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) { // sets the background color of the color they choose

				wordField.clear();
			}
		});
		easyButton.setOnAction(e -> { // sets the background color of the color they choose
				timer.start();
				primaryStage.setScene(GameScene);
				alreadyGoing = false;
		});
		mediumButton.setOnAction(e -> { // sets the background color of the color they choose
			timer.start();
			primaryStage.setScene(GameScene);
			alreadyGoing = false;
	});
		hardButton.setOnAction(e -> { // sets the background color of the color they choose
			timer.start();
			primaryStage.setScene(GameScene);
			alreadyGoing = false;
	});
		challengButton.setOnAction(e -> { // sets the background color of the color they choose
			timer.start();
			primaryStage.setScene(GameScene);
			alreadyGoing = false;
	});
		

		difficultyBack.setOnAction(e -> primaryStage.setScene(mainScene)); // back to main menu

		endGameBack.setOnAction(e -> primaryStage.setScene(mainScene)); // back to main menu

		colorPicker.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) { // sets the background color of the color they choose
				Paint fill = colorPicker.getValue();
				BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
				Background background = new Background(backgroundFill);
				Main.setBackground(background);
				difficultyMenu.setBackground(background);
				settingsMenu.setBackground(background);
				rootC.setBackground(background);
				rootG.setBackground(background);
			}
		});
		settingBack.setOnAction(e -> primaryStage.setScene(mainScene)); // creates back button
	}

	public static void main(String args[]) {
		launch(args);
	}
}
