package inputs;

import entities.Player;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MouseInputs implements EventHandler<MouseEvent>{
	Player player;
	public MouseInputs(Player player){
		this.player = player;
	}
	@Override
	public void handle(MouseEvent event) {
		/*if(event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			System.out.println("MOUSE_CLICKED");
		}else if(event.getEventType() == MouseEvent.MOUSE_MOVED) {
			canva.setPosition(event.getX(), event.getY());
		}*/
		if(event.getEventType()==MouseEvent.MOUSE_CLICKED) {
			player.attacking = true;
			System.out.print("WW");
		}
	}

}
