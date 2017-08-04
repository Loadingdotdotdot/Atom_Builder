import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Srinath on 7/16/2017.
 */
public class Main extends Application {


    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }

    static int protons = 10;

    public static void main(String[] args) {
        launch(args);


        Element element = new Element();
        element.setProtons(protons);

        System.out.print(element.getName());

    }

}
