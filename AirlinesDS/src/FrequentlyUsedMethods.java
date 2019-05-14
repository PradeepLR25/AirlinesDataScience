import java.util.ArrayList;
import java.util.HashMap;

public class FrequentlyUsedMethods {

	
	//method to determine index of array containing max value
	public int MaxMethod(ArrayList<Integer> IntegerArray) {
		int idx = 0;
		int max = 0;
		for(int j=0; j<IntegerArray.size(); j++) {
			if(IntegerArray.get(j)>max) {
				idx = j;
				max = IntegerArray.get(j);
			}else {
				continue;
			}
		}
		return idx;
	
	}
	//method to determine index of array containing min value
	public int MinMethod(ArrayList<Integer> IntegerArray) {
		int idx = 0;
		int min = IntegerArray.get(0);
		for(int j=0; j<IntegerArray.size(); j++) {
			if(IntegerArray.get(j)<min) {
				idx = j;
				min = IntegerArray.get(j);
			}else {
				continue;
			}
		}
		return idx;
	
	}
	
	
	
}
