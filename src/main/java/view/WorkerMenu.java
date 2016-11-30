package view;

import controller.GameController;
import model.Convertable;
import model.MapObject;
import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    private Button move = new Button("Move");
    private Button convert = new Button("Convert");
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        move.setOnMouseClicked(event -> {
        	GameController.moving();
        });

        convert.setOnMouseClicked(e -> {
        	TerrainTile tile = GameController.getLastClicked().getTile();
            Convertable worker = (Convertable) tile.getOccupant();
            if (worker.canConvert(tile.getType())) {
            	tile.setOccupant(worker.convert());
            	GameController.updateResourcesBar();
            	GameController.getLastClicked().updateTileView();
            } else {
            	Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                newAlert.setHeaderText("Sorry, you cannot convert this tile");
                newAlert.setTitle("Invalid Convert");
                newAlert.showAndWait();
            }

        });

        addMenuItem(convert);
        addMenuItem(move);
    }
}
