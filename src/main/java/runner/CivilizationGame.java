package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import view.GridFX;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.Node;
import java.util.Optional;
import javafx.scene.control.ListView;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {
    private Stage stage;
    private Map map;
    private String civName;
    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        stage = primaryStage;
        Scene scene = startGame();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public Scene startGame() {
        StartScreen root = new StartScreen();
        Button start = root.getStartButton();
        start.setOnMouseClicked(e -> {
                TextInputDialog nameSettlement = new TextInputDialog("Town Name");
                nameSettlement.setTitle("A New Settlement");
                nameSettlement.setHeaderText("You have built a Settlement!");
                nameSettlement.setContentText("Enter the name of your first town:");
                Optional<String> result = nameSettlement.showAndWait();
                if (!result.isPresent()) {
                    return;
                }
                
                //creates new instance of the chosen civlization?
                ListView<CivEnum> civList = root.getCivList();
                CivEnum selectedCiv = civList.getSelectionModel().getSelectedItem();
                //System.out.println(civList.getSelectionModel().getSelectedItem());
                if (selectedCiv == CivEnum.ANCIENT_EGYPT || selectedCiv == null) {
                    result.ifPresent(name -> {
                        civName = name;
                    });
                    Egypt egypt = new Egypt();
                    GameController.setCivilization(egypt);
                } else if (selectedCiv == CivEnum.QIN_DYNASTY) {
                    result.ifPresent(name -> {
                        civName = name;
                    });
                    QinDynasty qinDynasty = new QinDynasty();
                    GameController.setCivilization(qinDynasty);
                } else if (selectedCiv == CivEnum.ROMAN_EMPIRE) {
                    result.ifPresent(name -> {
                        civName = name;
                    });
                    RomanEmpire romanEmpire = new RomanEmpire();
                    GameController.setCivilization(romanEmpire);
                }

                //adds said civilization to map?
                GridFX.getMap().putSettlement(civName, GameController.getCivilization(), 0, 9);
                //adds bandits to map
                GridFX.getMap().addEnemies(new Bandit(), 1);
                GameScreen gs = new GameScreen();
                gs.update();
                Scene scene = new Scene(gs);
                stage.setScene(scene);
                stage.show();
        });
        return new Scene(root);
        
    }




}
