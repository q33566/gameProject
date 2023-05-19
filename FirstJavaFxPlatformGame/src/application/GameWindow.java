package application;
	
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;


public class GameWindow {
	GameScene scene;
	Stage stage = new Stage();
	GameWindow(){
		scene = new GameScene();
		stage.setScene(scene.scene);
		stage.focusedProperty().addListener((new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				// TODO Auto-generated method stub
				scene.pane.player.resetDirectionBooleans();
			}
		
		}));
		stage.show();
	}
}
