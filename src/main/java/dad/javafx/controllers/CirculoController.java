package dad.javafx.controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.converter.NumberStringConverter;

public class CirculoController extends VBox {

	// Vista

	private TextField radioText;
	private Circle circulo;

	// Modelo

	private DoubleProperty radio = new SimpleDoubleProperty(20);

	public CirculoController() {

		super();

		radioText = new TextField();

		HBox CajaRadio = new HBox(5, new Label("Radio:"), radioText);
		CajaRadio.setAlignment(Pos.BASELINE_CENTER);

		circulo = new Circle();
		circulo.setFill(Color.RED);
		circulo.setStroke(Color.DARKBLUE);
		circulo.setStrokeWidth(2);

		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().addAll(CajaRadio, circulo);
		this.setPadding(new Insets(5));

		// bindeo modelo y vista
		radioText.textProperty().bindBidirectional(radio, new NumberStringConverter());
		circulo.radiusProperty().bind(radio);

	}

}
