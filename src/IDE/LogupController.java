package IDE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

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

    public void onLogupBtn(ActionEvent actionEvent) throws IOException {
        String userName=userNameText.getText();
        String psd=psdText.getText();
        String psdConfirm=psdConfirmText.getText();


        if(User.isExisted(userName)){
            psdText.clear();
            psdConfirmText.clear();
            userNameText.clear();
            userNameText.setPromptText("用户已存在");
        }else{
            if(!psd.equals(psdConfirm)){
                psdText.clear();
                psdConfirmText.clear();
                psdConfirmText.setPromptText("两次输入的密码不同");
                psdText.requestFocus();
            }else{
                User.addUser(userName, psd);
                psdText.clear();
                psdConfirmText.clear();
                userNameText.clear();
                userNameText.setPromptText("用户注册成功");
            }
        }
//        if(!psd.equals(psdConfirm)){
//            psdText.clear();
//            psdConfirmText.clear();
//            psdConfirmText.setPromptText("两次输入的密码不同");
//            psdText.requestFocus();
//        }else{
//            if(!User.isExisted(userName)){
//                User.addUser(userName, psd);
//                psdText.clear();
//                psdConfirmText.clear();
//                userNameText.clear();
//                userNameText.setPromptText("用户注册成功");
//            }else {
//                psdText.clear();
//                psdConfirmText.clear();
//                userNameText.clear();
//                userNameText.setPromptText("用户已存在");
//               // userNameText.requestFocus();
//            }
//        }
    }

}
