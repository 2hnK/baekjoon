import sys
from collections import defaultdict

input = sys.stdin.readline
N = int(input())

for _ in range(N):
    test_case = input().rstrip()
    result = 0
    cnt = 0

    for i in test_case:
        if (i == 'O'):
            cnt += 1
            result += cnt
        elif (i == 'X'):
            cnt = 0

    print(result)
