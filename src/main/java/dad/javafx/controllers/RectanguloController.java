package dad.javafx.controllers;

import dad.javafx.models.RectanguloModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class RectanguloController extends VBox {

	// Vista

	private TextField anchoText;
	private TextField altoText;
	private Label areaLabel;
	private Rectangle rectangulo;

	// modelo

	private RectanguloModel ModeloRectangulo = new RectanguloModel(20.0, 20.0);

	public RectanguloController() {
		super();

		anchoText = new TextField();
		anchoText.setPrefColumnCount(5);

		HBox anchoBox = new HBox(5, new Label("Ancho:"), anchoText);
		anchoBox.setAlignment(Pos.BASELINE_CENTER);

		altoText = new TextField();
		altoText.setPrefColumnCount(5);

		HBox altoBox = new HBox(5, new Label("Alto:"), altoText);
		altoBox.setAlignment(Pos.BASELINE_CENTER);

		areaLabel = new Label("Área: XXX píxeles cuadrados");

		rectangulo = new Rectangle(100, 50);
		rectangulo.setFill(Color.AQUAMARINE);
		rectangulo.setStroke(Color.DARKBLUE);
		rectangulo.setStrokeWidth(2);

		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().addAll(anchoBox, altoBox, areaLabel, rectangulo);
		this.setPadding(new Insets(5));

		// Bindeos

		anchoText.textProperty().bindBidirectional(ModeloRectangulo.baseProperty(), new NumberStringConverter());
		altoText.textProperty().bindBidirectional(ModeloRectangulo.alturaProperty(), new NumberStringConverter());
		areaLabel.textProperty().bind(ModeloRectangulo.areaProperty().asString());
		rectangulo.widthProperty().bind(ModeloRectangulo.baseProperty());
		rectangulo.heightProperty().bind(ModeloRectangulo.alturaProperty());
	}

}
