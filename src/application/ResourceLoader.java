package application;

import java.io.InputStream;

/**
 * ResourceLoader is to load the resource from source folder to the project.
 * 
 * @author Visurt Anuttivong
 */
final public class ResourceLoader {

	/**
	 * Load file from the resource.
	 * 
	 * @param path is the path of folder
	 * @return InputStrem
	 */
	public static InputStream load(String path) {
		InputStream input = ResourceLoader.class.getResourceAsStream(path);
		if (input == null) {
			input = ResourceLoader.class.getResourceAsStream("/" + path);
		}
		return input;
	}
}
