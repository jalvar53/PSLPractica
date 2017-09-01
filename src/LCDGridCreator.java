package src;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LCDGridCreator {
	
	static final String VERTICAL_CHAR = "|";
    static final String HORIZONTAL_CHAR = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";
	
    private final int[] fixedPoint1;
    private final int[] fixedPoint2;
    private final int[] fixedPoint3;
    private final int[] fixedPoint4;
    private final int[] fixedPoint5;
    
    private String[][] segmentsToPrint;
        
    private int pivotX;
    private int size;

    private int columnsPerDigit;
    private int rowTotal;
    private int colTotal;
    
    public LCDGridCreator() {
    	this.fixedPoint1 = new int[2];
        this.fixedPoint2 = new int[2];
        this.fixedPoint3 = new int[2];
        this.fixedPoint4 = new int[2];
        this.fixedPoint5 = new int[2];
    }
    
    public void setUpPrintingSpace(int size, String numberToPrint, int espacio) {
        setSize(size);
        setRowTotal();
        setColumnsPerDigit();
        setColTotal(numberToPrint, espacio);
    }
    
    public void addDigit(int number) {
        List<Integer> segList = new ArrayList<>();        
        segList = SegmentNumberMaker.createSegmentNumber(segList, number);
        Iterator<Integer> iterator = segList.iterator();

        while (iterator.hasNext()) {
            addSegment(iterator.next());
        }
    }
    
    private void addSegment(int segmento) {
        switch (segmento) {
            case 1:
                addLine(this.segmentsToPrint, fixedPoint1, POSICION_Y,
                        this.size, VERTICAL_CHAR);
                break;
            case 2:
                addLine(this.segmentsToPrint, fixedPoint2, POSICION_Y,
                		this.size, VERTICAL_CHAR);
                break;
            case 3:
                addLine(this.segmentsToPrint, fixedPoint5, POSICION_Y,
                		this.size, VERTICAL_CHAR);
                break;
            case 4:
                addLine(this.segmentsToPrint, fixedPoint4, POSICION_Y,
                		this.size, VERTICAL_CHAR);
                break;
            case 5:
                addLine(this.segmentsToPrint, fixedPoint1, POSICION_X,
                		this.size, HORIZONTAL_CHAR);
                break;
            case 6:
                addLine(this.segmentsToPrint, fixedPoint2, POSICION_X,
                		this.size, HORIZONTAL_CHAR);
                break;
            case 7:
                addLine(this.segmentsToPrint, fixedPoint3, POSICION_X,
                		this.size, HORIZONTAL_CHAR);
                break;
            default:
                break;
        }
    }
    
    private void addLine(String[][] segmentsToPrint, int[] fixedPoint, String fixedPosition,
            int segmentSize, String character) {
    	
        if (fixedPosition.equalsIgnoreCase(POSICION_X)) {
            for (int y = 1; y <= segmentSize; y++) 
            {
                int valor = fixedPoint[1] + y;
                segmentsToPrint[fixedPoint[0]][valor] = character;
            }
        } 
        else {       	
            for (int i = 1; i <= segmentSize; i++) 
            {            	
                int valor = fixedPoint[0] + i;
                segmentsToPrint[valor][fixedPoint[1]] = character;
            }
        }
    }
    
    public void initializeSegmentsMatrix(int rowTotal, int colTotal) {
    	this.segmentsToPrint = new String[rowTotal][colTotal];
    	for (int i = 0; i < rowTotal; i++) {
            for (int j = 0; j < colTotal; j++) {
                this.segmentsToPrint[i][j] = " ";
            }
        }
    }
    
    public void setFixedPoints(int space) {
    	setFixedPoint1();
    	setFixedPoint2();
    	setFixedPoint3();
    	setFixedPoint4();
    	setFixedPoint5();           
        setPivotX(space);
    }
    
    void setFixedPoint1() {
    	this.fixedPoint1[0] = 0;
        this.fixedPoint1[1] = 0 + this.pivotX;
    }
    
    void setFixedPoint2() {
        this.fixedPoint2[0] = (this.rowTotal / 2);
        this.fixedPoint2[1] = 0 + this.pivotX;
    }
    
    void setFixedPoint3() {
    	this.fixedPoint3[0] = (this.rowTotal - 1);
        this.fixedPoint3[1] = 0 + this.pivotX;
    }
    
    void setFixedPoint4() {
    	 this.fixedPoint4[0] = (this.columnsPerDigit - 1);
         this.fixedPoint4[1] = (this.rowTotal / 2) + this.pivotX;
    }
    
    void setFixedPoint5() {
    	this.fixedPoint5[0] = 0;
        this.fixedPoint5[1] = (this.columnsPerDigit - 1) + this.pivotX;
    }
    
    void setPivotX(int space) {
    	this.pivotX = this.pivotX + this.columnsPerDigit + space;
    }
    
    public int[] getFixedPoint1() {
    	return this.fixedPoint1;
    }
    
    public int[] getFixedPoint2() {
    	return this.fixedPoint2;
    }
    
    public int[] getFixedPoint3() {
    	return this.fixedPoint3;
    }
    
    public int[] getFixedPoint4() {
    	return this.fixedPoint4;
    }
    
    public int[] getFixedPoint5() {
    	return this.fixedPoint5;
    }

    void setSize(int size) {
    	this.size = size;
    }
    
    public int getSize() {
    	return this.size;
    }
    
    protected void setRowTotal() {
    	this.rowTotal = (2 * this.size) + 3;
    }
    
    public int getRowTotal() {
    	return this.rowTotal;
    }
    
    void setColumnsPerDigit() {
    	this.columnsPerDigit = this.size + 2;
    }
    
    public int getColumnsPerDigit() {
    	return this.columnsPerDigit;
    }
    
    void setColTotal(String numberToPrint, int espacio) {
    	this.colTotal = (this.columnsPerDigit * numberToPrint.length())
                + (espacio * numberToPrint.length());
    }
    
    public void setPivotXtoDefault() {
    	this.pivotX = 0;
    }
    
    public int getColTotal() {
    	return this.colTotal;
    }
    
    public String[][] getSegmentsToPrint() {
    	return this.segmentsToPrint;
    }

}
