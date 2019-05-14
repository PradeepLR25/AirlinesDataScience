import java.util.ArrayList;
import java.util.HashMap;


public class QuestionsToAnswer {


	
	//Method to determine the airline that has the greatest number of cancelled flights.
	public String greatestCancelledFlights(ArrayList<String> AirlineID, ArrayList<String> CancellationCol) {
		//stores number of cancelled flights and total flights for particular airline
		ArrayList<Integer> CancelCount = new ArrayList<Integer>();
		ArrayList<Integer> TotalCount = new ArrayList<Integer>();
		//stores unique Airline codes, index matches cancel and total count.
		ArrayList<String> uniqueAirlineCarrier = new ArrayList<String>();
		for(int i=0; i<AirlineID.size(); i++) {
			//checks to see if a flight is cancelled
			if (Integer.parseInt(CancellationCol.get(i)) != 0) {
				if(uniqueAirlineCarrier.contains(AirlineID.get(i))){
					//if cancelled and added to uniqueAirlinesCarrier array, adds one to 
					//total and cancel count, otherwise adds only to cancelled count
					int idx = uniqueAirlineCarrier.indexOf(AirlineID.get(i));
					CancelCount.set(idx, CancelCount.get(idx) + 1);
					TotalCount.set(idx, TotalCount.get(idx) + 1);
				}else {
					
					CancelCount.add(1);
					TotalCount.add(0);
					uniqueAirlineCarrier.add(AirlineID.get(i));
				}	
			//if not cancelled only adds to Total
			}else {
				if(uniqueAirlineCarrier.contains(AirlineID.get(i))){
					int idx = uniqueAirlineCarrier.indexOf(AirlineID.get(i));
					TotalCount.set(idx, TotalCount.get(idx) + 1);
				}else {
					CancelCount.add(0);
					TotalCount.add(1);
					uniqueAirlineCarrier.add(AirlineID.get(i));
				}
				
			}
			
		}
		//calculates the ratio of cancelled flights to total flights.
		ArrayList<Double> ratio = new ArrayList<Double>();
		for(int j = 0; j<TotalCount.size(); j++) {
			ratio.add((CancelCount.get(j)*1.0)/(TotalCount.get(j)*1.0));
		}
		int idx = 0;
		double max = ratio.get(0);
		//gets largest ratio size, did not use "frequently used methods" because it is a double.
		for(int k = 0; k<ratio.size(); k++){
			if(ratio.get(k) > max) {
				max = ratio.get(k);
				idx = k;
			}
		}
		return (uniqueAirlineCarrier.get(idx) +(",") + (ratio.get(idx)*100))+"%";
	}
	
	
	//Determines the reason for cancelled flights.
	public String reasonforCancellation(ArrayList<String> flightData) {
		FrequentlyUsedMethods MaxMethod = new FrequentlyUsedMethods();
		String oneLetterCode = "";
		ArrayList<String> uniqueCharacter = new ArrayList<String>();
		ArrayList<Integer> countUniqueCharacter = new ArrayList<Integer>();
		for(int i=0; i<flightData.size();i++) {
			if(!flightData.get(i).trim().isEmpty()) {
				if(uniqueCharacter.contains(flightData.get(i))){
					int idx = uniqueCharacter.indexOf(flightData.get(i));
					countUniqueCharacter.set(idx, countUniqueCharacter.get(idx)+1);
				}else {
					uniqueCharacter.add(flightData.get(i));
					countUniqueCharacter.add(1);
				}	
			}	
		}
		//sends counts to max method, and retrieves index, 
		//then uses that index to get the largest value
		int idx = MaxMethod.MaxMethod(countUniqueCharacter);
		oneLetterCode = uniqueCharacter.get(idx);
		return oneLetterCode;
	}
	
	
	//calculates furthest miles flown for an airline
	public String furthestMilesTailNum(ArrayList<String> TailNumber, ArrayList<String> CancelledFlight, ArrayList<String> Distance) {
		FrequentlyUsedMethods MaxMethod = new FrequentlyUsedMethods();
		ArrayList<String> uniqueTailNumber = new ArrayList<String>();
		ArrayList<Integer> distanceForTail = new ArrayList<Integer>();
		for(int i = 0; i<TailNumber.size(); i++) {
			if(Integer.parseInt(CancelledFlight.get(i)) == 0) {
				if(uniqueTailNumber.contains(TailNumber.get(i))) {
					int idx = uniqueTailNumber.indexOf(TailNumber.get(i));
					distanceForTail.set(idx, distanceForTail.get(idx) + Integer.parseInt(Distance.get(i)));
				}
				else {
					uniqueTailNumber.add(TailNumber.get(i));
					distanceForTail.add(Integer.parseInt(Distance.get(i)));
				}
			}
		}
		int idx = MaxMethod.MaxMethod(distanceForTail);
		return uniqueTailNumber.get(idx);
	}
	
	
	//determines the busiest airport based on departues and arrivals
	//adds one or subtracts one depending on if there is a departure or arrival
	public String busiestAirport(ArrayList<String> OriginID, ArrayList<String> DestinationID, ArrayList<String> CancelledFlights) {
		FrequentlyUsedMethods MaxMethod = new FrequentlyUsedMethods();
		ArrayList<String> uniqueAirportID = new ArrayList<String>();
		ArrayList<Integer> uniqueAirportIDCount = new ArrayList<Integer>();
		for(int i = 0; i<OriginID.size(); i++) {
			if(Integer.parseInt(CancelledFlights.get(i)) == 0) {
				if(uniqueAirportID.contains(DestinationID.get(i))){
					int idx1 = uniqueAirportID.indexOf(DestinationID.get(i));
					uniqueAirportIDCount.set(idx1, uniqueAirportIDCount.get(idx1) + 1);
				}else {
					uniqueAirportID.add(DestinationID.get(i));
					uniqueAirportIDCount.add(1);
				} 
					
				if(uniqueAirportID.contains(OriginID.get(i))) {
					int idx2 = uniqueAirportID.indexOf(OriginID.get(i));
					uniqueAirportIDCount.set(idx2, uniqueAirportIDCount.get(idx2) + 1);
				}else {
					uniqueAirportID.add(OriginID.get(i));
					uniqueAirportIDCount.add(1);
				}
			}
		}
		int idx = MaxMethod.MaxMethod(uniqueAirportIDCount);
		return uniqueAirportID.get(idx);
		
	}
	
	
	//Determines the greatest source or sink for an airplane. a 1 is entered as an argument
	//to return the max value, where any other integer is use to return minimum (sink) value.
	public String largestSource(ArrayList<String> DepartureID, ArrayList<String> OriginID, ArrayList<String> CancelledFlights, int MinMax) {
		FrequentlyUsedMethods MaxMethod = new FrequentlyUsedMethods();
		ArrayList<String> uniqueAirportID = new ArrayList<String>();
		ArrayList<Integer> sourceValue = new ArrayList<Integer>();
		for(int i = 0 ; i<DepartureID.size(); i++) {
			if(Integer.parseInt(CancelledFlights.get(i)) == 0) {
				if(uniqueAirportID.contains(DepartureID.get(i))) {
					int idx1 = uniqueAirportID.indexOf(DepartureID.get(i));
					sourceValue.set(idx1, sourceValue.get(idx1) + 1);
				}else {
					uniqueAirportID.add(DepartureID.get(i));
					sourceValue.add(1);
				}
				if(uniqueAirportID.contains(OriginID.get(i))) {
					int idx2 = uniqueAirportID.indexOf(OriginID.get(i));
					sourceValue.set(idx2, sourceValue.get(idx2) - 1);
				}else {
					uniqueAirportID.add(OriginID.get(i));
					sourceValue.add(-1);
				}
			}
		}
		if(MinMax == 1) {
			int idx = MaxMethod.MaxMethod(sourceValue);
		 	return uniqueAirportID.get(idx);
		}else {
			int idx = MaxMethod.MinMethod(sourceValue);
			return uniqueAirportID.get(idx);
		}
	}
	public int AADelayCount(ArrayList<String> UniqueCarrier, ArrayList<String> DepartureDelay, ArrayList<String> ArrivalDelay, ArrayList<String> CancelledFlights, ArrayList<String> DivertedFlights) {
		int count = 0;
		for(int i = 0; i<UniqueCarrier.size(); i++) {
			if(UniqueCarrier.get(i).contentEquals("AA")) {
				if(Integer.parseInt(CancelledFlights.get(i)) == 0 && Integer.parseInt(DivertedFlights.get(i)) == 0) {
					if(Integer.parseInt(DepartureDelay.get(i)) >= 60 || Integer.parseInt(ArrivalDelay.get(i)) >= 60) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	
	//Determines the day of month, amount of departure delay and the tailID of the plane
	public String largestMakeUpTime(ArrayList<String> DepartureDelay, ArrayList<String> ArrivalDelay, ArrayList<String> DayOfMonth, ArrayList<String> TailNum, ArrayList<String> DivertedFlights, ArrayList<String> CancelledFlights) {
		FrequentlyUsedMethods MaxMethod = new FrequentlyUsedMethods();
		ArrayList<String> TailID = new ArrayList<String>();
		ArrayList<Integer> Departure = new ArrayList<Integer>();
		ArrayList<String> DayofM = new ArrayList<String>();
//		ArrayList<Integer> sourceValue = new ArrayList<Integer>();
		for(int i =0; i<DepartureDelay.size(); i++) {
			if(Integer.parseInt(CancelledFlights.get(i)) == 0 && Integer.parseInt(DivertedFlights.get(i)) == 0) {
				if(Integer.parseInt(DepartureDelay.get(i)) > 0 && Integer.parseInt(ArrivalDelay.get(i)) <= 0){
					TailID.add(TailNum.get(i));
					Departure.add(Integer.parseInt(DepartureDelay.get(i)));
					DayofM.add(DayOfMonth.get(i));
				}
			}
		}
		int idx = MaxMethod.MaxMethod(Departure);
		return (DayofM.get(idx) + "," + Departure.get(idx) + "," + TailID.get(idx));
	}
	
	
	//Determines the greatest and smaller number of flights that depart from all airports
	public String questionNine(ArrayList<String> OriginID, ArrayList<String> CancelledCol) {
		FrequentlyUsedMethods MaxMethod = new FrequentlyUsedMethods();
		ArrayList<String> uniqueID = new ArrayList<String>();
		ArrayList<Integer> countOfAirportID = new ArrayList<Integer>();
		for(int i=0; i<OriginID.size(); i++) {
			if(Integer.parseInt(CancelledCol.get(i)) == 0) {
				if(uniqueID.contains(OriginID.get(i))){
					int idx1 = uniqueID.indexOf(OriginID.get(i));
					countOfAirportID.set(idx1, countOfAirportID.get(idx1) + 1);
				}else{
					countOfAirportID.add(1);
					uniqueID.add(OriginID.get(i));
				}
			}
		}
		int idx = MaxMethod.MaxMethod(countOfAirportID);
		int idx2 = MaxMethod.MinMethod(countOfAirportID);
		return ("Which airport has the most and least number of flights departing?"+";Largest:"+uniqueID.get(idx)+"count:"+countOfAirportID.get(idx)+"Smallest:"+uniqueID.get(idx2)+"count:"+countOfAirportID.get(idx2));	
	}
}



