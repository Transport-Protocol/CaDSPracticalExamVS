package cads.parser.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Example3 {
    public static void main(String... args) throws IOException, ParseException {
        System.out.println("#############################");
        System.out.println("Start - IDL_Parser_Example_3.");
        System.out.println();

        
        // Read IDL Example
        String fileName = "idl_examples/idls/example3_idl.json";
        System.out.println("::: read IDL from file: " + fileName + " :::");
        String jsonText = readEntirefile(fileName);
        System.out.println(jsonText);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonText);
        String textToPrint = (String) json.get("text_to_print");
        String objectName = (String) json.get("ServiceName");
        String methodeName = (String) json.get("Function");

        // Read Plain Text Class
        System.out.println();
        fileName = "idl_examples/plain_texts/example3_plain_text_class.txt";
        System.out.println("::: read plaintext class from file: " + fileName + " :::");

        String plainTextClass = readEntirefile(fileName);
        System.out.println(plainTextClass);
        
        // Read Plain Text Methode
        System.out.println();
        fileName = "idl_examples/plain_texts/example3_plain_text_methode.txt";
        System.out.println("::: read plaintext methode from file: " + fileName + " :::");

        String plainTextMethode = readEntirefile(fileName);
        System.out.println(plainTextMethode);

        // Generate Methode and Class Strings
        System.out.println("::: Generate the class files :::");
        String pathName = "cads.parser.generated";   
        
        System.out.println("Now generating : " + "Example3_" + objectName + ".java");
        String methodeString = String.format(plainTextMethode, methodeName, textToPrint);
        String classString = String.format(plainTextClass, pathName, ("Example3_" + objectName), methodeString);
        fileName = "src/cads/parser/generated/Example3_" +  objectName + ".java";
        PrintWriter writer = new PrintWriter(new FileWriter(new File(fileName)));

        writer.print(classString);
        writer.flush();
        writer.close();


        System.out.println();
        System.out.println("End - IDL_Parser_Example_3.");
        System.out.println("###########################");
    }

    private static String readEntirefile(String fileName) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));

        String line = "";
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append("\n");
        }

        reader.close();
        String jsonText = buffer.toString();
        return jsonText;
    }
}
