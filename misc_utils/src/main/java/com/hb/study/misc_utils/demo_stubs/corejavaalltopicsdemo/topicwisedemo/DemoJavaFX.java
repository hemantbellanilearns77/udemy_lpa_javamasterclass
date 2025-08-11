package com.hb.study.udemylpajavamasterclass.global.libs.misc_demoLibs.topicwisedemo;

/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
*/
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

/*
 * created by : heman on 16-07-2025, 09:19 pm, in the "udemy_lpa_javamasterclass" project
 */

//public class DemoJavaFX extends Application {
public class DemoJavaFX {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();
        //launch(args);


        execution.finalizeExecution();
    }
   /* @Override
    public void start(Stage stage) {
        Label label = new Label("🎭 Welcome to JavaFX Carnival, Hemant!");
        Scene scene = new Scene(label, 400, 200);
        stage.setTitle("JavaFX Demo");
        stage.setScene(scene);
        stage.show();
    }*/
}
