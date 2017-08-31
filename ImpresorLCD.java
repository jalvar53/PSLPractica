public class ImpresorLCD {

    private LCDGridCreator gridCreator;
    
    public ImpresorLCD() {
    	this.gridCreator = new LCDGridCreator();
    }
    
    
    private void addFixedPoints(char[] digits, int space) {
    	for (char digitChar : digits) {
    		int number = Validator.validateInputCharacter(digitChar);
            gridCreator.setFixedPoints(space);
            gridCreator.addDigit(number);
        }
    }  
    
    private void printLCDNumber(int rowTotal, int colTotal, String[][] matrizImpr) {
    	for (int i = 0; i < rowTotal; i++) {
            for (int j = 0; j < colTotal; j++) {
                System.out.print(matrizImpr[i][j]);
            }
            System.out.println();
        }
    }
    
    private void imprimirNumero(int numbersSize, String numbersToPrint, int spaceBetweenDigits) 
    {
        char[] digits = numbersToPrint.toCharArray();;
        gridCreator.setUpPrintingSpace(numbersSize, numbersToPrint, spaceBetweenDigits);
        int rowTotal = gridCreator.getRowTotal();
        int colTotal = gridCreator.getColTotal();
        gridCreator.initializeSegmentsMatrix(rowTotal, colTotal);
        addFixedPoints(digits, spaceBetweenDigits);
        printLCDNumber(rowTotal, colTotal, gridCreator.getSegmentsToPrint());
    }
    
    public void procesar(String comando, int spaceBetweenDigits) {
        
        String[] parameters;
        Validator.validateInputFormat(comando);
        parameters = comando.split(",");        
        Validator.validateParametersInputLenght(parameters);
        int number = Validator.validateInput(parameters);
        imprimirNumero(number, parameters[1], spaceBetweenDigits);
    }

}
