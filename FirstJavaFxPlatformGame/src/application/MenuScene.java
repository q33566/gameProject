package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuScene {
	Pane menuPane = new Pane();
	Scene menuScene = new Scene(menuPane,500,500);
	MenuScene(Stage stage, GameScene gameScene){
		Button start = new Button("Start");
		start.setOnAction(e->{
			stage.setScene(gameScene.scene);
		});
		menuPane.getChildren().add(start);
	}
	
}
