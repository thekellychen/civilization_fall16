package view;

import model.Civilization;
import view.CivEnum;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.paint.Color;
/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {
    private Button start;

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        Image background = new Image("File:./src/main/java/view/civ_background.png");
        ImageView imview = new ImageView(background);
        Button start = new Button("Start");
        ListView<CivEnum> civList = getCivList();
        Text title = new Text("Select a Civilization to Begin");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title.setFill(Color.WHITE);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(title, civList, start);
        vbox.setAlignment(Pos.CENTER);
        vbox.setTranslateY(100);
        this.getChildren().addAll(imview, vbox);
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return this.start;
    }
    /**
    * return a ListView of CivEnums representing the list of 
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        ObservableList<CivEnum> civs = FXCollections.observableArrayList();
        civs.add(CivEnum.ANCIENT_EGYPT);
        civs.add(CivEnum.QIN_DYNASTY);
        civs.add(CivEnum.ROMAN_EMPIRE);
        ListView<CivEnum> civList = new ListView<>(civs);
        civList.setMaxWidth(200);
        civList.setMaxHeight(100);
        return civList;
    }
}