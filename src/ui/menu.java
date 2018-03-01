package ui;

	import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.ColorPicker;
	import javafx.scene.layout.Background;
	import javafx.scene.layout.BackgroundFill;
	import javafx.scene.layout.CornerRadii;
	import javafx.scene.layout.StackPane;
	import javafx.scene.paint.Paint;
	import javafx.scene.text.Font;
	import javafx.scene.text.Text;
	import javafx.stage.Stage;

	public class menu extends Application { // change to another menu after a button is clicked
		String color = "";

		@Override
		public void start(Stage primaryStage) {
			// MAIN
			StackPane root = new StackPane(); // creates a StackPane
			StackPane rootA = new StackPane(); // creates a StackPane
			StackPane rootB = new StackPane(); // creates a StackPane
			StackPane rootC = new StackPane(); // creates a StackPane

			Button butt = new Button("Play"); // creates play button
			butt.setMaxSize(200, 50);
			butt.setStyle("-fx-font-size: 15px;");
			butt.setTranslateY(-120);

			Button butt2 = new Button("Settings");// creates settings button
			butt2.setMaxSize(200, 50);
			butt2.setStyle("-fx-font-size: 15px;");
			butt2.setTranslateY(-50);

			Button butt3 = new Button("Quit");// creates quit button
			butt3.setMaxSize(200, 50);
			butt3.setStyle("-fx-font-size: 15px;");
			butt3.setTranslateY(200);

			Text text = new Text(); // creates title button
			text.setFont(new Font(30));
			text.setStyle("-fx-fill: white;"
					+ "-fx-stroke: black;" + 
					"-fx-stroke-width: 0.5px;");
			text.setText("Epic Crossword Extravaganza");
			text.setTranslateY(-200);
			
//			Button butttest = new Button("test"); // creates play button
//			butt.setMaxSize(200, 50);
			
			root.getChildren().addAll(text, butt, butt2, butt3);
			Scene scene = new Scene(root, 500, 600); // creates window
			
			//
			//
			//
			//
			// DIFFICULTY
			Button buttA = new Button("Easy"); // creates play button
			buttA.setMaxSize(200, 50);
			buttA.setStyle("-fx-font-size: 15px;");
			buttA.setTranslateY(-150);

			Button buttA2 = new Button("Medium");// creates medium button
			buttA2.setMaxSize(200, 50);
			buttA2.setStyle("-fx-font-size: 15px;");
			buttA2.setTranslateY(-80);

			Button buttA3 = new Button("Hard");// creates hard button
			buttA3.setMaxSize(200, 50);
			buttA3.setStyle("-fx-font-size: 15px;");
			buttA3.setTranslateY(-10);

			Button buttA4 = new Button("Challenging");// creates challenging button
			buttA4.setMaxSize(200, 50);
			buttA4.setStyle("-fx-font-size: 15px;");
			buttA4.setTranslateY(60);
			
			Button buttA5 = new Button("Custom");// creates Custom button
			buttA5.setMaxSize(200, 50);
			buttA5.setStyle("-fx-font-size: 15px;");
			buttA5.setTranslateY(130);

			Button buttA6 = new Button("Back");// creates back button
			buttA6.setMaxSize(200, 50);
			buttA6.setStyle("-fx-font-size: 15px;");
			buttA6.setTranslateY(200);

			Text textA = new Text(); // creates title button
			textA.setFont(new Font(20));
			textA.setText("Choose a difficulty");
			textA.setTranslateY(-200);

			rootA.getChildren().addAll(textA, buttA, buttA2, buttA3, buttA4, buttA5, buttA6);
			Scene sceneA = new Scene(rootA, 500, 600); // creates window
			//
			//
			//
			//
			// SETTINGS
			Text textB = new Text(); // creates instruction text
			textB.setFont(new Font(15));
			textB.setText("Click to change the background color");
			textB.setTranslateY(-160);

			ColorPicker colorPicker = new ColorPicker(); // created color picker
			colorPicker.setMaxSize(200, 50);
			colorPicker.setTranslateY(-120);

			Button buttB5 = new Button("Back");// creates back button
			buttB5.setMaxSize(200, 50);
			buttB5.setStyle("-fx-font-size: 15px;");
			buttB5.setTranslateY(200);

			Text textB2 = new Text(); // creates text
			textB2.setFont(new Font(20));
			textB2.setText("Settings");
			textB2.setTranslateY(-200);
			rootB.getChildren().addAll(textB, textB2, colorPicker, buttB5);
			Scene sceneB = new Scene(rootB, 500, 600); // creates window
			//
			//
			//
			//
			// END GAME
			boolean WinGame = false;
			Text textC = new Text(); // creates instruction text
			textC.setFont(new Font(15));
			if(WinGame) {
				textC.setText("WINNER");
			} else {
				textC.setText("LOSER");
			}
			textC.setTranslateY(-180);
			
			Button buttC = new Button("Replay game"); // creates Replay button
			buttC.setMaxSize(200, 50);
			buttC.setStyle("-fx-font-size: 15px;");
			buttC.setTranslateY(-120);
			
			Button buttC2 = new Button("Back to main menu"); // creates back button
			buttC2.setMaxSize(200, 50);
			buttC2.setStyle("-fx-font-size: 15px;");
			buttC2.setTranslateY(20);
			
			
			
			rootC.getChildren().addAll(textC, buttC,buttC2);
			Scene sceneC = new Scene(rootC, 500, 600); // creates window
			//
			//
			//
			//
			// .
			
			primaryStage.setTitle("Menu test");
			primaryStage.setScene(scene);
			primaryStage.show();

			butt.setOnAction(e -> primaryStage.setScene(sceneA)); // play button clicked
			butt2.setOnAction(e -> primaryStage.setScene(sceneB)); // settings button clicked
			butt3.setOnAction(e -> primaryStage.close()); // exit button clicked
			
//			butttest.setOnAction(e -> primaryStage.setScene(sceneC)); //test button

			buttA6.setOnAction(e -> primaryStage.setScene(scene)); //back to main menu
			
			buttC2.setOnAction(e -> primaryStage.setScene(scene)); //back to main menu

			colorPicker.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) { // sets the background color of the color they choose
					Paint fill = colorPicker.getValue();
					BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
					Background background = new Background(backgroundFill);
					root.setBackground(background);
					rootA.setBackground(background);
					rootB.setBackground(background);
					rootC.setBackground(background);
				}
			});
			buttB5.setOnAction(e -> primaryStage.setScene(scene)); // creates back button

		}

		public static void main(String args[]) {
			launch(args);
		}
}
