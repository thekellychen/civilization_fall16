package view;


import controller.GameController;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.TerrainTile;
// import javafx.animation.RotateTransition;
// import javafx.animation.RotateTransitionBuilder;
// import javafx.animation.Timeline;
// import javafx.util.Duration;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class TerrainTileFX extends StackPane {
    private Rectangle overlay;
    private ImageView background;
    private TerrainTile tile;
    private ImageView icon = new ImageView("File:./bologna");
    //private RotateTransition rotateTransition;

    /**
     * Constructor for TerrainTileFX.
     * Creates a Rectangle for the highlighting and overlay
     * Creates ImageViews for the background terrain and icon
     * Transitions states when a tile is clicked
     * @param tile
     */
    public TerrainTileFX(TerrainTile tile) {
        this.tile = tile;
        overlay = new Rectangle(70, 70, Color.rgb(0, 0, 0, 0.0));
        overlay.setStroke(Color.BLACK);
        this.background = new ImageView(tile.getImage());
        this.getChildren().addAll(background, overlay);
        updateTileView();
        this.setOnMousePressed(event -> {
                GameController.setLastClicked(this);
            });
    }
    /**
     * gets the TerrainTile of this TerrainTileFX
     * @return TerrainTile
     */
    public TerrainTile getTile() {
        return tile;
    }
    /**
     * this method updates the view of this TerrainTileFX.
     * It should check if the TerrainTile is empty. If it is empty,
     * set the overlay to be transparent. If it is not empty, fill
     * the overlay with the color of the occupant on the terrain tile
     * If the TerrainTileFX contains an icon, remove it. If the tile is
     * not empty, get the image of the occupant of the tile and add the
     *image of the occupant to the tile.
     */
    public void updateTileView() {
        this.getChildren().remove(icon);
        if (!(tile.isEmpty())) {
            icon = new ImageView(tile.getOccupant().getImage());
            overlay.setFill(tile.getOccupant().getColor());
            this.getChildren().addAll(icon);
        } else {
            overlay.setFill(Color.TRANSPARENT);
        }
        if (GameController.getLastClicked() != null
            && GameController.getLastClicked().equals(this)) {
            overlay.setFill(Color.VIOLET);
            // rotateTransition = RotateTransitionBuilder.create().node(overlay)
            //     .duration(Duration.seconds(2)).fromAngle(0)
            //     .toAngle(720).autoReverse(true).build();
            // rotateTransition.play();
        } else {
            overlay.setEffect(null);
        }
    }
}
