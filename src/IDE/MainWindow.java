package IDE;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by wenxi on 2017/5/5.
 */
public class MainWindow extends Stage {
    Parent root;

    public MainWindow(){
        this.initStyle(StageStyle.UNDECORATED);
        try {
            root= FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.setScene(new Scene(root,800,600));
        this.show();

    }
}
