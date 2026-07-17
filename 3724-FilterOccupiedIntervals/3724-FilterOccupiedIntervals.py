# Last updated: 7/17/2026, 3:01:57 PM
class Solution(object):
    def filterOccupiedIntervals(self, occupiedIntervals, freeStart, freeEnd):
        if not occupiedIntervals:
            return []
        occupiedIntervals.sort(key = lambda x : x[0])
        merged = []
        for interval in occupiedIntervals:
            if not merged or interval[0] > merged[-1][1] + 1:
                merged.append(interval)
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])
        result = []
        for s, e in merged:
            if e < freeStart or s > freeEnd:
                result.append([s, e])
            else:
                if s < freeStart:
                    result.append([s, freeStart - 1])
                if e > freeEnd:
                     result.append([freeEnd + 1 , e])
        return result
        