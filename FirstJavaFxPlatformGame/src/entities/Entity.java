package entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public abstract class Entity {
	public double x, y;
	public int width, height;
	public Rectangle hitbox;
	public Entity(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		initHitbox();
	}
	
	private void initHitbox() {
		hitbox = new Rectangle((int) x, (int) y, width, height);
	}
	public void drawHitbox(GraphicsContext gc) {
		gc.strokeRect(x, y, width, height);
		//gc.fillRect(hitbox.getX(), hitbox.getY(), width, height);
	}
	public void updateHitbox() {
		hitbox.setX((int) x);
		hitbox.setY((int) y);
	}
}
