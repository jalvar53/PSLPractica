public class Validator {

	static void validateInputFormat(String userInput) {
    	if (!userInput.contains(",")) {
            throw new IllegalArgumentException("Cadena " + userInput
                    + " no contiene caracter ,");
        }
    }
    
    static void validateParametersInputLenght(String[] parameters) {
    	if(parameters.length>2){
           throw new IllegalArgumentException("Cadena " + parameters
                    + " contiene mas caracter ,"); 
        }
    	else if(parameters.length<2) {
           throw new IllegalArgumentException("La cadena no contiene los parametros requeridos"); 
        }
    }
    
    static int validateInput(String[] parameters) {
    	int number;
    	if(isNumeric(parameters[0])) {
            number = Integer.parseInt(parameters[0]);
            if(number <1 || number >10) {
                throw new IllegalArgumentException("El parametro size ["+number
                        + "] debe estar entre 1 y 10");
            }
        }
        else {
            throw new IllegalArgumentException("Parametro Size [" + parameters[0]
                    + "] no es un numero");
        }
    	return number;
    }
    
    static int validateInputCharacter(char digitChar) {
        if(!Character.isDigit(digitChar))
        {
            throw new IllegalArgumentException("Caracter " + digitChar
                + " no es un digito");
        }
        int number = Integer.parseInt(String.valueOf(digitChar));
        return number;
    }
    
    static int validateSpaceBetweenDigits(String userInput) {
        int spaceBetweenDigits;
        
        if (Validator.isNumeric(userInput)) {
            spaceBetweenDigits = Integer.parseInt(userInput);
            
            if(spaceBetweenDigits <0 || spaceBetweenDigits >5) {
                throw new IllegalArgumentException("El espacio entre "
                        + "digitos debe estar entre 0 y 5");
            }
        } 
        else {
            throw new IllegalArgumentException("Cadena " + userInput
                    + " no es un entero");
        }
        
        return spaceBetweenDigits;
    }
    
    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
