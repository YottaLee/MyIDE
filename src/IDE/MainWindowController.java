package IDE;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;

public class MainWindowController {

    public TitledPane titlePane;
    @FXML private TextArea codeTextArea;
    @FXML private TextArea inputTextArea;
    @FXML private TextArea outputTextArea;


   @FXML void onSelectAllClick(){
       codeTextArea.selectAll();
   }
   @FXML void onClearClick(){
        codeTextArea.clear();
   }

   @FXML void onExecutwClick(){
       BFCompiler BFCompiler = new BFCompiler(codeTextArea.getText(),inputTextArea.getText());
       outputTextArea.setText(BFCompiler.compile(0));
   }

    @FXML void onExit() {
        Platform.exit();
    }

    public void onNew(ActionEvent actionEvent) {
       titlePane.setExpanded(true);
       codeTextArea.setVisible(true);
    }
}
