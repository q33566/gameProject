package application;
	
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;


public class GameWindow {
	GameScene gameScene = new GameScene();
	Stage stage = new Stage();
	MenuScene menuScene = new MenuScene(stage,gameScene);
	GameWindow(){
		stage.setScene(menuScene.menuScene);
		stage.focusedProperty().addListener((new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				// TODO Auto-generated method stub
				gameScene.pane.player.resetDirectionBooleans();
			}
		
		}));
		stage.show();
	}
}
