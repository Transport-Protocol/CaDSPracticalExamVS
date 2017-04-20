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

public class Example1 {
    public static void main(String... args) throws IOException, ParseException{
        System.out.println("#############################");
        System.out.println("Start - IDL_Parser_Example_1.");
        System.out.println();
        
        // Read the whole Idl and print it.
        String fileName = "idl_examples/idls/example1_idl.json"; 
        System.out.println("::: read IDL from file: " + fileName + " :::");
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        
        String line = "";
        StringBuffer buffer = new StringBuffer();
        while((line = reader.readLine()) != null){
            buffer.append(line);
            buffer.append("\n");
        }
        
        reader.close();
        String jsonText = buffer.toString();
        System.out.println(jsonText);
        
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonText);
        String textToPrint = (String) json.get("text_to_print");
        System.out.println();
        
        // Read the whole plainText and print it.
        fileName = "idl_examples/plain_texts/example1_plain_text.txt"; 
        System.out.println("::: read plaintext from file: " + fileName + " :::");
        reader = new BufferedReader(new FileReader(new File(fileName)));
        
        line = "";
        buffer = new StringBuffer();
        while((line = reader.readLine()) != null){
            buffer.append(line);
            buffer.append("\n");
        }
        
        reader.close();
        System.out.println(buffer.toString());
        String plainText = buffer.toString();
        
        
        // Print to console and file. PlainText filled with String.format methode.
        System.out.println("::: Print the class file in src/cads/parser/generated:::");
        String classString = String.format(plainText, textToPrint);
        System.out.println(classString);
        
        fileName = "src/cads/parser/generated/Example1_Generated_File.java";
        PrintWriter writer = new PrintWriter(new FileWriter(new File(fileName)));
        
        writer.print(classString);
        writer.flush();
        writer.close();
        
        System.out.println();
        System.out.println("End - IDL_Parser_Example_1.");
        System.out.println("###########################");
    }
}
