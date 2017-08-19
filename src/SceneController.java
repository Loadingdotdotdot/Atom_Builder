import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

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
    @FXML
    public Button info;

    private int protons = 0;
    private int neutrons = 0;
    private int electrons = 0;
    private String elements[] = {"Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon",
            "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminum", "Silicon",
            "Phosphorus", "Sulfur", "Chlorine", "Argon", "Potassium", "Calcium", "Scandium",
            "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper",
            "Zinc", "Gallium", "Germanium", "Arsenic", "Selenium", "Bromine", "Krypton", "Rubidium",

            "Unknown"};

    static HashMap<String, int[]> map = new HashMap<>();

    public static void main(String args[]) {
        int[] hydrogen = {0, 1, 2}; map.put("H", hydrogen);
        int[] helium = {0, 1, 2}; map.put("He", helium);
        int[] lithium = {0, 1, 2}; map.put("Li", lithium);
        int[] beryllium = {0, 1, 2}; map.put("Be", beryllium);
        int[] boron = {0, 1, 2}; map.put("B", boron);
        int[] carbon = {0, 1, 2}; map.put("C", carbon);
        int[] nitrogen = {0, 1, 2}; map.put("N", nitrogen);
        int[] oxygen = {0, 1, 2}; map.put("O", oxygen);
        int[] flourine = {0, 1, 2}; map.put("F", flourine);
        int[] neon = {0, 1, 2}; map.put("Ne", neon);
        int[] sodium = {0, 1, 2}; map.put("Na", sodium);
        int[] magnesium = {0, 1, 2}; map.put("Mg", magnesium);
        int[] aluminum = {0, 1, 2}; map.put("H", aluminum);
        int[] silicon = {0, 1, 2}; map.put("H", silicon);
        int[] phosphorus = {0, 1, 2}; map.put("H", phosphorus);
        int[] sulfur = {0, 1, 2}; map.put("H", sulfur);
        int[] chlorine = {0, 1, 2}; map.put("H", chlorine);
        int[] argon = {0, 1, 2}; map.put("H", argon);
        int[] potassium = {0, 1, 2}; map.put("H", potassium);
        int[] calcium = {0, 1, 2}; map.put("H", calcium);
        int[] scandium = {0, 1, 2}; map.put("H", scandium);
        int[] titanium = {0, 1, 2}; map.put("H", titanium);
        int[] vanadium = {0, 1, 2}; map.put("H", vanadium);
        int[] chromium = {0, 1, 2}; map.put("H", chromium);
        int[] manganese = {0, 1, 2}; map.put("H", manganese);
        int[] iron = {0, 1, 2}; map.put("H", iron);
        int[] cobalt = {0, 1, 2}; map.put("H", cobalt);
        int[] nickel = {0, 1, 2}; map.put("H", nickel);
        int[] copper = {0, 1, 2}; map.put("H", copper);
        int[] zinc = {0, 1, 2}; map.put("H", zinc);
        int[] gallium = {0, 1, 2}; map.put("H", gallium);
        int[] germanium = {0, 1, 2}; map.put("H", germanium);
        int[] arsenic = {0, 1, 2}; map.put("H", arsenic);
        int[] selenium = {0, 1, 2}; map.put("H", selenium);
        int[] bromine = {0, 1, 2}; map.put("H", bromine);
        int[] krypton = {0, 1, 2}; map.put("H", krypton);
        int[] rubidium = {0, 1, 2}; map.put("H", rubidium);

        map.put("H", hydrogen);
    }

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
        if (event.getDragboard().getString().equalsIgnoreCase("proton")) {
            protons++;
            checkForProtons();
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

    private String getElementName() {
        return elements[protons-1];
    }

    private void checkForProtons() {
            atom.setText("" + getElementName());
    }

    private void checkForElectrons() {
        if (electrons > protons) {
            charge.setText("Charge: Negative");
            charge.setTextFill(Color.RED);
        } else if (electrons < protons) {
            charge.setText("Charge: Positive");
            charge.setTextFill(Color.GREEN);
        } else {
            charge.setText("Charge: Neutral");
            charge.setTextFill(Color.BLACK);
        }
    }

    @FXML
    private void onInfoClicked() {
        Parent root;
        try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("teststage.fxml"));
                Stage stage = new Stage();
                stage.setTitle("My New Stage Title");
                stage.setScene(new Scene(root, 450, 450));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }



}
