package entities;


import static utilz.Constants.Directions.*;
import static utilz.Constants.PlayerConstant.*;
import application.GameCanva;
import application.GameLoop;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import utilz.Constants.EnemyConstant;

public class Player extends Entity{
	public Image[] playerAnimation = new Image[9];
	public Image[] playerAnimation2 = new Image[9];
	public Image healthImg = new Image(getClass().getResourceAsStream("/Health.png"));
	GameCanva canva;
	
	public int health = 3;
	public int playerAction = IDLE;
	int playerSpeed = 10;
	public boolean up, down, left, right, jump;
	boolean playerMoving = false;
	public boolean attacking = false;
	public boolean animationLock = false;
	public Player(double x, double y, int width, int height, GameCanva canva) {
		super(x,y,width,height);
	}
	
	

	
	public void setMoving(boolean moving) {
		playerMoving = moving;
	}

	public void importImage() {
		playerAnimation[0] = new Image(getClass().getResourceAsStream("/__Run.gif"));
		playerAnimation[1] = new Image(getClass().getResourceAsStream("/__Idle.gif"));
		playerAnimation[2] = new Image(getClass().getResourceAsStream("/__Jump.gif"));
		playerAnimation[3] = new Image(getClass().getResourceAsStream("/__Idle.gif"));
		playerAnimation[6] = new Image(getClass().getResourceAsStream("/__AttackCombo2hit.gif"));
	}
	
	public void setAnimation() {
		if(playerMoving) {
			playerAction = RUNNING;

		}else {
			playerAction = IDLE;
		}
		
		if(attacking) {
			playerAction = ATTACK_1;
		}
	}
	
	
	public void updatePosition() {
		playerMoving = false;
		if(!left && !right && !up && !down) {
			return;
		}
		float xSpeed = 0, ySpeed = 0;
		/*if(up && !down) {
			ySpeed -= playerSpeed;
		}else if(!up && down) {
			ySpeed += playerSpeed;
		}*/
		if(left && !right) {
			xSpeed -= playerSpeed;
			playerMoving = true;

		}else if(right && !left) {
			xSpeed += playerSpeed;
			playerMoving = true;

		}
		if(canMoveLeft()&&canMoveRight()) {
			this.x += xSpeed;
			this.y += ySpeed;
		}else if(canMoveLeft()&&!canMoveRight()) {
			if(xSpeed<0)
				this.x += xSpeed;
		}else if(!canMoveLeft()&&canMoveRight()) {
			if(xSpeed>0)
				this.x += xSpeed;
		}
	}




	private boolean canMoveLeft() {
		if(x>=0)
			return true;
		else
			return false;
	}
	private boolean canMoveRight() {
		if(x+width<=1000)
			return true;
		else
			return false;
	}




	public void resetDirectionBooleans() {
		// TODO Auto-generated method stub
		up = false;
		down = false;
		left = false;
		right = false;
	}
}
