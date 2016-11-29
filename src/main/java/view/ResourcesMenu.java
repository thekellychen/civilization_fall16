package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;
import javafx.scene.control.Label;

public class ResourcesMenu {
    private HBox hbox;
    private Civilization civ;
    private Label strategyLevel;
    private Label resources;
    private Label settlements;
    private Label money;
    private Label food;
    private Label happiness;
    /**
    * creates a resource bar and display the current state of 
    * your civilization's resouces
    */
    public ResourcesMenu() {
        hbox = new HBox();
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        civ = GameController.getCivilization();
        strategyLevel = new Label("\tStrat Level:" + civ.getStrategy().getStrategyLevel());
        resources = new Label("\tResources:" + civ.getResources());
        settlements = new Label("\tSettlements:" + civ.getNumSettlements());
        money = new Label("\tMoney:" + civ.getTreasury().getCoins());
        food = new Label("\tFood:" + civ.getFood());
        happiness = new Label("\tHappiness:" + civ.getHappiness());
        hbox.getChildren().clear();
        hbox.getChildren().addAll(strategyLevel, resources, settlements, money, food, happiness);
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        update();
        return hbox;
    }
}