package dad.javafx.geometria;


import dad.javafx.controllers.CirculoController;
import dad.javafx.controllers.HexagonoController;
import dad.javafx.controllers.RectanguloController;
import dad.javafx.controllers.TrianguloController;
import dad.javafx.geometria.shapes.Hexagon;
import dad.javafx.geometria.shapes.Triangle;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GeometriaApp extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		TabPane root = new TabPane();
		root.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		root.getTabs().add(new Tab("Rectángulo", new RectanguloController()));
		root.getTabs().add(new Tab("Triángulo", new TrianguloController()));
		root.getTabs().add(new Tab("Círculo", new CirculoController()));
		root.getTabs().add(new Tab("Hexágono", new HexagonoController()));
	
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Geometría");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
