from heapq import heappop, heappush
import sys

input = sys.stdin.readline

heap = []
N = int(input())  # 연산의 개수

for _ in range(N):
    x = int(input())

    if x == 0:
        if heap:
            print(heappop(heap) * -1)
        else:
            print(0)
    elif (2 ** 31) > x > 0:
        heappush(heap, x * -1)
