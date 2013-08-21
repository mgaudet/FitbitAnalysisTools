FitbitAnalysisTools
===================

My tools for analyzing fitbit data. 

## FitbitDataFetch 

A very simple Java programming using Clay Gregory's marvellous [jFitbit](https://github.com/claygregory/jfitbit) to grab a Fitbit account's intraday time-series data.

Produces a file called FitbitData which has timestamped stepcounts for a date range

### Requirements

- [jFitbit](https://github.com/claygregory/jfitbit)
- [cg-jcommons](https://github.com/claygregory/cg-jcommons)
- [Apache http-components](http://hc.apache.org/downloads.cgi) (I found version 4.2.5 worked just fine)

### Instructions

This isn't well packaged, but hopefully the instructions will help. 

1. Create a new eclipse project (or, if you are good with ant, then you can
   probably figure this out without instructions. 

2. Add the file FitbitDataFetch/src/FitbitTest.java

3. Download the two projects, jFitbit and cg-jcommons. Both can be built with maven using `mvn package`, and will produce `.jar` files in target/. Add these jars to the Java build path for your eclipse project. Download the binary package of `http-components`, and add the jars in lib/ to your build path. 

4. Modfify the source of FitbitTest.java to use your username and password. 

5. Run!


## `Diurnal_Plot.py`

A very simple python program which takes the output of FitbitDataFetch and produces 
a Diurnal plot inspired by the ['personal analytics' of Stephen Wolfram](http://blog.stephenwolfram.com/2012/03/the-personal-analytics-of-my-life/). 

