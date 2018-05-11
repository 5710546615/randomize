# Randomize
***Object Oriented Programming II Course Project***

An application that used for randomness which has many uses in our life. <br /><br />
![main](https://i.imgur.com/rk7wo1z.png)

## Installation
Download [Randomize.jar](https://github.com/5710546615/randomize/blob/master/Randomize.jar?raw=true) and run it. <br />
&nbsp;&nbsp;&nbsp;&nbsp;or <br />
Download [randomize-master.zip](https://github.com/5710546615/randomize/archive/master.zip) and open in IDE complier

## Features
- [x] Random a number between minimum and maximum also no repeat
- [x] Random a playing card from the deck which has 52 cards
- [x] Random either YES or NO when you can't decide by yourself
- [x] Random a face dice(s) when you have no dice
- [x] Random either head or tail of coin(s)
- [x] Random the game of Rock-Paper-Scissors
- [x] Random Food when you're in Food On Demand
- [x] Random pick up something from a list also no repeat
- [x] Random rearrange something from a list

## Technology

### JavaFX
JavaFX is a Java library used to build Rich Internet Applications. The applications written using this library can run consistently across multiple platforms. The applications developed using JavaFX can run on various devices such as Desktop Computers, Mobile Phones, TVs, Tablets, etc.

### Scene Builder
JavaFX Scene Builder is a visual layout tool that lets users quickly design JavaFX application user interfaces, without coding. Users can drag and drop UI components to a work area, modify their properties, apply style sheets, and the FXML code for the layout that they are creating is automatically generated in the background. The result is an FXML file that can then be combined with a Java project by binding the UI to the application’s logic.

### Packing resources into jar file
Executable class from JAR file will read drive created inside virtual machine, not the physical drive in my computer. I pack it into JAR with absolute path. On execution JRE will create JVM with that path in it, take the images from JAR and put them to that virtual path. Class will be able to find them.
``` java
import java.io.InputStream;

public class ResourceLoader {
    public static InputStream load(String path) {
	InputStream input = ResourceLoader.class.getResourceAsStream(path);
	    if (input == null) {
		input = ResourceLoader.class.getResourceAsStream("/" + path);
	    }
	return input;
    }
}
```
### Using CSS in JavaFX
Cascading Style Sheets, also referred to as CSS, is a simple design language intended to simplify the process of making web pages presentable.
CSS handles the look and feel part of a web page. Using CSS, you can control the color of the text, style of fonts, spacing between paragraphs, size of columns and layout. Apart from these, you can also control the background images or colors that are used, layout designs, variations in display for different devices and screen sizes as well as a variety of other effects.
``` java
.root {
    -fx-background-image: url("../etc/background.png");
    -fx-background-repeat: stretch;   
    -fx-background-size: 600.0 400.0;
    -fx-background-position: center center;
}
```

## UML Diagram
![uml](https://i.imgur.com/tdMvkss.png)

## Contributor
Visurt Anuttivong ( @5710546615 )
