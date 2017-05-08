package IDE;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by wenxi on 2017/5/6.
 */
public class LoginController  {


    @FXML private TextField userNameText;
    @FXML private PasswordField psdText;

    public void onExitBtn(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onLogup(MouseEvent mouseEvent) {
        Platform.runLater(()->{
            try {
                new LogupWindow();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void onLoginBtn(ActionEvent actionEvent) {
        if(userNameText.getText().equals("admin")&&(psdText.getText().equals("123456"))) {
            Platform.runLater(() -> {
                userNameText.getScene().getWindow().hide();
                new MainWindow();
            });
        }
    }


    /*
    检查用户名与密码
     */
    public boolean check(String userName,String psd){
        return false;
    }
}
