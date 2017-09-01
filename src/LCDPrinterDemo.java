package src;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDPrinterDemo {

    static final String ENDING_STRING = "0,0";
    
    private  static List<String> commandList = new ArrayList<>();
    private static String userInput;
    private static int spaceBetweenDigits;
    
    public static void main(String[] args) {
        try {
            keyboardScannerSetup();    
            startPrinter();
        } catch (Exception ex) {
            System.out.println("Error: "+ex.getMessage());
        }

    }
    
    private static void keyboardScannerSetup() {
    	try (Scanner lector = new Scanner(System.in)) {                
            System.out.print("Espacio entre Digitos (0 a 5): ");
            userInput = lector.next();                
            spaceBetweenDigits = Validator.validateSpaceBetweenDigits(userInput);                
            commandList = readUserInput(commandList, lector);
        } catch (Exception ex) {
        	System.out.print("Error: " + ex.getMessage());
        }        
    }
    
    private static List<String> readUserInput(List<String> commandList, Scanner lector) {
        do
        {
            System.out.print("Entrada: ");
            userInput = lector.next();
            if(!userInput.equalsIgnoreCase(ENDING_STRING))
            {
                commandList.add(userInput);
            }
        }
        while (!userInput.equalsIgnoreCase(ENDING_STRING)); 
        return commandList;
    }
    
    private static void startPrinter() {
        LCDPrinter lcdPrinter = new LCDPrinter();
        Iterator<String> iterator = commandList.iterator();

        while (iterator.hasNext()) 
        {
            try 
            {
                lcdPrinter.proccessUserInput(iterator.next(), spaceBetweenDigits);
            } catch (Exception ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        }
    }

}
