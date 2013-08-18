import sys
import datetime as dt
import matplotlib.pyplot as plt
import numpy as np
import matplotlib as mpl

"""
Diurnal_Plot.py: 

    Produce diurnal plots of fitbit data (5 min intervals). 
    Inspired by Stephen Wolfram's "The Personal Analytics of my Life"
    (http://blog.stephenwolfram.com/2012/03/the-personal-analytics-of-my-life/) 

    Call with fitbit data as first argument. 
"""

if __name__=='__main__': 
    filename = sys.argv[1]
    minutes_in_day = (24 * 60) 
    X   = [] 
    Y   = [] 
    values = []
    with open(filename,'r') as f: 
        day_num = -1
        day = None
        time_num = 0
        for l in f: 
            
            parts   = l.split(",")
            date_s  = parts[0]
            value   = int(parts[1]) 
            datet   = dt.datetime.strptime(date_s, "%Y-%m-%d %H:%M")
            if day != datet.date():
                day_num = day_num + 1
                day = datet.date()
           

            if value > 0: 
                values.append(value)
                X.append(datet.date()) 
                Y.append(minutes_in_day - (datet.time().hour * 60 + datet.time().minute))

    #Y axis locations
    locations = np.arange(0,24)*60

    #Y axis labels
    labels    = ["%d:00" % ((24*60 - x) /60) for x in locations]

    ax = plt.scatter(X,Y, c=values, s=3, facecolor='0.5', lw = 0, cmap=mpl.cm.YlGnBu)
    plt.ylim([0,minutes_in_day]) 
    plt.yticks(locations,labels)
    plt.savefig("FitbitData.png", fmt="png"); 
