# Last updated: 9/21/2026, 5:30:36 PM
class Solution(object):
    def secondsBetweenTimes(self, startTime, endTime):
        h1, m1, s1 = map(int, startTime.split(':'))
        h2, m2, s2 = map(int, endTime.split(':'))
        t1 = h1*3600 + m1*60 +s1
        t2 = h2*3600 + m2*60 +s2 
        return (t2 - t1) % 86400
        