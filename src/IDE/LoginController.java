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

    public void onLoginBtn(ActionEvent actionEvent) throws IOException {
        check(userNameText.getText(),psdText.getText());
    }


    /*
    检查用户名与密码
     */
    public void check(String userName,String psd) throws IOException {

        if(!User.isExisted(userName)){
            psdText.clear();
            psdText.setPromptText("该用户不存在，请注册");
        }else {
            if(User.chechInfo(userName,psd)){
                Platform.runLater(()->{
                    new MainWindow();
                    psdText.getScene().getWindow().hide();
                });
            }else {
                psdText.clear();
                psdText.setPromptText("密码错误");
            }
        }
    }
}
