package application;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws FileNotFoundException {
		LinkList<Flight> flights=new LinkList<>();
		
		FileChooser fc1=new FileChooser();
		FileChooser fc2=new FileChooser();
		fc1.setTitle("Choose Flights File");
		fc2.setTitle("Choose Passengers File");
		
		File flight=fc1.showOpenDialog(stage);
		if(flight.exists()) {
			Scanner in=new Scanner(flight);
			while(in.hasNext()) {
				String[] data=in.nextLine().trim().split(",");
				flights.insert(new Flight(data[0],data[1],data[2],data[3],Integer.parseInt(data[4])));
				}
			in.close();
		}
		
		File passenger=fc2.showOpenDialog(stage);;
		if(passenger.exists()) {
			Scanner in=new Scanner(passenger);
			while(in.hasNext()) {
				String[] data=in.nextLine().trim().split(",");
				Node<Flight> curr=flights.getHead();
				while(curr!=null) {
					if(curr.getData().getFlightNum().equals(data[0])) {
						curr.getData().passengers.insert(new Passenger(data[0],data[1],data[2],data[3],data[4],data[5]));
					}
					curr=curr.getNext();
				}
			}
			in.close();
		}
		
		
		
		
		Label l =new Label("Flying System");
		l.setFont(new Font(20));
		l.setAlignment(Pos.CENTER);
		
		Button b1=new Button("Flight Info");
		b1.setStyle("-fx-background-color: #b197c3;\r\n" + "        -fx-background-radius:100;\r\n");
		b1.setPrefSize(125, 20);
		
		Button b2=new Button("Passengers Info");
		b2.setStyle("-fx-background-color: #b197c3;\r\n" + "        -fx-background-radius:100;\r\n");
		b2.setPrefSize(125, 20);
		
		Button b3=new Button("Add Flight");
		b3.setStyle("-fx-background-color: #b197c3;\r\n" + "        -fx-background-radius:100;\r\n");
		b3.setPrefSize(125, 20);
		
		Button b4=new Button("Edit Flight");
		b4.setStyle("-fx-background-color: #b197c3;\r\n" + "        -fx-background-radius:100;\r\n");
		b4.setPrefSize(125, 20);
		
		Button b5=new Button("Reserve Ticket");
		b5.setStyle("-fx-background-color: #b197c3;\r\n" + "        -fx-background-radius:100;\r\n");
		b5.setPrefSize(125, 20);
		
		Button b6=new Button("Cancel Reservation");
		b6.setStyle("-fx-background-color: #b197c3;\r\n" + "        -fx-background-radius:100;\r\n");
		b6.setPrefSize(125, 20);
		
		Button b7=new Button("Check about Ticket");
		b7.setStyle("-fx-background-color: #b197c3;\r\n" + "        -fx-background-radius:100;\r\n");
		b7.setPrefSize(125, 20);
		
		Button b8=new Button("Serch for Passenger");
		b8.setStyle("-fx-background-color: #b197c3;\r\n" + "        -fx-background-radius:100;\r\n");
		b8.setPrefSize(125, 20);
		
		Button b9=new Button("Exit");
		b9.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
				+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
				+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
				+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
				"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
		b9.setPrefSize(125, 20);
		b9.setAlignment(Pos.CENTER);
		b9.setOnAction(e->{
			stage.close();
		});
		
		GridPane gp=new GridPane();
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 0, 1);
		gp.add(b4, 1, 1);
		gp.add(b5, 0, 2);
		gp.add(b6, 1, 2);
		gp.add(b7, 0, 3);
		gp.add(b8, 1, 3);
		
		gp.setVgap(20);
		gp.setHgap(20);
		gp.setAlignment(Pos.CENTER);
		
		BorderPane bp=new BorderPane();
		bp.setTop(l);
		bp.setCenter(gp);
		bp.setBottom(b9);
		bp.setAlignment(l, Pos.CENTER);
		bp.setAlignment(b9, Pos.CENTER);
		
		
		
		Scene scene1=new Scene(bp,300,300);
		stage.setScene(scene1);
		stage.setTitle("Project1");
		stage.show();
		
		b1.setOnAction(e->{
			Label l1=new Label("Flight Information");
			l1.setAlignment(Pos.CENTER);
			l1.setFont(new Font(20));
			Label l2=new Label("Enter Flight number");
			TextArea t1=new TextArea();
			t1.setPrefSize(120, 20);
			HBox hb1=new HBox();
			hb1.getChildren().addAll(l2,t1);
			hb1.setSpacing(20);
			hb1.setAlignment(Pos.CENTER);
			TextArea t2=new TextArea();
			t2.setPrefSize(150, 100);
			VBox vb=new VBox();
			vb.getChildren().addAll(t2);
			vb.setAlignment(Pos.CENTER);
			vb.setSpacing(20);
			Button bb2=new Button("Back");
			bb2.setPrefSize(80, 40);
			bb2.setOnAction(t->{
				stage.setScene(scene1);
			});
			
			bb2.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			Button bb3=new Button("Print");
			bb3.setPrefSize(80, 40);
			bb3.setOnAction(t->{
				
				Node<Flight> f=flights.getHead();
				String s="";
				
				while(f!=null){
						s+=f.getData().toString()+"\n";
					
					f=f.getNext();
				}
				t2.setText(s);
			});
			
			bb3.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			HBox hb2=new HBox();
			hb2.getChildren().addAll(bb2,bb3);
			hb2.setSpacing(40);
			hb2.setAlignment(Pos.CENTER);
			BorderPane bp2=new BorderPane();
			bp2.setTop(l1);
			bp2.setCenter(vb);
			bp2.setBottom(hb2);
			bp2.setAlignment(l1, Pos.CENTER);
			Scene scene2=new Scene(bp2,300,300);
			stage.setScene(scene2);
			stage.show();
		});		
		
		b2.setOnAction(e->{
			Label l1=new Label("Passengers Information");
			l1.setAlignment(Pos.CENTER);
			l1.setFont(new Font(20));
			Label l2=new Label("Enter Flight number");
			TextArea t1=new TextArea();
			t1.setPrefSize(120, 20);
			HBox hb1=new HBox();
			hb1.getChildren().addAll(l2,t1);
			hb1.setSpacing(20);
			hb1.setAlignment(Pos.CENTER);
			TextArea t2=new TextArea();
			t2.setPrefSize(150, 100);
			VBox vb=new VBox();
			vb.getChildren().addAll(hb1,t2);
			vb.setAlignment(Pos.CENTER);
			vb.setSpacing(20);
			Button bb2=new Button("Back");
			bb2.setPrefSize(80, 40);
			bb2.setOnAction(t->{
				stage.setScene(scene1);
			});
			
			bb2.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			Button bb3=new Button("Print");
			bb3.setPrefSize(80, 40);
			bb3.setOnAction(t->{
				Node<Flight> f=flights.getHead();
				
				while(f!=null){
					if(f.getData().getFlightNum().equals(t1.getText())){
						Node<Passenger> cur=f.getData().passengers.getHead();
						String res="";
						while(cur!=null) {
							res+=cur.getData().toString()+"\n";
							cur=cur.getNext();
						}
						t2.setText(res);
					}
					f=f.getNext();
				}
			});
			
			bb3.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			HBox hb2=new HBox();
			hb2.getChildren().addAll(bb2,bb3);
			hb2.setSpacing(40);
			hb2.setAlignment(Pos.CENTER);
			BorderPane bp2=new BorderPane();
			bp2.setTop(l1);
			bp2.setCenter(vb);
			bp2.setBottom(hb2);
			bp2.setAlignment(l1, Pos.CENTER);
			Scene scene3=new Scene(bp2,300,300);
			stage.setScene(scene3);
			stage.show();	
		});		
		
		b3.setOnAction(e->{
			Label l0=new Label("Adding Flight");
			l0.setFont(new Font(20));
			l0.setAlignment(Pos.CENTER);
			
			Label l1=new Label("Flight Numer:");
			Label l2=new Label("Flight Airline:");
			Label l3=new Label("Flight Source:");
			Label l4=new Label("Flight Destination:");
			Label l5=new Label("Flight Capacity");
			
			TextArea t1=new TextArea();
			t1.setPrefSize(150, 10);
			TextArea t2=new TextArea();
			t2.setPrefSize(150, 10);
			TextArea t3=new TextArea();
			t3.setPrefSize(150, 10);
			TextArea t4=new TextArea();
			t4.setPrefSize(150, 10);
			TextArea t5=new TextArea();
			t5.setPrefSize(150, 10);
			
			GridPane gp2=new GridPane();
			gp2.add(l1, 0, 0);
			gp2.add(t1, 1, 0);
			gp2.add(l2, 0, 1);
			gp2.add(t2, 1, 1);
			gp2.add(l3, 0, 2);
			gp2.add(t3, 1, 2);
			gp2.add(l4, 0, 3);
			gp2.add(t4, 1, 3);
			gp2.add(l5, 0, 4);
			gp2.add(t5, 1, 4);
			gp2.setVgap(10);
			gp2.setHgap(10);
			gp2.setAlignment(Pos.CENTER);
			
			Button bb2=new Button("Back");
			bb2.setPrefSize(80, 40);
			bb2.setOnAction(t->{
				stage.setScene(scene1);
			});
			
			bb2.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			Button bb3=new Button("Add");
			bb3.setPrefSize(80, 40);
			bb3.setOnAction(t->{
				flights.insert(new Flight(t1.getText(),t2.getText(),t3.getText(),t4.getText(),Integer.parseInt(t5.getText())));
				
				/*FileWriter out;
				try {
					out = new FileWriter(new File("flights.txt"),true);
					PrintWriter write=new PrintWriter(out);
					write.println(t1.getText()+","+t2.getText()+","+t3.getText()+","+t4.getText()+","+t5.getText());
					write.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}*/
				t1.clear();
				t2.clear();
				t3.clear();
				t4.clear();
				t5.clear();
			});
			
			bb3.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			HBox hb2=new HBox();
			hb2.getChildren().addAll(bb2,bb3);
			hb2.setSpacing(40);
			hb2.setAlignment(Pos.CENTER);
			
			BorderPane bp2=new BorderPane();
			bp2.setTop(l0);
			bp2.setAlignment(l0, Pos.CENTER);
			bp2.setCenter(gp2);
			bp2.setBottom(hb2);
			
			Scene scene4=new Scene(bp2,300,300);
			stage.setScene(scene4);
			stage.show();
		});
		
		b4.setOnAction(e->{
			Label l0=new Label("Editing Flight");
			l0.setFont(new Font(20));
			l0.setAlignment(Pos.CENTER);
			
			Label l1=new Label("Flight Numer:");
			Label l2=new Label("Flight Airline:");
			Label l3=new Label("Flight Source:");
			Label l4=new Label("Flight Destination:");
			Label l5=new Label("Flight Capacity");
			
			TextArea t1=new TextArea();
			t1.setPrefSize(150, 10);
			TextArea t2=new TextArea();
			t2.setPrefSize(150, 10);
			TextArea t3=new TextArea();
			t3.setPrefSize(150, 10);
			TextArea t4=new TextArea();
			t4.setPrefSize(150, 10);
			TextArea t5=new TextArea();
			t5.setPrefSize(150, 10);
			
			GridPane gp2=new GridPane();
			gp2.add(l1, 0, 0);
			gp2.add(t1, 1, 0);
			gp2.add(l2, 0, 1);
			gp2.add(t2, 1, 1);
			gp2.add(l3, 0, 2);
			gp2.add(t3, 1, 2);
			gp2.add(l4, 0, 3);
			gp2.add(t4, 1, 3);
			gp2.add(l5, 0, 4);
			gp2.add(t5, 1, 4);
			gp2.setVgap(10);
			gp2.setHgap(10);
			gp2.setAlignment(Pos.CENTER);
			
			Button bb2=new Button("Back");
			bb2.setPrefSize(80, 40);
			bb2.setOnAction(t->{
				stage.setScene(scene1);
			});
			
			bb2.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			Button bb3=new Button("Serch");
			bb3.setPrefSize(80, 40);
			bb3.setOnAction(d->{
				Node<Flight> curr=flights.getHead();
				
				while(curr!=null) {
					if(curr.getData().getFlightNum().equals(t1.getText())) {
						t2.setText(curr.getData().getAirline());
						t3.setText(curr.getData().getSource());
						t4.setText(curr.getData().getDestination());
						t5.setText(String.valueOf(curr.getData().getCapacity()));
					}
					curr=curr.getNext();
				}
			});
			
			bb3.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			
			Button bb4=new Button("Ubdate");
			bb4.setPrefSize(80, 40);
			
			bb4.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			HBox hb2=new HBox();
			hb2.getChildren().addAll(bb2,bb3,bb4);
			hb2.setSpacing(20);
			hb2.setAlignment(Pos.CENTER);
			
			BorderPane bp2=new BorderPane();
			bp2.setTop(l0);
			bp2.setAlignment(l0, Pos.CENTER);
			bp2.setCenter(gp2);
			bp2.setBottom(hb2);
			
			bb4.setOnAction(a->{
                Node<Flight> curr=flights.getHead();	
				while(curr!=null) {
					if(curr.getData().getFlightNum().equals(t1.getText())) {
						flights.delet(curr.getData());
					}
					curr=curr.getNext();
				}
				//String editTerm=t1.getText();
				t2.clear();
				t3.clear();
				t4.clear();
				t5.clear();
				l0.setText("Enter New Information");
				
				
				
				Button bb5=new Button("Submit");
				bb5.setPrefSize(80, 40);
				bb5.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
						+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
						+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
						+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
						"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
				hb2.getChildren().remove(2);
				hb2.getChildren().add(bb5);
				
				bb5.setOnAction(x->{
					//String newNum=t1.getText();
					//String newAir=t2.getText();
					//String newSource=t3.getText();
					//String newDes=t4.getText();
					//int newCap=Integer.parseInt(t5.getText());
					
					flights.insert(new Flight(t1.getText(),t2.getText(),t3.getText(),t4.getText(),Integer.parseInt(t5.getText())));
					/*try {
						ubdate("flights.txt", editTerm, newNum, newAir, newSource, newDes, newCap);
					} catch (IOException e1) {
						e1.printStackTrace();
					}*/
					t1.clear();
					t2.clear();
					t3.clear();
					t4.clear();
					t5.clear();
					
					hb2.getChildren().remove(2);
					hb2.getChildren().add(bb4);
					l0.setText("Editing Flight");
				});
			});
			
			Scene scene5=new Scene(bp2,300,300);
			stage.setScene(scene5);
			stage.show();
		});
		
		b5.setOnAction(e->{
			Label l0=new Label("Reserving Ticket");
			l0.setFont(new Font(20));
			l0.setAlignment(Pos.CENTER);
			
			Label l1=new Label("Flight Numer:");
			Label l2=new Label("Ticket Number:");
			Label l3=new Label("Passenger Name:");
			Label l4=new Label("Passport Number:");
			Label l5=new Label("Nationality");
			Label l6=new Label("Birthdate:");
			
			TextArea t1=new TextArea();
			t1.setPrefSize(150, 10);
			TextArea t2=new TextArea();
			t2.setPrefSize(150, 10);
			TextArea t3=new TextArea();
			t3.setPrefSize(150, 10);
			TextArea t4=new TextArea();
			t4.setPrefSize(150, 10);
			TextArea t5=new TextArea();
			t5.setPrefSize(150, 10);
			TextArea t6=new TextArea();
			t6.setPrefSize(150, 10);
			
			GridPane gp2=new GridPane();
			gp2.add(l1, 0, 0);
			gp2.add(t1, 1, 0);
			gp2.add(l2, 0, 1);
			gp2.add(t2, 1, 1);
			gp2.add(l3, 0, 2);
			gp2.add(t3, 1, 2);
			gp2.add(l4, 0, 3);
			gp2.add(t4, 1, 3);
			gp2.add(l5, 0, 4);
			gp2.add(t5, 1, 4);
			gp2.add(l6, 0, 5);
			gp2.add(t6, 1, 5);
			gp2.setVgap(10);
			gp2.setHgap(10);
			gp2.setAlignment(Pos.CENTER);
			
			Button bb2=new Button("Back");
			bb2.setPrefSize(80, 40);
			bb2.setOnAction(t->{
				stage.setScene(scene1);
			});
			
			bb2.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			Button bb3=new Button("Reserve");
			bb3.setPrefSize(80, 40);
			bb3.setOnAction(t->{
				Node<Flight> cur=flights.getHead();
				
				while(cur!=null) {
					
					if(cur.getData().getFlightNum().equals(t1.getText())) {
						cur.getData().passengers.insert(new Passenger(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText()));
						
						/*FileWriter out;
						try {
							out = new FileWriter(new File("passengers.txt"),true);
							PrintWriter write=new PrintWriter(out);
							write.println(t1.getText()+","+t2.getText()+","+t3.getText()+","+t4.getText()+","+t5.getText()+","+t6.getText());
							write.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}*/
						t1.clear();
						t2.clear();
						t3.clear();
						t4.clear();
						t5.clear();
						t6.clear();
					}
					cur=cur.getNext();
				}
			});
			
			bb3.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			HBox hb2=new HBox();
			hb2.getChildren().addAll(bb2,bb3);
			hb2.setSpacing(40);
			hb2.setAlignment(Pos.CENTER);
			
			BorderPane bp2=new BorderPane();
			bp2.setTop(l0);
			bp2.setAlignment(l0, Pos.CENTER);
			bp2.setCenter(gp2);
			bp2.setBottom(hb2);
			
			Scene scene6=new Scene(bp2,300,350);
			stage.setScene(scene6);
			stage.show();
		});
		
		b6.setOnAction(e->{
			Label l0=new Label("Cancel Reservation");
			l0.setFont(new Font(20));
			l0.setAlignment(Pos.CENTER);
			
			Label l1=new Label("Flight Numer:");
			Label l2=new Label("Ticket Number:");
			Label l3=new Label("Passenger Name:");
			Label l4=new Label("Passport Number:");
			Label l5=new Label("Nationality");
			Label l6=new Label("Birthdate:");
			
			TextArea t1=new TextArea();
			t1.setPrefSize(150, 10);
			TextArea t2=new TextArea();
			t2.setPrefSize(150, 10);
			TextArea t3=new TextArea();
			t3.setPrefSize(150, 10);
			TextArea t4=new TextArea();
			t4.setPrefSize(150, 10);
			TextArea t5=new TextArea();
			t5.setPrefSize(150, 10);
			TextArea t6=new TextArea();
			t6.setPrefSize(150, 10);
			
			GridPane gp2=new GridPane();
			gp2.add(l2, 0, 0);
			gp2.add(t2, 1, 0);
			gp2.add(l1, 0, 1);
			gp2.add(t1, 1, 1);
			gp2.add(l3, 0, 2);
			gp2.add(t3, 1, 2);
			gp2.add(l4, 0, 3);
			gp2.add(t4, 1, 3);
			gp2.add(l5, 0, 4);
			gp2.add(t5, 1, 4);
			gp2.add(l6, 0, 5);
			gp2.add(t6, 1, 5);
			gp2.setVgap(10);
			gp2.setHgap(10);
			gp2.setAlignment(Pos.CENTER);
			
			Button bb2=new Button("Back");
			bb2.setPrefSize(80, 40);
			bb2.setOnAction(t->{
				stage.setScene(scene1);
			});
			
			bb2.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			Button bb3=new Button("Find");
			bb3.setPrefSize(80, 40);
			bb3.setOnAction(t->{
				Node<Flight> cur=flights.getHead();
				
				while(cur!=null) {
					Node<Passenger> cur2=cur.getData().passengers.getHead();
					while(cur2!=null) {
						if(cur2.getData().getTicketNum().equals(t2.getText())) {
							t1.setText(cur2.getData().getFlightNum());
							t3.setText(cur2.getData().getName());
							t4.setText(cur2.getData().getPassportNum());
							t5.setText(cur2.getData().getNationality());
							t6.setText(cur2.getData().getBirthDate());
						}
						cur2=cur2.getNext();
					}
					
					cur=cur.getNext();
				}
			});
			
			bb3.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			
			Button bb4=new Button("Cancel");
			bb4.setPrefSize(80, 40);
			bb4.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			bb4.setOnAction(x->{
				Node<Flight> cur=flights.getHead();
				
				while(cur!=null) {
					Node<Passenger> cur2=cur.getData().passengers.getHead();
					while(cur2!=null) {
						if(cur2.getData().getTicketNum().equals(t2.getText())) {
							cur.getData().passengers.delet(cur2.getData());
							//remove("passengers.txt",t2.getText());
							t1.clear();
							t2.clear();
							t3.clear();
							t4.clear();
							t5.clear();
							t6.clear();
						}
						cur2=cur2.getNext();
					}
					
					cur=cur.getNext();
				}
			});
			
			HBox hb2=new HBox();
			hb2.getChildren().addAll(bb2,bb3,bb4);
			hb2.setSpacing(20);
			hb2.setAlignment(Pos.CENTER);
			
			BorderPane bp2=new BorderPane();
			bp2.setTop(l0);
			bp2.setAlignment(l0, Pos.CENTER);
			bp2.setCenter(gp2);
			bp2.setBottom(hb2);
			
			Scene scene7=new Scene(bp2,300,350);
			stage.setScene(scene7);
			stage.show();
		});
		
		b8.setOnAction(e->{
			Label l0=new Label("Serching for a Passenger");
			l0.setFont(new Font(20));
			l0.setAlignment(Pos.CENTER);
			
			Label l1=new Label("Flight Numer:");
			Label l2=new Label("Ticket Number:");
			Label l3=new Label("Passenger Name:");
			Label l4=new Label("Passport Number:");
			Label l5=new Label("Nationality");
			Label l6=new Label("Birthdate:");
			
			TextArea t1=new TextArea();
			t1.setPrefSize(150, 10);
			TextArea t2=new TextArea();
			t2.setPrefSize(150, 10);
			TextArea t3=new TextArea();
			t3.setPrefSize(150, 10);
			TextArea t4=new TextArea();
			t4.setPrefSize(150, 10);
			TextArea t5=new TextArea();
			t5.setPrefSize(150, 10);
			TextArea t6=new TextArea();
			t6.setPrefSize(150, 10);
			
			GridPane gp2=new GridPane();
			gp2.add(l2, 0, 0);
			gp2.add(t2, 1, 0);
			gp2.add(l1, 0, 1);
			gp2.add(t1, 1, 1);
			gp2.add(l3, 0, 2);
			gp2.add(t3, 1, 2);
			gp2.add(l4, 0, 3);
			gp2.add(t4, 1, 3);
			gp2.add(l5, 0, 4);
			gp2.add(t5, 1, 4);
			gp2.add(l6, 0, 5);
			gp2.add(t6, 1, 5);
			gp2.setVgap(10);
			gp2.setHgap(10);
			gp2.setAlignment(Pos.CENTER);
			
			Button bb2=new Button("Back");
			bb2.setPrefSize(80, 40);
			bb2.setOnAction(t->{
				stage.setScene(scene1);
			});
			
			bb2.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			Button bb3=new Button("Find");
			bb3.setPrefSize(80, 40);
			bb3.setOnAction(t->{
				Node<Flight> cur=flights.getHead();
				
				while(cur!=null) {
					Node<Passenger> cur2=cur.getData().passengers.getHead();
					while(cur2!=null) {
						if(cur2.getData().getTicketNum().equals(t2.getText())) {
							t1.setText(cur2.getData().getFlightNum());
							t3.setText(cur2.getData().getName());
							t4.setText(cur2.getData().getPassportNum());
							t5.setText(cur2.getData().getNationality());
							t6.setText(cur2.getData().getBirthDate());
						}
						cur2=cur2.getNext();
					}
					
					cur=cur.getNext();
				}
			});
			
			bb3.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			
			HBox hb2=new HBox();
			hb2.getChildren().addAll(bb2,bb3);
			hb2.setSpacing(20);
			hb2.setAlignment(Pos.CENTER);
			
			BorderPane bp2=new BorderPane();
			bp2.setTop(l0);
			bp2.setAlignment(l0, Pos.CENTER);
			bp2.setCenter(gp2);
			bp2.setBottom(hb2);
			
			Scene scene8=new Scene(bp2,300,350);
			stage.setScene(scene8);
			stage.show();
		});
		
		b7.setOnAction(e->{
			Label l0=new Label("Checking for Tichet");
			l0.setFont(new Font(20));
			l0.setAlignment(Pos.CENTER);
			
			Label l1=new Label("Enter Ticket Number");
			TextArea t1=new TextArea();
			t1.setPrefSize(150, 10);
			
			HBox hb=new HBox();
			hb.getChildren().addAll(l1,t1);
			hb.setAlignment(Pos.CENTER);
			hb.setSpacing(10);
			
			VBox vb=new VBox();
			vb.getChildren().addAll(l0,hb);
			vb.setAlignment(Pos.CENTER);
			
			TextArea t2=new TextArea();
			t2.setPrefSize(150, 100);
			
			Button b=new Button("Check");
			b.setPrefSize(80, 40);
			b.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			b.setOnAction(x->{
				Node<Flight> cur=flights.getHead();
				
				while(cur!=null) {
					Node<Passenger> cur2=cur.getData().passengers.getHead();
					while(cur2!=null) {
						if(cur2.getData().getTicketNum().equals(t1.getText())) {
							t2.setText("Reserved For:\n"+cur2.getData().toString());
						}
						
							cur2=cur2.getNext();
					}	
					cur=cur.getNext();
				}
			});
			
			Button bb2=new Button("Back");
			bb2.setPrefSize(80, 40);
			bb2.setOnAction(t->{
				stage.setScene(scene1);
			});
			
			bb2.setStyle(" -fx-padding: 8 15 15 15;\r\n" + "-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\r"
					+ "-fx-background-radius: 8;\r\n" + "-fx-background-color:"
					+ "linear-gradient(#d8a0d8, #a34313 0%,  #932693\r\n" + " 100%)," + "#d8a0d8," + "#d8a0d8,"
					+ "radial-gradient(center 50% 50%, radius 100%, #d8a0d8, #d8a0d8);\r\n" +
					"-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n" + "-fx-font-weight: bold;");
			
			HBox hb2=new HBox();
			hb2.getChildren().addAll(bb2,b);
			hb2.setAlignment(Pos.CENTER);
			hb2.setSpacing(20);
			
			
			BorderPane bp2=new BorderPane();
			bp2.setTop(vb);
			bp2.setAlignment(l0, Pos.CENTER);
			bp2.setCenter(t2);
			bp2.setAlignment(t2, Pos.CENTER);
			bp2.setBottom(hb2);
			
			Scene scene9=new Scene(bp2,300,200);
			stage.setScene(scene9);
			stage.show();
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void ubdate(String filepath,String editTerm,String newFlightNum,String newAir,String newSorce,String newdest,int newcap) throws IOException {
		String tempFile="temp.txt";
		File oldFile=new File(filepath);
		File newFile=new File(tempFile);

			FileWriter fw=new FileWriter(tempFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			Scanner in=new Scanner(new File(filepath));
			while(in.hasNext()) {
				String[] tkz=in.nextLine().trim().split(",");
				for(int i=0;i<tkz.length;i++)
					tkz[i].trim();
				
				if(tkz[0].equals(editTerm)) {
					pw.println(newFlightNum+","+newAir+","+newSorce+","+newdest+","+newcap+",");
				}
				else {
					pw.println(tkz[0]+","+tkz[1]+","+tkz[2]+","+tkz[3]+","+tkz[4]);
				}
			}
			in.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump=new File(filepath);
			newFile.renameTo(dump);
	}
	
	public void remove(String filepath,String removeTerm) {
		String tempFile="temp.txt";
		File oldFile=new File(filepath);
		File newFile=new File(tempFile);
		String currentLine;
		String data[];
		
		try {
			FileWriter fw=new FileWriter(tempFile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			
			FileReader fr=new FileReader(filepath);
			BufferedReader br=new BufferedReader(fr);
			
			while((currentLine = br.readLine()) != null) {
				data = currentLine.split(",");
				if(!(data[1].equalsIgnoreCase(removeTerm))) {
					pw.println(currentLine);
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			
			oldFile.delete();
			File dump= new File(filepath);
			newFile.renameTo(dump);
		}
		catch(Exception  e) {
			System.out.println("Error!!");
		}
	}
}
