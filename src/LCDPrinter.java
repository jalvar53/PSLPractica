package src;
public class LCDPrinter {

    private LCDGridCreator gridCreator;
    
    public LCDPrinter() {
    	this.gridCreator = new LCDGridCreator();
    }
    
    public void proccessUserInput(String comando, int spaceBetweenDigits) {   
        String[] parameters;
        Validator.validateInputFormat(comando);
        parameters = comando.split(",");        
        Validator.validateParametersInputLenght(parameters);
        int number = Validator.validateInput(parameters);
        setupNumberToPrint(number, parameters[1], spaceBetweenDigits);
    }    
    
    private void setupNumberToPrint(int numbersSize, String numbersToPrint, int spaceBetweenDigits) {
    	gridCreator.setPivotXtoDefault();
        char[] digits = numbersToPrint.toCharArray();
        gridCreator.setUpPrintingSpace(numbersSize, numbersToPrint, spaceBetweenDigits);
        int rowTotal = gridCreator.getRowTotal();
        int colTotal = gridCreator.getColTotal();
        gridCreator.initializeSegmentsMatrix(rowTotal, colTotal);
        addFixedPoints(digits, spaceBetweenDigits);
        printLCDNumber(rowTotal, colTotal, gridCreator.getSegmentsToPrint());
    }
    
    private void addFixedPoints(char[] digits, int space) {
    	for (char digitChar : digits) {
    		int number = Validator.validateInputCharacter(digitChar);
            gridCreator.setFixedPoints(space);
            gridCreator.addDigit(number);
        }
    }  
    
    private void printLCDNumber(int rowTotal, int colTotal, String[][] segmentsToPrint) {
    	for (int i = 0; i < rowTotal; i++) {
            for (int j = 0; j < colTotal; j++) {
                System.out.print(segmentsToPrint[i][j]);
            }
            System.out.println();
        }
    }

}
