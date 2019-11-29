package dad.javafx.controllers;

import dad.javafx.geometria.shapes.Hexagon;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class HexagonoController extends VBox {

	// Vista

	private TextField radioText;
	private Hexagon hexagono;

	// Modelo

	private DoubleProperty radio = new SimpleDoubleProperty(20);

	public HexagonoController() {
		super();

		radioText = new TextField();

		HBox radioBox = new HBox(5, new Label("Radio:"), radioText);
		radioBox.setAlignment(Pos.BASELINE_CENTER);

		hexagono = new Hexagon();
		hexagono.setFill(Color.RED);
		hexagono.setStroke(Color.DARKBLUE);
		hexagono.setStrokeWidth(2);

		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().addAll(radioBox, hexagono);
		this.setPadding(new Insets(5));

		// bindeo modelo y vista
		radioText.textProperty().bindBidirectional(radio, new NumberStringConverter());
		hexagono.radiusProperty().bind(radio);
	}

}
