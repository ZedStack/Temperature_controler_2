import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import g4p_controls.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Temperature_controler_2 extends PApplet {

// Imports


// Classes
Complex complex;


//- ## P R O C E S S I N G   S T A N D A R S ######################################################## -//
//- ################################################################################################# -//

public void setup() {
	
	noFill     ();
	stroke     (255);
	background (20);
	frameRate  (60);

	complex = new Complex ((1.0f/4.0f) * width);
	complex.setCoors      ((complex.getWidth () / 2) + 10, (complex.getHeight () / 2) + 10);
	complex.createRooms   ();
	complex.createSensors ();

	// complex.render ();
	createGUI ();
}

public void draw() {
	background(20);
	complex.render ();
}

//- ## P R O C E S S I N G   S T A N D A R S ######################################################## -//
//- ################################################################################################# -//
public class Complex {
	private float _xAxis;
	private float _yAxis;
	private float _stdSize;

	private ArrayList<Room> rooms     = new ArrayList<Room> ();
	private ArrayList<Sensor> sensors = new ArrayList<Sensor> ();

	public Complex (float stdSize) {
		this._stdSize = stdSize;
	}

	public void createRooms () {
		// TODO: Simplify the algorithms for 'xAxis' and 'yAxis'.
		rooms.add ( // Room 1
			new Room (
				"Room #1",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize),
				// (this._stdSize * 2) / 5,
				(2.0f/5.0f) * this._stdSize,
				(1.0f/3.0f) * this._stdSize
			)
		);
		rooms.add ( // Room 2
			new Room (
				"Room #2",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((2.0f/5.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize),
				(3.0f/2.0f) * this._stdSize,
				this._stdSize
			)
		);
		rooms.add ( // Room 3
			new Room (
				"Room #3",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize),
				this._stdSize,
				this._stdSize
			)
		);
		rooms.add ( // Room 4
			new Room (
				"Room #4",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) - ((1.0f/2.0f) * this._stdSize),
				this._stdSize,
				(1.0f/2.0f) * this._stdSize
			)
		);
	}
	public void createSensors () {
		sensors.add ( // Sensor 1
			new Sensor (
				"S_1",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((2.0f/5.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) + ((1.0f/3.0f) * this._stdSize)
			)
		);
		sensors.add ( // Sensor 2
			new Sensor (
				"S_2",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((2.0f/5.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) + ((2.0f/3.0f) * this._stdSize)
			)
		);
		sensors.add ( // Sensor 3
			new Sensor (
				"S_3",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) - ((1.0f/2.0f) * this._stdSize) + ((1.0f/3.0f) * ((1.0f/2.0f) * this._stdSize))
			)
		);
		sensors.add ( // Sensor 4
			new Sensor (
				"S_4",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) - ((1.0f/2.0f) * this._stdSize) + ((2.0f/3.0f) * ((1.0f/2.0f) * this._stdSize))
			)
		);
		sensors.add ( // Sensor 5
			new Sensor (
				"S_5",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) + ((1.0f/2.0f) * this._stdSize)
			)
		);
		sensors.add ( // Sensor 6
			new Sensor (
				"S_6",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize) + ((1.0f/2.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) + this._stdSize - 15
			)
		);
	}
	public void setCoors (float xAxis, float yAxis) {
		this._xAxis = xAxis;
		this._yAxis = yAxis;
	}
	public void render () {
		for (Room _room : rooms) {
			_room.render ();
			_room.renderText ();
		}
		for (Sensor _sensor : sensors) {
			_sensor.render ();
			_sensor.renderText ();
		}
	}

	public float getWidth () {
		return (29.0f/10.0f) * this._stdSize;
	}
	public float getHeight () {
		return (3.0f/2.0f) * this._stdSize;
	}
}
public class Room {
	private float _xAxis;
	private float _yAxis;
	private float _roomWidth;
	private float _roomHeight;
	private String _name;

	public Room (String name, float xAxis, float yAxis, float roomWidth, float roomheight) {
		this._name       = name;
		this._xAxis      = xAxis;
		this._yAxis      = yAxis;
		this._roomWidth  = roomWidth;
		this._roomHeight = roomheight;
	}

	public void render () {
		rect (
			this._xAxis,
			this._yAxis,
			this._roomWidth,
			this._roomHeight
		);
	}
	public void renderText () {
		text (
			this._name,
			this._xAxis + 2,
			this._yAxis + this._roomHeight - 2
		);
	}
}
public class Sensor {
	private float _xAxis;
	private float _yAxis;
	private String _ID;

	public Sensor (String ID, float xAxis, float yAxis) {
		this._xAxis = xAxis;
		this._yAxis = yAxis;
		this._ID    = ID;
	}

	public void render () {
		rect (
			this._xAxis,
			this._yAxis,
			15,
			15
		);
	}
	public void renderText () {
		text (
			this._ID,
			this._xAxis + 2 + 15,
			this._yAxis - 2 + 15 - 2
		);
	}
}
/* =========================================================
 * ====                   WARNING                        ===
 * =========================================================
 * The code in this tab has been generated from the GUI form
 * designer and care should be taken when editing this file.
 * Only add/edit code inside the event handlers i.e. only
 * use lines between the matching comment tags. e.g.

 void myBtnEvents(GButton button) { //_CODE_:button1:12356:
     // It is safe to enter your event code here  
 } //_CODE_:button1:12356:
 
 * Do not rename this tab!
 * =========================================================
 */

public void MenuButton_click(GImageButton source, GEvent event) { //_CODE_:menuButton:752145:
  println("imgButton1 - GImageButton >> GEvent." + event + " @ " + millis());
} //_CODE_:menuButton:752145:



// Create all the GUI controls. 
// autogenerated do not edit
public void createGUI(){
  G4P.messagesEnabled(false);
  G4P.setGlobalColorScheme(GCScheme.BLUE_SCHEME);
  G4P.setCursor(ARROW);
  surface.setTitle("Sketch Window");
  menuButton = new GImageButton(this, 16, 400, 64, 64, new String[] { "icon-cog.png", "icon-cog.png", "icon-cog.png" } );
  menuButton.addEventHandler(this, "MenuButton_click");
  fireAlarmLabel = new GLabel(this, 96, 320, 144, 64);
  fireAlarmLabel.setText("Fire Alarm");
  fireAlarmLabel.setTextBold();
  fireAlarmLabel.setOpaque(true);
  modeLabel = new GLabel(this, 96, 400, 144, 64);
  modeLabel.setText("Cold / Hot Mode");
  modeLabel.setTextBold();
  modeLabel.setOpaque(true);
  machineFailureLabel = new GLabel(this, 256, 320, 144, 64);
  machineFailureLabel.setText("Machine failure");
  machineFailureLabel.setTextBold();
  machineFailureLabel.setOpaque(true);
  fanLablel = new GLabel(this, 256, 400, 144, 64);
  fanLablel.setText("Fan");
  fanLablel.setTextBold();
  fanLablel.setOpaque(true);
  airTemperatureLabel = new GLabel(this, 416, 320, 144, 64);
  airTemperatureLabel.setText("Air temperature");
  airTemperatureLabel.setTextBold();
  airTemperatureLabel.setOpaque(true);
  compressorLabel = new GLabel(this, 416, 400, 64, 64);
  compressorLabel.setText("Compressor");
  compressorLabel.setTextBold();
  compressorLabel.setOpaque(true);
  injectorValveLabel = new GLabel(this, 496, 400, 64, 64);
  injectorValveLabel.setText("Injector");
  injectorValveLabel.setTextBold();
  injectorValveLabel.setOpaque(true);
  sensorTemperatureLabel1 = new GLabel(this, 704, 16, 80, 32);
  sensorTemperatureLabel1.setText("24.0 \u00b0C");
  sensorTemperatureLabel1.setTextBold();
  sensorTemperatureLabel1.setOpaque(true);
  sensorTemperatureLabel2 = new GLabel(this, 704, 64, 80, 32);
  sensorTemperatureLabel2.setText("24.0 \u00b0C");
  sensorTemperatureLabel2.setTextBold();
  sensorTemperatureLabel2.setOpaque(true);
  sensorTemperatureLabel3 = new GLabel(this, 704, 112, 80, 32);
  sensorTemperatureLabel3.setText("24.0 \u00b0C");
  sensorTemperatureLabel3.setTextBold();
  sensorTemperatureLabel3.setOpaque(true);
  sensorTemperatureLabel4 = new GLabel(this, 704, 160, 80, 32);
  sensorTemperatureLabel4.setText("24.0 \u00b0C");
  sensorTemperatureLabel4.setTextBold();
  sensorTemperatureLabel4.setOpaque(true);
  sensorTemperatureLabel5 = new GLabel(this, 704, 208, 80, 32);
  sensorTemperatureLabel5.setText("24.0 \u00b0C");
  sensorTemperatureLabel5.setTextBold();
  sensorTemperatureLabel5.setOpaque(true);
  sensorTemperatureLabel6 = new GLabel(this, 704, 256, 80, 32);
  sensorTemperatureLabel6.setText("24.0 \u00b0C");
  sensorTemperatureLabel6.setTextBold();
  sensorTemperatureLabel6.setOpaque(true);
  sensorLabel1 = new GLabel(this, 608, 16, 80, 32);
  sensorLabel1.setText("Sensor #1");
  sensorLabel1.setTextBold();
  sensorLabel1.setOpaque(true);
  sensorLabel2 = new GLabel(this, 608, 64, 80, 32);
  sensorLabel2.setText("Sensor #2");
  sensorLabel2.setTextBold();
  sensorLabel2.setOpaque(true);
  sensorLabel3 = new GLabel(this, 608, 112, 80, 32);
  sensorLabel3.setText("Sensor #3");
  sensorLabel3.setTextBold();
  sensorLabel3.setOpaque(true);
  sensorLabel4 = new GLabel(this, 608, 160, 80, 32);
  sensorLabel4.setText("Sensor #4");
  sensorLabel4.setTextBold();
  sensorLabel4.setOpaque(true);
  sensorLabel5 = new GLabel(this, 608, 208, 80, 32);
  sensorLabel5.setText("Sensor #5");
  sensorLabel5.setTextBold();
  sensorLabel5.setOpaque(true);
  sensorLabel6 = new GLabel(this, 608, 256, 80, 32);
  sensorLabel6.setText("Sensor #6");
  sensorLabel6.setTextBold();
  sensorLabel6.setOpaque(true);
  ventLabel1 = new GLabel(this, 576, 320, 96, 32);
  ventLabel1.setText("vent #1 colsed");
  ventLabel1.setTextBold();
  ventLabel1.setOpaque(true);
  ventLabel2 = new GLabel(this, 576, 368, 96, 32);
  ventLabel2.setText("vent #2 colsed");
  ventLabel2.setTextBold();
  ventLabel2.setOpaque(true);
  ventLabel3 = new GLabel(this, 576, 416, 96, 32);
  ventLabel3.setText("vent #3 colsed");
  ventLabel3.setTextBold();
  ventLabel3.setOpaque(true);
  ventLabel4 = new GLabel(this, 688, 320, 96, 32);
  ventLabel4.setText("vent #4 colsed");
  ventLabel4.setTextBold();
  ventLabel4.setOpaque(true);
  ventLabel5 = new GLabel(this, 688, 368, 96, 32);
  ventLabel5.setText("vent #5 colsed");
  ventLabel5.setTextBold();
  ventLabel5.setOpaque(true);
  ventLabel6 = new GLabel(this, 688, 416, 96, 32);
  ventLabel6.setText("vent #6 colsed");
  ventLabel6.setTextBold();
  ventLabel6.setOpaque(true);
}

// Variable declarations 
// autogenerated do not edit
GImageButton menuButton; 
GLabel fireAlarmLabel; 
GLabel modeLabel; 
GLabel machineFailureLabel; 
GLabel fanLablel; 
GLabel airTemperatureLabel; 
GLabel compressorLabel; 
GLabel injectorValveLabel; 
GLabel sensorTemperatureLabel1; 
GLabel sensorTemperatureLabel2; 
GLabel sensorTemperatureLabel3; 
GLabel sensorTemperatureLabel4; 
GLabel sensorTemperatureLabel5; 
GLabel sensorTemperatureLabel6; 
GLabel sensorLabel1; 
GLabel sensorLabel2; 
GLabel sensorLabel3; 
GLabel sensorLabel4; 
GLabel sensorLabel5; 
GLabel sensorLabel6; 
GLabel ventLabel1; 
GLabel ventLabel2; 
GLabel ventLabel3; 
GLabel ventLabel4; 
GLabel ventLabel5; 
GLabel ventLabel6; 
  public void settings() { 	size       (800, 480, JAVA2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Temperature_controler_2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
