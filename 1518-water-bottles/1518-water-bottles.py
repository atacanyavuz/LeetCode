class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        drunk = numBottles
        empty = numBottles
        full = 0
        while empty >= numExchange:
            full = empty // numExchange
            empty = empty % numExchange
            drunk = drunk + full
            empty = empty + full
        return drunk
        