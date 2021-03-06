package org.rapidpm.event.jcrete4kids.v002;

import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

/**
 * Created by svenruppert on 24.07.15.
 */
public class Main002 {

  private static final String HOST = "localhost";
  private static final int PORT = 4223;
  private static final String UID = "qoL"; // Change to your UID

  // Note: To make the example code cleaner we do not handle exceptions. Exceptions you
  //       might normally want to catch are described in the documentation
  public static void main(String args[]) throws Exception {
    IPConnection ipcon = new IPConnection(); // Create IP connection

    BrickletLCD20x4 lcd = new BrickletLCD20x4(UID, ipcon); // Create device object

    ipcon.connect(HOST, PORT); // Connect to brickd
    // Don't use device before ipcon is connected

    // Turn backlight on
    lcd.backlightOn();

    // Write "Hello World"
    lcd.writeLine((short)0, (short)0, "Hello World");

    System.out.println("Press key to exit"); System.in.read();
    ipcon.disconnect();
  }
}
