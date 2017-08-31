import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    private  static List<String> listaComando = new ArrayList<>();
    private static String userInput;
    private static int spaceBetweenDigits;
    
    public static void main(String[] args) {
        try {
            try (Scanner lector = new Scanner(System.in)) {                
                System.out.print("Espacio entre Digitos (0 a 5): ");
                userInput = lector.next();                
                spaceBetweenDigits = Validator.validateSpaceBetweenDigits(userInput);                
                listaComando = readUserInput(listaComando, lector);
            } catch (Exception ex) {
            	System.out.print("Error: " + ex.getMessage());
            }            
            startPrinter();
        } catch (Exception ex) {
            System.out.println("Error: "+ex.getMessage());
        }

    }
    
    private static List<String> readUserInput(List<String> listaComando, Scanner lector) {
        do
        {
            System.out.print("Entrada: ");
            userInput = lector.next();
            if(!userInput.equalsIgnoreCase(CADENA_FINAL))
            {
                listaComando.add(userInput);
            }
        }
        while (!userInput.equalsIgnoreCase(CADENA_FINAL)); 
        return listaComando;
    }
    
    private static void startPrinter() {
        ImpresorLCD impresorLCD = new ImpresorLCD();
        Iterator<String> iterator = listaComando.iterator();
        while (iterator.hasNext()) 
        {
            try 
            {
                impresorLCD.procesar(iterator.next(), spaceBetweenDigits);
            } catch (Exception ex) {
                System.out.println("Error: "+ex.getMessage());                   
            }
        }
    }

}
