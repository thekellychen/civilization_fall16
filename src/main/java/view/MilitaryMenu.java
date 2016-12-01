package view;

import controller.GameController;
import javafx.scene.control.Button;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    private Button attack = new Button("Attack");
    private Button move = new Button("Move");
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        attack.setOnMouseClicked(e -> {
                GameController.attacking();
                GameController.updateResourcesBar();
            });

        move.setOnMouseClicked(event -> {
                GameController.moving();
            });

        addMenuItem(attack);
        addMenuItem(move);

    }
}
