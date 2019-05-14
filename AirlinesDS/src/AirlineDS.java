import java.util.ArrayList;
import java.util.HashMap;

public class AirlineDS {
	
	public static HashMap<String, ArrayList<String>> AirlineData2 = new HashMap<String, ArrayList<String>>();
		
	//main method that runs file reader and data analysis.
	
	public static void main(String[] args) {
		ArrayList<String> answers = new ArrayList<String>();
		String Question1, Question2, Question3, Question4, Question5, Question6, Question8, Question9;
		int Question7;
		AirlineDataReader dataObj = new AirlineDataReader("flights.csv");
		FormattedOutput AnswerFile = new FormattedOutput();
		AirlineData2 = dataObj.getAirlineData();
		QuestionsToAnswer Question = new QuestionsToAnswer();
		Question1 = Question.greatestCancelledFlights(AirlineData2.get("UniqueCarrier"), AirlineData2.get("Cancelled"));
		AnswerFile.addAnswer(1, Question1);
		Question2 = Question.reasonforCancellation(AirlineData2.get("CancellationCode"));
		AnswerFile.addAnswer(2, Question2);
		Question3 = Question.furthestMilesTailNum(AirlineData2.get("TailNum"), AirlineData2.get("Cancelled"), AirlineData2.get("Distance"));
		AnswerFile.addAnswer(3, Question3);
		Question4 = Question.busiestAirport(AirlineData2.get("OriginAirportID"), AirlineData2.get("DestAirportID"), AirlineData2.get("Cancelled"));
		AnswerFile.addAnswer(4, Question4);
		Question5 = Question.largestSource(AirlineData2.get("OriginAirportID"), AirlineData2.get("DestAirportID"), AirlineData2.get("Cancelled"), 1);
		AnswerFile.addAnswer(5, Question5);
		Question6 = Question.largestSource(AirlineData2.get("OriginAirportID"), AirlineData2.get("DestAirportID"), AirlineData2.get("Cancelled"), -1);
		AnswerFile.addAnswer(6, Question6);
		Question7 = Question.AADelayCount(AirlineData2.get("UniqueCarrier"), AirlineData2.get("DepDelay"), AirlineData2.get("ArrDelay"), AirlineData2.get("Cancelled"), AirlineData2.get("Diverted"));
		AnswerFile.addAnswer(7, Question7);
		Question8 = Question.largestMakeUpTime(AirlineData2.get("DepDelay"), AirlineData2.get("ArrDelay"), AirlineData2.get("DayofMonth"), AirlineData2.get("TailNum"), AirlineData2.get("Diverted"), AirlineData2.get("Cancelled"));
		AnswerFile.addAnswer(8, Question8);
		Question9 = Question.questionNine(AirlineData2.get("OriginAirportID"), AirlineData2.get("Cancelled"));
		AnswerFile.addAnswer(9, Question9);
		AnswerFile.writeAnswers();
		
		
	}
	
	
}
