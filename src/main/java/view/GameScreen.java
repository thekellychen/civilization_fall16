package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import view.TerrainTileFX;
import view.GridFX;
import view.ResourcesMenu;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import model.Map;
import javafx.scene.layout.GridPane;
import view.MilitaryMenu;
import view.WorkerMenu;
import view.RecruitMenu;
import view.BuildingMenu;
import view.StatusMenu;
/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {
    private static VBox vbox;
    private GridFX grid;
    private static ResourcesMenu resourceBar;
    private static MilitaryMenu militaryMenu;
    private static WorkerMenu workerMenu;
    private static RecruitMenu recruitMenu;
    private static BuildingMenu buildingMenu;
    private static StatusMenu statusMenu;
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        GridFX grid = GridFX.getInstance();
        resourceBar = new ResourcesMenu();
        setCenter(grid);
        setTop(resourceBar.getRootNode());
        setLeft(vbox);
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        grid.update();
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
       if (state == GameController.GameState.MILITARY) {
        VBox vbox = militaryMenu.getRootNode();
       } else if (state == GameController.GameState.WORKER) {
        VBox vbox = workerMenu.getRootNode();
       } else if (state == GameController.GameState.RECRUITING) {
        VBox vbox = recruitMenu.getRootNode();
       } else if (state == GameController.GameState.BUILDING) {
        VBox vbox = buildingMenu.getRootNode();
       } else {
        VBox vbox = statusMenu.getRootNode();
       }
    }
}
