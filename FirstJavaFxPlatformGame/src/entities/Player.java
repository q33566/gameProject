package entities;


import static utilz.Constants.Directions.*;
import static utilz.Constants.PlayerConstant.*;
import static collision.Collision.canMove;
import application.GameCanva;
import application.GameLoop;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Player extends Entity{
	GameLoop loop = new GameLoop(this);
	public Image[] playerAnimation = new Image[9];
	public Image[] playerAnimation2 = new Image[9];

	GameCanva canva;
	Enemy enemy = new Enemy(400,400,80,120);
	
	int playerAction = IDLE;
	int playerSpeed = 10;
	public boolean up, down, left, right, jump;
	boolean playerMoving = false;
	public boolean attacking = false;
	public boolean animationLock = false;
	public Player(double x, double y, int width, int height, GameCanva canva) {
		super(x,y,width,height);
		this.canva = canva;
		importImage();
		draw();
		loop.start();
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
			System.out.println("run");

		}else {
			playerAction = IDLE;
		}
		
		if(attacking) {
			playerAction = ATTACK_1;
			System.out.println("attack");
		}
	}
	public void draw() {
		canva.gc.drawImage(enemy.attack, 200, 200, 200, 100);
		canva.gc.drawImage(playerAnimation[playerAction],x-70, y-40, 240,160);
		canva.ground.fillRect(0, 370, 500, 40);
		canva.ground.setFill(Color.BLACK);
		drawHitbox(canva.gc);
	}
	public void reFresh() {
		canva.gc.clearRect(0, 0, canva.canva.getWidth(), canva.canva.getHeight());
		updatePosition();
		if(!animationLock) {
			setAnimation();
		}
		updateHitbox();
		draw();
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
		if(canMove(x + xSpeed, y+ySpeed+height)) {
			this.x += xSpeed;
			this.y += ySpeed;
		}
	}




	public void resetDirectionBooleans() {
		// TODO Auto-generated method stub
		up = false;
		down = false;
		left = false;
		right = false;
	}
}
