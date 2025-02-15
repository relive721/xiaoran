import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BirthdayApp extends Application {

    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("生日快乐啊，小然");

        // 创建背景图片
        Image backgroundImage = new Image("\"C:\\实训一\\小然\\189a81a95c466d929d6fbfd5860cc35c.jpg\"");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(600);

        // 创建文本区域
        textArea = new TextArea();
        textArea.setPromptText("生日快乐");
        textArea.setPrefHeight(200);
        textArea.setPrefWidth(600);

        // 创建保存按钮
        Button saveButton = new Button("保存祝福");
        saveButton.setOnAction(e -> saveMessage());

        // 布局
        VBox vbox = new VBox(10, textArea, saveButton);
        vbox.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, vbox);

        // 播放背景音乐
        playMusic();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void playMusic() {
        String musicFile = "path/to/background_music.mp3"; // 设置背景音乐路径
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // 循环播放
        mediaPlayer.play();
    }

    private void saveMessage() {
        String message = textArea.getText();
        try (FileWriter writer = new FileWriter("birthday_message.txt")) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
