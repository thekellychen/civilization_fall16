package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    private Button invest = new Button("Invest");
    private Button demolish = new Button("Demolish");
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        TerrainTile tile = GameController.getLastClicked().getTile();
        invest.setOnMouseClicked(e -> {
                if (GameController.getCivilization()
                    .getTreasury().getCoins() >= 25) {
                    ((Building) tile.getOccupant()).invest();
                    GameController.getCivilization().getTreasury().spend(25);
                    GameController.updateResourcesBar();
                } else {
                    Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                    newAlert.setHeaderText(
                        "Sorry, you cannot invest in this tile");
                    newAlert.setTitle("Invalid Invest");
                    newAlert.showAndWait();
                }
            });

        demolish.setOnMouseClicked(e -> {
                if (tile.getOccupant() instanceof Settlement
                    && GameController.getCivilization()
                    .getNumSettlements() <= 1) {
                    Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                    newAlert.setHeaderText(
                        "Sorry, you cannot demolish your only settlement");
                    newAlert.setTitle("Invalid Demolish");
                    newAlert.showAndWait();
                } else {
                    ((Building) tile.getOccupant()).demolish();
                    tile.setOccupant(null);
                }
            });
        addMenuItem(invest);
        addMenuItem(demolish);
    }
}
