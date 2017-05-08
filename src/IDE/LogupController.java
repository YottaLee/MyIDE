package IDE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by wenxi on 2017/5/8.
 */
public class LogupController {

    public TextField userNameText;
    public PasswordField psdText;
    public PasswordField psdConfirmText;

    public void onExitBtn(ActionEvent actionEvent) {
        userNameText.getScene().getWindow().hide();
    }

    public void onLogupBtn(ActionEvent actionEvent) {
        if(!psdText.getText().equals(psdConfirmText.getText())){
            psdText.clear();
            psdConfirmText.clear();
            psdConfirmText.setPromptText("两次输入的密码不同");
            psdText.requestFocus();
        }else{

        }
    }

}
