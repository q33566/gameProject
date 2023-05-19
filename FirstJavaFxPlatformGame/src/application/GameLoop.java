package application;

import entities.Enemy;
import entities.Player;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer{
	
	long lastFrame = 0;
	final int FPS = 60;
	final int UPS = 120;
	long timePerFram = 1000000000/FPS;
	long attackingFrame = 1000000000;
	long temp;
	Player player;
	
	public GameLoop(Player player){
		this.player = player;
	}

	
	@Override
	public void handle(long now) {
		// TODO Auto-generated method stub
		if(now-lastFrame>=timePerFram && player.attacking == false) {
				player.animationLock = false;
				player.reFresh();
				lastFrame = now;
				temp = now;
		}else if(now-lastFrame>=timePerFram && player.attacking == true){
			player.reFresh();
			player.animationLock = true;
			lastFrame = now;
			if(now - temp>500000000) {
				player.attacking = false;
			}
		}
	}
}
