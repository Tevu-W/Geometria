package dad.javafx.controllers;

import dad.javafx.geometria.shapes.Triangle;
import dad.javafx.models.TrianguloModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class TrianguloController extends VBox{

	
	//Vista
	
	private TextField baseText;
	private TextField alturaText;
	private Triangle trianguloShape;
	
	//model
	
	private TrianguloModel modeloTriangulo = new TrianguloModel(20.0, 20.0);
	
	
	public TrianguloController() {
		
		super();
		
		baseText = new TextField();
		baseText.setPrefColumnCount(5);
		
		HBox baseBox = new HBox(5, new Label("Base:"), baseText);
		baseBox.setAlignment(Pos.BASELINE_CENTER);

		alturaText = new TextField();
		alturaText.setPrefColumnCount(5);
		
		HBox alturaBox = new HBox(5, new Label("Altura:"), alturaText);
		alturaBox.setAlignment(Pos.BASELINE_CENTER);
		
		trianguloShape = new Triangle();
		trianguloShape.setFill(Color.AQUAMARINE);
		trianguloShape.setStroke(Color.DARKBLUE);
		trianguloShape.setStrokeWidth(2);
		
		setSpacing(5);
		setAlignment(Pos.TOP_CENTER);
		getChildren().addAll(baseBox, alturaBox, trianguloShape);
		setPadding(new Insets(5));
		
		// bindeo modelo y vista 
		
		baseText.textProperty().bindBidirectional(modeloTriangulo.baseProperty(), new NumberStringConverter());
		alturaText.textProperty().bindBidirectional(modeloTriangulo.alturaProperty(), new NumberStringConverter());
		trianguloShape.baseProperty().bind(modeloTriangulo.baseProperty());
		trianguloShape.heightProperty().bind(modeloTriangulo.alturaProperty());
		
	}
	
	
}
