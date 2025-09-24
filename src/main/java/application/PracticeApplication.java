package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage stage) throws Exception {
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        Parent inputLayout = inputView.getView();
        Parent practiceLayout = practiceView.getView();

        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        menu.getChildren().addAll(enterButton, practiceButton);
        layout.setTop(menu);

        enterButton.setOnAction((event) -> layout.setCenter(inputLayout));
        practiceButton.setOnAction((event) -> layout.setCenter(practiceLayout));

        layout.setCenter(inputLayout);

        Scene scene = new Scene(layout, 400, 300);

        scene.getStylesheets().add("style.css");

        stage.setScene(scene);
        stage.setTitle("Vocabulary Practice");
        stage.show();
    }

    public static void main(String[] args) {
        launch(PracticeApplication.class);
    }
}
