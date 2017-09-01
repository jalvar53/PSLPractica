package src;
import java.util.List;

public class SegmentNumberMaker {
	
	static List<Integer> createSegmentNumber(List<Integer> segmentList, int number) {
		switch (number) {
	        case 1:
	        	segmentList = SegmentNumberMaker.makeNumberOne(segmentList);
	            break;
	        case 2:
	        	segmentList = SegmentNumberMaker.makeNumberTwo(segmentList);
	            break;
	        case 3:
	        	segmentList = SegmentNumberMaker.makeNumberThree(segmentList);
	            break;
	        case 4:
	        	segmentList = SegmentNumberMaker.makeNumberFour(segmentList);
	            break;
	        case 5:
	        	segmentList = SegmentNumberMaker.makeNumberFive(segmentList);
	            break;
	        case 6:
	        	segmentList = SegmentNumberMaker.makeNumberSix(segmentList);
	            break;
	        case 7:
	        	segmentList = SegmentNumberMaker.makeNumberSeven(segmentList);
	            break;
	        case 8:
	        	segmentList = SegmentNumberMaker.makeNumberEight(segmentList);
	            break;
	        case 9:
	        	segmentList = SegmentNumberMaker.makeNumberNine(segmentList);
	            break;
	        case 0:
	        	segmentList = SegmentNumberMaker.makeNumberZero(segmentList);
	            break;
	        default:
	            break;
		}
		return segmentList;
	}

	static List<Integer> makeNumberOne(List<Integer> segmentList) {
        segmentList.add(3);
        segmentList.add(4);
        return segmentList;
	}
	
	static List<Integer> makeNumberTwo(List<Integer> segmentList) {
        segmentList.add(5);
        segmentList.add(3);
        segmentList.add(6);
        segmentList.add(2);
        segmentList.add(7);
        return segmentList;
	}
	
	static List<Integer> makeNumberThree(List<Integer> segmentList) {
        segmentList.add(5);
        segmentList.add(3);
        segmentList.add(6);
        segmentList.add(4);
        segmentList.add(7);
        return segmentList;
	}
	
	static List<Integer> makeNumberFour(List<Integer> segmentList) {
        segmentList.add(1);
        segmentList.add(6);
        segmentList.add(3);
        segmentList.add(4);
        return segmentList;
	}
	
	static List<Integer> makeNumberFive(List<Integer> segmentList) {
        segmentList.add(5);
        segmentList.add(1);
        segmentList.add(6);
        segmentList.add(4);
        segmentList.add(7);
        return segmentList;
	}
	
	static List<Integer> makeNumberSix(List<Integer> segmentList) {
        segmentList.add(5);
        segmentList.add(1);
        segmentList.add(6);
        segmentList.add(2);
        segmentList.add(7);
        segmentList.add(4);
        return segmentList;
	}
	
	static List<Integer> makeNumberSeven(List<Integer> segmentList) {
        segmentList.add(5);
        segmentList.add(3);
        segmentList.add(4);
        return segmentList;
	}
	
	static List<Integer> makeNumberEight(List<Integer> segmentList) {
        segmentList.add(1);
        segmentList.add(2);
        segmentList.add(3);
        segmentList.add(4);
        segmentList.add(5);
        segmentList.add(6);
        segmentList.add(7);
        return segmentList;
	}
	
	static List<Integer> makeNumberNine(List<Integer> segmentList) {
        segmentList.add(1);
        segmentList.add(3);
        segmentList.add(4);
        segmentList.add(5);
        segmentList.add(6);
        segmentList.add(7);
        return segmentList;
	}
	
	static List<Integer> makeNumberZero(List<Integer> segmentList) {
        segmentList.add(1);
        segmentList.add(2);
        segmentList.add(3);
        segmentList.add(4);
        segmentList.add(5);
        segmentList.add(7);
        return segmentList;
	}
}
