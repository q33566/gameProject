package inputs;

import static utilz.Constants.Directions.DOWN;
import static utilz.Constants.Directions.LEFT;
import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.Directions.UP;

import entities.Player;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


public class KeyBoardInputs implements EventHandler<KeyEvent>{
	
	Player player;
	public KeyBoardInputs(Player player){
		this.player = player;
	}
	@Override
	public void handle(KeyEvent event) {
		if(event.getEventType()== KeyEvent.KEY_RELEASED ) {
			switch(event.getCode()) {
			case W:
				player.up = false;
				break;
			case A:
				player.left = false;
				break;
			case S:
				player.down = false;
				break;
			case D:
				player.right = false;
				break;
			default:
				break;
			}
		}else if(event.getEventType()==KeyEvent.KEY_PRESSED) {
			player.setMoving(true);
			switch(event.getCode()) {
			case W:
				player.up = true;
				break;
			case A:
				player.left = true;
				break;
			case S:
				player.down = true;
				break;
			case D:
				player.right = true;
				break;
			default:
				break;
			}
		}
	}

}
