package view;

import controller.GameController;
import model.Civilization;
import model.Unit;
import model.TerrainTile;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    private ListView<String> recruitList;
    private ObservableList<String> recruits;
    private Button select = new Button("Select");
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        recruits = FXCollections.observableArrayList();
        recruits.add("Melee Unit");
        recruits.add("Ranged Unit");
        recruits.add("Hybrid Unit");
        recruits.add("Siege Unit");
        recruits.add("Settlers");
        recruits.add("Farmers");
        recruits.add("Coal Miners");
        recruits.add("Anglers");
        recruits.add("Master Builders");
        recruitList = new ListView<>(recruits);

        TerrainTile tile = GameController.getLastClicked().getTile();

        select.setOnMouseClicked(e -> {
        	String selectedRecruit = recruitList.getSelectionModel().getSelectedItem();
        	Unit unit = null;
            if (selectedRecruit.equals("Melee Unit")) {
            	unit = GameController.getCivilization().getMeleeUnit();
            } else if (selectedRecruit.equals("Ranged Unit")) {
            	unit = GameController.getCivilization().getRangedUnit();
            } else if (selectedRecruit.equals("Hybrid Unit")) {
            	unit = GameController.getCivilization().getHybridUnit();
            } else if (selectedRecruit.equals("Siege Unit")) {
                unit = GameController.getCivilization().getSiegeUnit();
            } else if (selectedRecruit.equals("Settlers")) {
            	unit = GameController.getCivilization().getSettlerUnit("Hogwarts");
            } else if (selectedRecruit.equals("Farmers")) {
            	unit = GameController.getCivilization().getFarmerUnit();
            } else if (selectedRecruit.equals("Coal Miners")) {
            	unit = GameController.getCivilization().getCoalMinerUnit();
            } else if (selectedRecruit.equals("Anglers")) {
            	unit = GameController.getCivilization().getAnglerUnit();
            } else if (selectedRecruit.equals("Master Builders")) {
            	unit = GameController.getCivilization().getMasterBuilderUnit();
            }

        	if (unit != null && unit.isAffordable()) {
        		unit.applyInitialCosts();
        		tile.setOccupant(unit);
        		GameController.updateResourcesBar();
        	    GameController.getLastClicked().updateTileView();
        	} else {
                Alert newAlert = new Alert(Alert.AlertType.INFORMATION);
                newAlert.setHeaderText("Sorry, you cannot recruit this tile");
                newAlert.setTitle("Invalid Recruit");
                newAlert.showAndWait();
        	}
        });
        addMenuItem(recruitList);
        addMenuItem(select);
    }
}
