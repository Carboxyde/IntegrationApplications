package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;

public class Main extends Application {

    static int ChronoId = 0;
    static int MinuteurId = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{

        HBox root = new HBox();
        Label espace0 = new Label("  ");
        VBox calculBox = new VBox();
            root.getChildren().addAll(espace0, calculBox);

        Label AddText = new Label("Addition");
        HBox AddBox = new HBox();
        Button AddCompute = new Button("Calculer");
        Label AddSpace = new Label(" ");
        calculBox.getChildren().addAll(AddText,AddBox, AddCompute, AddSpace);
        TextField AddAField = new TextField();
        Label AddSign = new Label(" + ");
        TextField AddBField = new TextField();
        Label AddEqual = new Label(" = ");
        Label AddRes = new Label("                      ");
        AddBox.getChildren().addAll(AddAField, AddSign, AddBField, AddEqual, AddRes);

        AddAField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    AddAField.setText(oldValue);
                }
            }
        });
        AddBField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    AddBField.setText(oldValue);
                }
            }
        });
        AddCompute.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddRes.setText(ContactTheAPIs.interrogerCalcul(Integer.parseInt(AddAField.getText()),Integer.parseInt(AddBField.getText()),"addition"));
            }
        });






        Label SubText = new Label("Soustraction");
        HBox SubBox = new HBox();
        Button SubCompute = new Button("Calculer");
        Label SubSpace = new Label(" ");
        calculBox.getChildren().addAll(SubText,SubBox, SubCompute, SubSpace);
        TextField SubAField = new TextField();
        Label SubSign = new Label(" - ");
        TextField SubBField = new TextField();
        Label SubEqual = new Label(" = ");
        Label SubRes = new Label("                      ");
        SubBox.getChildren().addAll(SubAField, SubSign, SubBField, SubEqual, SubRes);

        SubAField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    SubAField.setText(oldValue);
                }
            }
        });
        SubBField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    SubBField.setText(oldValue);
                }
            }
        });
        SubCompute.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SubRes.setText(ContactTheAPIs.interrogerCalcul(Integer.parseInt(SubAField.getText()),Integer.parseInt(SubBField.getText()),"soustraction"));
            }
        });



        Label MultText = new Label("Multiplication");
        HBox MultBox = new HBox();
        Button MultCompute = new Button("Calculer");
        Label MultSpace = new Label(" ");
        calculBox.getChildren().addAll(MultText,MultBox, MultCompute, MultSpace);
        TextField MultAField = new TextField();
        Label MultSign = new Label(" * ");
        TextField MultBField = new TextField();
        Label MultEqual = new Label(" = ");
        Label MultRes = new Label("                      ");
        MultBox.getChildren().addAll(MultAField, MultSign, MultBField, MultEqual, MultRes);

        MultAField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    MultAField.setText(oldValue);
                }
            }
        });
        MultBField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    MultBField.setText(oldValue);
                }
            }
        });
        MultCompute.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MultRes.setText(ContactTheAPIs.interrogerCalcul(Integer.parseInt(MultAField.getText()),Integer.parseInt(MultBField.getText()),"multiplication"));
            }
        });




        Label DivText = new Label("Division");
        HBox DivBox = new HBox();
        Button DivCompute = new Button("Calculer");
        Label DivSpace = new Label(" ");
        calculBox.getChildren().addAll(DivText,DivBox, DivCompute, DivSpace);
        TextField DivAField = new TextField();
        Label DivSign = new Label(" / ");
        TextField DivBField = new TextField();
        Label DivEqual = new Label(" = ");
        Label DivRes = new Label("                      ");
        DivBox.getChildren().addAll(DivAField, DivSign, DivBField, DivEqual, DivRes);

        DivAField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    DivAField.setText(oldValue);
                }
            }
        });
        DivBField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    DivBField.setText(oldValue);
                }
            }
        });
        DivCompute.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DivRes.setText(ContactTheAPIs.interrogerCalcul(Integer.parseInt(DivAField.getText()),Integer.parseInt(DivBField.getText()),"division"));
            }
        });




        Label DivRestText = new Label("Modulo");
        HBox DivRestBox = new HBox();
        Button DivRestCompute = new Button("Calculer");
        Label DivRestSpace = new Label(" ");
        calculBox.getChildren().addAll(DivRestText,DivRestBox, DivRestCompute, DivRestSpace);
        TextField DivRestAField = new TextField();
        Label DivRestSign = new Label(" % ");
        TextField DivRestBField = new TextField();
        Label DivRestEqual = new Label(" = ");
        Label DivRestRes = new Label("                      ");
        DivRestBox.getChildren().addAll(DivRestAField, DivRestSign, DivRestBField, DivRestEqual, DivRestRes);

        DivRestAField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    DivRestAField.setText(oldValue);
                }
            }
        });
        DivRestBField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    DivRestBField.setText(oldValue);
                }
            }
        });
        DivRestCompute.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DivRestRes.setText(ContactTheAPIs.interrogerCalcul(Integer.parseInt(DivRestAField.getText()),Integer.parseInt(DivRestBField.getText()),"divisionremainder"));
            }
        });


        Label espace1 = new Label("            ");
        VBox ChronoBox = new VBox();
        root.getChildren().addAll(espace1, ChronoBox);

        Label ChronoLabel = new Label("Chronomètre");
        Label ChronoTimeLabel = new Label("00:000");
        Button ChronoStartButton = new Button("Démarrer");
        Button ChronoStopButton = new Button("Arrêter");
        ChronoBox.getChildren().addAll(ChronoLabel, ChronoTimeLabel, ChronoStartButton, ChronoStopButton);

        Service<Void> ChronoService = new Service<Void>(){

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>(){

                    @Override
                    protected Void call() throws Exception {
                        while (true){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    int millis = ContactTheAPIs.interrogerChrono(ChronoId);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(millis%1000);
                                    sb.insert(0, (millis/1000)%60+",");
                                    sb.insert(0, (millis/60000)+":");
                                    ChronoTimeLabel.setText(sb.toString());
                                }
                            });
                            sleep(100);
                        }
                    }
                };
            }
        };

        ChronoStartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChronoId = ContactTheAPIs.interrogerChrono();
                ChronoService.restart();
            }
        });

        ChronoStopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChronoService.cancel();
            }
        });



        Label espace2 = new Label("            ");
        VBox MinuteurBox = new VBox();
        root.getChildren().addAll(espace2,MinuteurBox);

        Label MinuteurLabel = new Label("Minuteur");
        TextField MinuteurField = new TextField();
        Label MinuteurTimeLabel = new Label("00:000");
        Button MinuteurStartButton = new Button("Démarrer");
        Button MinuteurStopButton = new Button("Arrêter");
        MinuteurBox.getChildren().addAll(MinuteurLabel, MinuteurField, MinuteurTimeLabel, MinuteurStartButton, MinuteurStopButton);


        MinuteurField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,4})?")) {
                    MinuteurField.setText(oldValue);
                }
            }
        });
        Service<Void> MinuteurService = new Service<Void>(){

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>(){

                    @Override
                    protected Void call() throws Exception {
                        while (true){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    int millis = ContactTheAPIs.interrogerMinuteur(MinuteurId);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(millis%1000);
                                    sb.insert(0, (millis/1000)%60+",");
                                    sb.insert(0, (millis/60000)+":");
                                    MinuteurTimeLabel.setText(sb.toString());
                                }
                            });
                            sleep(100);
                        }
                    }
                };
            }
        };

        MinuteurStartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MinuteurId = ContactTheAPIs.creerMinuteur(Integer.parseInt(MinuteurField.getText()));
                MinuteurService.restart();
            }
        });

        MinuteurStopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MinuteurService.cancel();
            }
        });




        primaryStage.setTitle("ToolBox 1.0");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
