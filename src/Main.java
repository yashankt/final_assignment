import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void setLogger() {
        try {
            //Setting up the logger
            LogManager.getLogManager().reset();
            logger.setLevel(Level.ALL);

            FileHandler fileHandler = new FileHandler("my_logs.log", true);
            fileHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            Main.setLogger();

            //Creating the Properties object with no default values
            Properties properties = new Properties();

            //Creating an object of FileReader to read the properties from the properties file
            FileReader reader = new FileReader("details.properties");
            properties.load(reader);

            //Fetching the path of the file and the word from the properties file
            String filePath = properties.getProperty("path");
            String findWord = properties.getProperty("word");
            logger.info("The path and the word are correctly fetched from the properties file.");

            //Creating a file pointer which is pointing on the file located at the given file path
            File file = new File(filePath);
            logger.info("The file pointer is created correctly.");

            //Creating a Scanner object for reading the file
            Scanner scan = new Scanner(file);
            logger.info("The scanner object is created correctly.");

            HashMap<String, Integer> map = new HashMap<>();
            logger.info("The hashmap has been created.");

            while (scan.hasNextLine()) {
                logger.info("Reading words");

                String[] words = scan.nextLine().split(" ");

                //Running a loop to put the words and their occurrences in the map
                for (String word : words) {
                    if (map.containsKey(word)) { //If the map contains that word then increase the count of that word
                        int count = map.get(word);
                        map.put(word, count + 1);
                    } else { //If the map does not contain that word then put that word in the map with the initial count of 1
                        map.put(word, 1);
                    }
                }
            }
            logger.info("Reading words is complete");

            if (findWord.length() == 0) { //If there is no word given, then print all the words with their occurrences
                for(Map.Entry<String, Integer> mapElement : map.entrySet()) {
                    System.out.println(mapElement.getKey() + " - " + mapElement.getValue());
                }
            } else { //If the word is given, then print the word with its occurrence
                System.out.println(findWord + " - " + map.getOrDefault(findWord, 0));
            }
        } catch (Exception e) { //Handling the exception
            System.out.println(e);
        }
    }
}
