package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class GameCanva {
	public Canvas canva = new Canvas(1000,500);
	public GraphicsContext gc = canva.getGraphicsContext2D();
	public GraphicsContext ground = canva.getGraphicsContext2D();
	GameCanva(){

	}
}
