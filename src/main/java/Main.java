import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/Main.fxml"));
        Pane pane = loader.load();

        Scene scene = new Scene(pane, 990, 520);
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Podstawy Biometrii: projekt 2 - Keystroke Dynamics ");
        primaryStage.show();
    }
}