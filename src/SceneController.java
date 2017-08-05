import javafx.fxml.FXML;
import javafx.scene.input.DragEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class SceneController {

    @FXML
    public Rectangle area;

    @FXML
    private void onAreaEntered(DragEvent event) {
        area.setFill(Paint.valueOf("3392ff50"));
    }

}
