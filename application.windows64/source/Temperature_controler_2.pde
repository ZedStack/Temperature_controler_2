// Imports
import g4p_controls.*;
import processing.core.PApplet;

// Classes
Complex complex;
Dial dial;

public void buttonClick (GImageButton source, GEvent event) {
	println("source.tagNo: " + source.tagNo);
}
public void settingsGUI () {
	G4P.messagesEnabled      (false);
	G4P.setGlobalColorScheme (GCScheme.BLUE_SCHEME);
	G4P.setCursor            (ARROW);

	surface.setTitle         ("Temperaturew controler");

}
//- ## P R O C E S S I N G   S T A N D A R S ######################################################## -//
//- ################################################################################################# -//

void setup() {
	size       (800, 480, JAVA2D);
	noFill     ();
	stroke     (255);
	background (20);
	frameRate  (60);

	settingsGUI ();

	complex = new Complex ((1.0/4.0) * width);
	complex.setCoors      ((complex.getWidth () / 2) + 10, (complex.getHeight () / 2) + 10);
	complex.createRooms   ();
	complex.createSensors ();

	dial = new Dial    (this, width / 2.0, height / 2.0);
	dial.createButtons ();

	// complex.render ();
}

void draw() {
	// background(170);
	// complex.render ();
}

//- ## P R O C E S S I N G   S T A N D A R S ######################################################## -//
//- ################################################################################################# -//