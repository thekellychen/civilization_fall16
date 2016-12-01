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

        String selectedRecruit = recruitList.getSelectionModel().getSelectedItem();
        TerrainTile tile = GameController.getLastClicked().getTile();

        select.setOnMouseClicked(e -> {
        	Unit unit = null;
        	switch(selectedRecruit) {
        		case "Melee Unit":
        		    unit = GameController.getCivilization().getMeleeUnit();
        		    break;
        		case "Ranged Unit":
        		    unit = GameController.getCivilization().getRangedUnit();
        		    break;
        		case "Hybrid Unit":
        		    unit = GameController.getCivilization().getHybridUnit();
        		    break;
        		case "Siege Unit":
        		    unit = GameController.getCivilization().getSiegeUnit();
        		    break;
        		case "Settlers":
        		    unit = GameController.getCivilization().getSettlerUnit("Hogwarts");
        		    break;
        		case "Farmers":
        		    unit = GameController.getCivilization().getFarmerUnit();
        		    break;
        		case "Coal Miners":
        		    unit = GameController.getCivilization().getCoalMinerUnit();
        		    break;
        		case "Anglers":
        		    unit = GameController.getCivilization().getAnglerUnit();
        		    break;
        		case "Master Builders":
        		    unit = GameController.getCivilization().getMasterBuilderUnit();
        		    break;
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
