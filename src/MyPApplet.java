// Java program to demonstrate
// how to create an applet

import processing.core.PApplet;
import processing.core.PImage;


// Creating a class which extends
// the PApplet class
public class MyPApplet extends PApplet {

    // Defining the image
    PImage img;

    // The setup function will run once
    // and the draw function will run
    // repeatedly drawing the image
    // on the canvas.
    public void setup()
    {
        // Set the canvas width and height
        size(300, 300);

        // Set the canvas color
        background(255);

        // Set the pen color
        stroke(0);

        // Use any image from the internet
        // or PC
        // Here, the URL of the image is given
        img = loadImage("https://cdn.pixabay.com/photo/2014/06/03/19/38/road-sign-361513_640.jpg");

        // Resize the loaded image to
        // the full height of canvas
        img.resize(0, height);

        // Display the image
        image(img, 0, 0);
    }

    // This function is executed repeatedly
    public void draw()
    {
        // Calculate color code for the sun
        int[] color = sunColorSec(second());

        // Set the colour of the sun
        fill(color[0], color[1], color[2]);

        // Draw the sun
        ellipse(width / 4, height / 5,
                width / 4, height / 5);
    }

    // Function to return the RGB
    // color of the sun at the
    // number of seconds in the minute
    public int[] sunColorSec(float seconds)
    {
        int[] rgb = new int[3];

        // Scale the brightness of the
        // yellow based on the seconds.
        // 0 seconds is black and
        // 30 seconds is bright yellow.
        float diffFrom30
                = Math.abs(30 - seconds);

        // Assigning the ratio of
        // RGB in an array
        float ratio = diffFrom30 / 30;
        rgb[0] = (int)(255 * ratio);
        rgb[1] = (int)(255 * ratio);
        rgb[2] = 0;

        // Return the RGB
        return rgb;
    }

    // Driver code
    public static void main(String[] args)
    {

        PApplet.main(
                new String[] {
                        "--present",
                        "MyPApplet" });
    }
}
