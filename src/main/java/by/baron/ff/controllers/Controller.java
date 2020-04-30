package by.baron.ff.controllers;

import by.baron.ff.util.MogTranslator;
import by.baron.ff.util.Translator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;


public class Controller {
    @FXML
    private TextFlow textFlow;
    @FXML
    private TextArea textArea;
    @FXML
    private Button button;

    @FXML
    public void initialize(){

     //   final Translator translator = new YandexTranslator();
          final Translator translator = new MogTranslator();

        textArea.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {


                try {

                    textFlow.getChildren().setAll(new Text(translator.translate(textArea.getText())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

        );







    }
}
