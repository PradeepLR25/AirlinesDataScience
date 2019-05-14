# AirlinesDataScience
Project that reads in a large file containing Data from various Airlines, and determines answers to various questions.
MCIT Online - 591 - Introduction to Software Engineering

Assignment 5: Data Science with Airlines

This assignment continues our dive into the world of real data sets and the interesting questions
that can be asked and answered with data science.
In order to do this assignment, here are the concepts that you will need to know:
● File handling - the csv file has to be read
● HashMaps and ArrayLists - once the file is read, we have to store the data in a data
structure that will make data retrieval easy

The activities in Weeks 8 and 9 Recitation will help you practice for this assignment, so it is
highly recommended that you attend the live sessions or review the recordings and be sure to
attempt the recitation activities.

Introduction

If you have ever taken a flight, you are likely to have been concerned about whether or not
your flight is going to be delayed. The Bureau of Transportation Statistics provides publicly
available data sets on every aircraft that has taken off in the United States. The csv that we
provided has data from 2016.
We would like you to answer questions using this data. Are you frustrated with the airport that
is closest to you? Do you think others couldn’t possibly have it worse than you? What is the
likelihood that the flight you have to take to visit your family during Thanksgiving will get there
on time? Here’s the assignment that will help answer these questions using your newly
acquired programming skills.

Data Science Questions

Using the flights.csv file that we have supplied, we want you to write Java code to read the file
and then answer the following questions. We have also supplied another small csv file that has
the details on the cancellation codes.
Please do not create one giant main method to answer these. Remember to make your code
DRY.

There is a specific manner in which we want you to answer these questions. We need you to
use the FormattedOutput.java class and use that to write your answers to a file. The file needs
to call answers.txt and that needs to be submitted along with the actual Java code.

1. Which carrier has the highest percentage of cancelled flights? Output the 2-letter
Carrier ID and the chance of a cancelled flight, as a percentage (Example: AA,1.22%).
2. What’s the most common cause of cancellations? Output the one-letter code.
3. Which plane (tail number) flew the furthest (most miles)? Output the complete
tailnumber (Example: N775AJ).
4. Which airport is the busiest by total number of flights in and out? Use the number
OriginAirportID (Example: 12478).
5. You need planes to put people on! Which airport is the biggest “source” of airplanes?
Use the difference between arrivals and departures to compute this value. Output the
OriginAirportID (Example: 12478).
6. Which airport is the biggest “sink” of airplanes? Again, use the difference between
arrivals and departures, outputting the OriginAirportID (Example: 12478).
7. How many American Airlines (Unique Carrier ID ‘AA’) flights were delayed by 60 minutes
or more? If a flight was delayed departing and arriving, only count that as 1. Output an
integer.
8. What was the largest delay that was made up (arrived early/on time)? Output the Day
of Month (the number), departure delay (as a number), and the tail-number. Example:
(10,30,N947JB).
9. Come up with a question of your own and answer it!
