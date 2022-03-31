import java.util.Arrays;

public class Decoding {
	private String binaryString;  
	private String[] splitBinaryArray;
	private String[] hexArray;
	private String translationResult;
	
	
	//constructor with single parameter:  your string of binary 
	public Decoding(String binaryString) {
	
		binaryString = binaryString.replaceAll("\\s+","");  //remove whitespace in the string
		this.binaryString = binaryString;
		this.splitBinaryArray = splitBinary(binaryString);
		this.hexArray = hexConversion(this.splitBinaryArray);
		this.translationResult = unicodeConversion(this.hexArray);
	}
	
	private String[] splitBinary(String binaryString){
		String[] splitBinaryArray;
		splitBinaryArray = binaryString.split("(?<=\\G.{8})");  //split string every 8 bits
		return splitBinaryArray;
				
	}
	
	private String[] hexConversion(String[] splitBinaryArray) {
		
		String[] hexArray= new String [splitBinaryArray.length];

		for (int i=0;i< splitBinaryArray.length;i++ ) {
			hexArray[i] = Integer.toHexString(Integer.parseInt(splitBinaryArray[i], 2));  //convert to hex
			
		}
			
		return hexArray;
	}
	private String unicodeConversion(String[] hexArray) {
		String report = "";
		for (int i= 0; i< hexArray.length; i++) {
			report = report + (char)Integer.parseInt(hexArray[i], 16);  //covert to character
			
		}
				
	return report;
	}

	@Override
	public String toString() {
		return "Decoding...\n binaryString=" + binaryString + ",\n splitBinaryArray=" + Arrays.toString(splitBinaryArray)
				+ ",\n hexArray=" + Arrays.toString(hexArray) + ",\n translationResult=" + translationResult;
	}
	
	
}
