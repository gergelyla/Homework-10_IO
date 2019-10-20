# Homework-10_IO

Ski Biathlon Standings

Write a software that takes as an input a CSV file where every entry represents the results of a biathlon athlete.

Based on the entries identify the first 3 places (Winner, Runner-up and Third Place).



The rules are simple, each athlete has a time-results for the entire skiing session, and 3 shooting range results.

Each shooting range has 5 shot results. For every missed shot the athlete obtains a 10 second penalty which affects the final time-
result.

Final standings are based on the time-results that have been updated with the shooting range results.



CSV example:

11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo

1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo

27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx



Where the columns are:

AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange.SecondShooting,ThirShootingeRane

Every shooting range consists of 5 charactes, where x means hit, o mean miss. For every o there should be 10 seconds added to the final 
time.

Based on the above data the actual results are the following:

Winner - Piotr Smitzer 30:10 (30:10 + 0)

Runner-up - Jimmy Smiles 30:15 (29:15 + 60)

Third Place - Umar Jorgson 30:57 (30:27 + 30)



Task:

Write tests for the CSV parsing and the standing calculation
In the your tests you must not use real files. Make sure the CSVs are read from memory to keep the tests fast.
Use Comparator/Comaparable for sorting
