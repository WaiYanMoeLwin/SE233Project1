package se233.project.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class InputPane extends VBox {

    HBox inputBox = new HBox(25);
    FileChooser inputFileChooser = new FileChooser();
    DirectoryChooser outputDirectoryChooser = new DirectoryChooser();
    Button inputBtn = new Button("Choose Image");
    Button outputBtn = new Button("Choose Output Directory");
    ListView<String> imageList = new ListView<String>();
    Label dropLabel = new Label("Drop Image Here");
    AnchorPane dropPane = new AnchorPane(dropLabel);
    Button continueBtn = new Button("Continue");
    String mode;

    public InputPane(String mode) {
        super(20);
        this.mode = mode;
        this.setPadding(new Insets(10, 20, 50, 20));
        dropPane.setPrefSize(400, 300);
        dropPane.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        AnchorPane.setTopAnchor(dropLabel, 60.0);
        AnchorPane.setLeftAnchor(dropLabel, 30.0);
        inputBtn.setPrefSize(100, 30);
        outputBtn.setPrefSize(200, 30);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.getChildren().addAll(inputBtn, dropPane);
        this.getChildren().addAll(inputBox, outputBtn, continueBtn);

        inputBtn.setOnAction(e -> {
            inputFileChooser.showOpenDialog(this.getScene().getWindow());
        });

        outputBtn.setOnAction(e -> {
            outputDirectoryChooser.showDialog(this.getScene().getWindow());
        });
    }
}
