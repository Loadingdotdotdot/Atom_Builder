import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import static java.lang.Thread.sleep;


/**
 * Created by Srinath on 7/16/2017.
 */
public class Main extends Application {


    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
        primaryStage.setResizable(false);
        /*primaryStage.setOnHidden(event -> {


        });*/
    }




    public static void main(String[] args) {
        launch(args);


        Runnable r = new Runnable() {
            @Override
            public void run() {


                System.out.println(SceneController.pref.get("protons", "root"));


            }
        };

        new Thread(r).start();


        //Element element = new Element();
        //element.setProtons(protons);

        //System.out.print(element.getName());

    }

    /*public static void backgroundTask() throws InterruptedException {
        while(true) {
            Notifications notificationBuilder = Notifications.create()
                    .title("Atom created")
                    .text("it has been 5 seconds")
                    .graphic(null)
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.BOTTOM_RIGHT)
                    .darkStyle();
            notificationBuilder.showInformation();
            sleep(5000);
        }
    }*/

}
