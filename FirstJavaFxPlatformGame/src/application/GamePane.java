package application;

import entities.Enemy;
import entities.Player;
import javafx.scene.layout.Pane;

public class GamePane {
	Pane root;
	GameCanva canva = new GameCanva();
	Player player = new Player(250,250,80,120,canva);
	Enemy enemy = new Enemy(800,275,80,120,player);

	GameLoop loop = new GameLoop(player, enemy, canva);

	GamePane(){
		root = new Pane();
		root.getChildren().add(canva.canva);
	}
}
