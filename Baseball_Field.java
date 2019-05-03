import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

//math.random gives a number between 1 and 0.0
public class Baseball_Field extends Application {
	public static double power;
	public static double endX;
	public static double endY;

	public static void main(String[] args) {
		launch();
	}
	public void start(Stage mainStage) throws Exception {
		ImageView ball = new ImageView("https://i2.wp.com/freepngimages.com/wp-content/uploads/2016/02/baseball-transparent-1.png?fit=547%2C554");
		ball.setFitHeight(50);
		ball.setFitWidth(50);
		ball.setVisible(false);
		
		ImageView batter = new ImageView("https://images-na.ssl-images-amazon.com/images/G/01/videogames/detail-page/B001APM444.01.lg.jpg");
		batter.setFitHeight(75);
		batter.setFitWidth(50);
		batter.setVisible(false);
		
		PathTransition path = new PathTransition();
		path.setNode(ball);
		PathTransition runnerPath = new PathTransition();
		runnerPath.setNode(batter);

		Polygon runLine = new Polygon();
		runLine.getPoints().addAll(new Double[] {
				600.0,800.0,//top
				700.0,700.0,//right
				600.0,600.0,//bottom
				500.0,700.0, //left
			
		});
		runnerPath.setPath(runLine);
		runnerPath.setDelay(Duration.millis(5000));
		runnerPath.setDuration(Duration.millis(3000));
		
		Button bat = new Button("Hit Ball");
		bat.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ball.setVisible(true);
				endX = (int)(Math.random()*1200); //calculations need to be more correct
				endY = (int)(Math.random()*800);
				Line homeRun = new Line(600,800,endX,endY);
				path.setPath(homeRun);
				path.setDuration(Duration.millis(3000));
				path.play();
				RotateTransition rot = new RotateTransition();
				rot.setNode(ball);
				rot.setByAngle(180);
				rot.setCycleCount(10);
				rot.play();
				
				batter.setVisible(true);
				runnerPath.play();
			}
		});
		Pane pane = new Pane();
		pane.setStyle("-fx-background-color: violet");
		
		Line line = new Line(); //left inner line
		line.setStartX(280);
		line.setStartY(480);
		line.setEndX(600);
		line.setEndY(800);
		line.setStroke(Color.WHITE);
		
		Line line2 = new Line(); //right inner line
		line2.setStartX(920);
		line2.setStartY(480);
		line2.setEndX(600);
		line2.setEndY(800);
		line2.setStroke(Color.WHITE);
		
		Line line3 = new Line(); //right outer line
		line3.setStartX(920);
		line3.setStartY(500);
		line3.setEndX(600);
		line3.setEndY(820);
		line3.setStroke(Color.TRANSPARENT);
		
		Line line4 = new Line(); //left outer line
		line4.setStartX(280);
		line4.setStartY(500);
		line4.setEndX(600);
		line4.setEndY(820);
		line4.setStroke(Color.TRANSPARENT);
		
		Circle home = new Circle();
		home.setCenterX(600);
		home.setCenterY(800);
		home.setRadius(40);
		home.setFill(Color.BURLYWOOD);//make same color as infield dirt
		home.setStroke(Color.BURLYWOOD);
			Polygon homeBase = new Polygon();
			homeBase.getPoints().addAll(new Double[] {
					600.0,800.0, //bottom
					590.0,790.0, //left
					600.0,780.0, //top
					610.0,790.0,//right
	});
		homeBase.setFill(Color.WHITE);
		homeBase.setStroke(Color.BLACK);
		Label homeLabel = new Label("Home Base");
		homeLabel.setLayoutX(600);
		homeLabel.setLayoutY(800);
		
		Circle first = new Circle();
		first.setCenterX(700);
		first.setCenterY(700);
		first.setRadius(25);
		first.setFill(Color.BURLYWOOD);//make same color as infield dirt
		first.setStroke(Color.BURLYWOOD);
			Polygon firstBase = new Polygon();
			firstBase.getPoints().addAll(new Double[] {
					690.0,690.0, //bottom
					680.0,700.0, //left
					690.0,710.0, //top
					700.0,700.0//right
});
		firstBase.setFill(Color.WHITE);
		firstBase.setStroke(Color.BLACK);
		Label firstLabel = new Label("First Base");
		firstLabel.setLayoutX(700);
		firstLabel.setLayoutY(700);
		
		Circle second = new Circle();
		second.setCenterX(600);
		second.setCenterY(600);
		second.setRadius(25);
		second.setFill(Color.BURLYWOOD);//make same color as infield dirt
		second.setStroke(Color.BURLYWOOD);
			Polygon secondBase = new Polygon();
			secondBase.getPoints().addAll(new Double[] {
					600.0,620.0, //bottom
					590.0,610.0, //left
					600.0,600.0, //top
					610.0,610.0//right
});
		secondBase.setFill(Color.WHITE);
		secondBase.setStroke(Color.BLACK);
		Label secondLabel = new Label("Second Base");
		secondLabel.setLayoutX(600);
		secondLabel.setLayoutY(580);
		
		Circle third = new Circle();
		third.setCenterX(500);
		third.setCenterY(700);
		third.setRadius(25);
		third.setFill(Color.BURLYWOOD);//make same color as infield dirt
		third.setStroke(Color.BURLYWOOD);
			Polygon thirdBase = new Polygon();
			thirdBase.getPoints().addAll(new Double[] {
					510.0,710.0, //bottom
					500.0,700.0, //left
					510.0,690.0, //top
					520.0,700.0//right
});
		thirdBase.setFill(Color.WHITE);
		thirdBase.setStroke(Color.BLACK);
		Label thirdLabel = new Label("Third Base");
		thirdLabel.setLayoutX(440);
		thirdLabel.setLayoutY(700);
		
		Circle mount = new Circle();
		mount.setCenterX(600);
		mount.setCenterY(700);
		mount.setRadius(25);
		mount.setFill(Color.BURLYWOOD);//make same color as infield dirt
		mount.setStroke(Color.BURLYWOOD);
		Label mountLabel = new Label("Pitcher");
		mountLabel.setLayoutX(600);
		mountLabel.setLayoutY(700);
		
	Arc inField = new Arc();
	inField.setCenterX(600);
	inField.setCenterY(650);
	inField.setRadiusX(170);
	inField.setRadiusY(100);
	inField.setStartAngle(0);
	inField.setLength(180);
	inField.setType(ArcType.OPEN);
	inField.setFill(Color.WHITE);
	inField.setStroke(Color.BLACK);
		Polygon inLine = new Polygon();
		inLine.getPoints().addAll(new Double[] {
			430.0,650.0, //left
			770.0,650.0, //right
			600.0,820.0, //bottom
	});
		inField.setFill(Color.BURLYWOOD);
		inField.setStroke(Color.BURLYWOOD);
		inLine.setFill(Color.BURLYWOOD);
		inLine.setStroke(Color.BURLYWOOD);
	
	Arc outField = new Arc();
	outField.setCenterX(600);
	outField.setCenterY(500);
	outField.setRadiusX(320);
	outField.setRadiusY(200);
	outField.setStartAngle(0);
	outField.setLength(180);
	outField.setType(ArcType.OPEN);
	outField.setFill(Color.WHITE);
	outField.setStroke(Color.BLACK);
		Polygon outLine = new Polygon();
		outLine.getPoints().addAll(new Double[] {
			280.0,500.0, //left
			920.0,500.0, //right
			600.0,820.0, //bottom
	});
		outField.setFill(Color.CORNFLOWERBLUE);
		outLine.setFill(Color.CORNFLOWERBLUE);
		outLine.setStroke(Color.CORNFLOWERBLUE);
		
		Polygon baseline = new Polygon();
		baseline.getPoints().addAll(new Double[] {
				600.0,800.0, //bottom
				500.0,700.0, //left
				600.0,600.0, //top
				700.0,700.0, //right
			
		});
		baseline.setFill(Color.CORNFLOWERBLUE);
		baseline.setStroke(Color.CORNFLOWERBLUE);
		
		Label scoreboard1 = new Label("Team  1st  2nd  3rd  4th  5th  6th  7th  8th  9th  Runs  Hits  Errors");
		scoreboard1.setLayoutX(400);
		scoreboard1.setLayoutY(900);
		Label scoreboard2 = new Label("Home  0    0      0      0     0     0     0      0     0     0       0       0");
		scoreboard2.setLayoutX(400);
		scoreboard2.setLayoutY(920);
		Label scoreboard3 = new Label("Away   0    0      0      0     0     0     0      0     0     0       0       0");
		scoreboard3.setLayoutX(400);
		scoreboard3.setLayoutY(940);

		pane.getChildren().addAll
			   (outLine,inField,inLine,outField,baseline,
				home,first,second,third,mount,
				line,line2,line3,line4,
				homeBase,firstBase,secondBase,thirdBase,
				ball,batter,
				bat,
				homeLabel,firstLabel,secondLabel,thirdLabel,mountLabel,
				scoreboard1,scoreboard2,scoreboard3);
		
		//create scene
		Scene mainScene = new Scene(pane,1200,1000);
		//add to stage
		mainStage.setScene(mainScene);
		mainStage.setTitle("Baseball Game");
		//show the stage
		mainStage.show();
		
	}

}
