# Last updated: 7/17/2026, 3:04:48 PM
class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        n = len(columnTitle)
        d = {k: v for k, v in zip(list('ABCDEFGHIJKLMNOPQRSTUVWXYZ'), range(1,27))}
        res = 0

        #Мы идем сначала
        for i in range(len(columnTitle)):
            currentLetter = columnTitle[i]

            res += d[columnTitle[i]] * (26 ** (n - i - 1))

        return res