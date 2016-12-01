package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {
    private static VBox vbox;
    private GridFX map;
    private static ResourcesMenu resourceBar;
    private static WorkerMenu workerMenu;
    private static BuildingMenu buildingMenu;
    private static MilitaryMenu militaryMenu;
    private static StatusMenu statusMenu;
    private static RecruitMenu recruitMenu;

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        map = GridFX.getInstance();
        resourceBar = new ResourcesMenu();
        statusMenu = new StatusMenu();
        vbox = new VBox();
        vbox.getChildren().add(statusMenu.getRootNode());
        setCenter(map);
        setTop(resourceBar.getRootNode());
        setLeft(vbox);
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        map.update();
        resourceBar.update();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return resourceBar;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        vbox.getChildren().clear();
        if (state == GameController.GameState.MILITARY) {
            militaryMenu = new MilitaryMenu();
            vbox.getChildren().add(militaryMenu.getRootNode());
        } else if (state == GameController.GameState.WORKER) {
            workerMenu = new WorkerMenu();
            vbox.getChildren().add(workerMenu.getRootNode());
        } else if (state == GameController.GameState.RECRUITING) {
            recruitMenu = new RecruitMenu();
            vbox.getChildren().add(recruitMenu.getRootNode());
        } else if (state == GameController.GameState.BUILDING) {
            buildingMenu = new BuildingMenu();
            vbox.getChildren().add(buildingMenu.getRootNode());
        } else if (state == GameController.GameState.NEUTRAL) {
            vbox.getChildren().add(statusMenu.getRootNode());
        }
    }
}
