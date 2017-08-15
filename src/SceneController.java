import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class SceneController {

    @FXML
    public Rectangle area;
    @FXML
    public ImageView proton;
    @FXML
    public ImageView electron;
    @FXML
    public Label atom;
    @FXML
    public Label charge;

    private Element element = new Element();
    private int protons = 0;
    private int neutrons = 0;
    private int electrons = 0;

    @FXML
    private void onDragOver(DragEvent event) {
        if (event.getDragboard().getString().equalsIgnoreCase("proton")
            || event.getDragboard().getString().equalsIgnoreCase("electron")){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }


    @FXML
    private  void onNDragDetected(MouseEvent event) {
        Dragboard db = electron.startDragAndDrop(TransferMode.ANY);

        ClipboardContent cb = new ClipboardContent();
        cb.putString("electron");

        db.setContent(cb);
        event.consume();
    }

    @FXML
    private void onPDragDetected(MouseEvent event) {
        Dragboard db = proton.startDragAndDrop(TransferMode.ANY);

        ClipboardContent cb = new ClipboardContent();
        cb.putString("proton");

        db.setContent(cb);
        event.consume();
    }

    @FXML
    private void onDragDropped(DragEvent event) {
        //atom.setText("hehe dropped");
        if (event.getDragboard().getString().equalsIgnoreCase("proton")) {
            protons++;
            element.setProtons(protons);
            atom.setText(""+element.getName());
            checkForElectrons();
        } else if (event.getDragboard().getString().equalsIgnoreCase("electron")) {
            electrons++;
            checkForElectrons();
        }
    }

    @FXML
    private void onAreaEntered(DragEvent event) {
        area.setFill(Color.BLUE);
        area.setOpacity(.5);
    }

    @FXML
    private void onAreaExited(DragEvent event) {
        area.setFill(Color.TRANSPARENT);
    }

    private void checkForElectrons() {
        if (electrons > protons) {
            charge.setText("Negative");
        } else if (electrons < protons) {
            charge.setText("Positive");
        } else {
            charge.setText("Neutral");
        }
    }



}
