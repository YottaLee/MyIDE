package IDE;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.security.PublicKey;

/**
 * Created by wenxi on 2017/5/6.
 */
public class LogupWindow extends Stage {

    public LogupWindow() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("logup.fxml"));
        Scene scene = new Scene(root,400,400);
        scene.getStylesheets().add(getClass().getResource("logup.css").toExternalForm());
        this.initStyle(StageStyle.UNDECORATED);
        this.setScene(scene);
        this.show();
    }



}
