package application;

import entities.Player;
import javafx.scene.layout.Pane;

public class GamePane {
	Pane root;
	GameCanva canva = new GameCanva();
	Player player = new Player(250,250,80,120,canva);
	GamePane(){
		root = new Pane();
		root.getChildren().add(canva.canva);
	}
}
