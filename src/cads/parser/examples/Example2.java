package cads.parser.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Example2 {
    public static void main(String... args) throws IOException, ParseException {
        System.out.println("#############################");
        System.out.println("Start - IDL_Parser_Example_2.");
        System.out.println();

        String fileName = "idl_examples/idls/example2_idl.json";
        System.out.println("::: read IDL from file: " + fileName + " :::");
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));

        String line = "";
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append("\n");
        }

        reader.close();
        String jsonText = buffer.toString();
        System.out.println(jsonText);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonText);
        String textToPrint = (String) json.get("text_to_print");
        String className = (String) json.get("name");

        System.out.println();
        System.out.println("");
        fileName = "idl_examples/plain_texts/example2_plain_text.txt";
        System.out.println("::: read plaintext from file: " + fileName + " :::");
        reader = new BufferedReader(new FileReader(new File(fileName)));

        line = "";
        buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append("\n");
        }

        reader.close();

        String plainText = buffer.toString();
        System.out.println(plainText);

        System.out.println("::: Generate the class files :::");
        String pathName = "cads.parser.generated";   
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Now generating : Example2_" + className + i + ".java");
            String classString = String.format(plainText, pathName, ("Example2_" + className + i), textToPrint);
            fileName = "src/cads/parser/generated/Example2_" + className + i + ".java";
            PrintWriter writer = new PrintWriter(new FileWriter(new File(fileName)));

            writer.print(classString);
            writer.flush();
            writer.close();
        }

        System.out.println();
        System.out.println("End - IDL_Parser_Example_2.");
        System.out.println("###########################");
    }
}
