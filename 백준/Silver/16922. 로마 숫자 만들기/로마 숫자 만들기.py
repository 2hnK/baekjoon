import sys
from itertools import combinations_with_replacement

input = sys.stdin.readline

N = int(input())  # 문자의 개수 (1 ≤ N ≤ 20)

chars = {1, 5, 10, 50}
cnt = 0
visited = []

for com in combinations_with_replacement(chars, N):
    val = sum(com)
    if not val in visited:
        visited.append(val)
        cnt += 1
    else:
        continue

print(cnt)
"""
I V  X  L
1 5 10 50

1개 이상의 문자를 이용해서 수를 나타낼 수 있다.

문자열이 나타내는 값은 각 문자의 수를 합한 값

문자의 순서 상관X

로마 숫자 N개를 사용해서 만들 수 있는 서로 다른 수의 개수를 구하시오.
I V X L
a b c d

a + b + c + d = N
중복 조합 문제
"""
