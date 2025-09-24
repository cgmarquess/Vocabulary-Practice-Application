package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {

    private Dictionary dictionary;
    private String word;
    private int correctAnswers;
    private int totalAnswers;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
        this.correctAnswers = 0;
        this.totalAnswers = 0;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordInstruction = new Label();
        TextField translationField = new TextField();
        Button checkButton = new Button("Check");
        Label feedback = new Label();
        Label correctAnswer = new Label();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.add(wordInstruction, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(feedback, 0, 3);
        layout.add(correctAnswer, 0, 4);

        updateWord(wordInstruction, checkButton);

        checkButton.setOnAction((event) -> {
            if (this.word == null) {
                return;
            }

            String translation = translationField.getText();
            totalAnswers++;

            if (dictionary.get(word).equals(translation)) {
                correctAnswers++;
                feedback.setText("Correct! (" + correctAnswers + "/" + totalAnswers + ")");
                correctAnswer.setText("");
            } else {
                feedback.setText("Incorrect! (" + correctAnswers + "/" + totalAnswers + ")");
                correctAnswer.setText("Correct translation: " + dictionary.get(word));
            }

            this.word = dictionary.getRandomWord();
            updateWord(wordInstruction, checkButton);
            translationField.clear();
        });

        return layout;
    }

    private void updateWord(Label wordInstruction, Button checkButton) {
        if (dictionary.isEmpty()) {
            wordInstruction.setText("No words available. Add some first!");
            checkButton.setDisable(true);
        } else {
            wordInstruction.setText("Translate the word '" + this.word + "'");
            checkButton.setDisable(false);
        }
    }
}
