# N장의 카드(양수)
# 딜러가 숫자 M을 정함
# 플레이어는 제한된 시간 내에 3장의 카드를 골라야 한다
import sys
from itertools import combinations

input = sys.stdin.readline

# N: 카드 수, M: 목표 점수
N, M = map(int, input().split())
cards = list(map(int, input().split()))

best_score = 0
for com in combinations(cards, 3):
    com_sum = sum(com)

    if (com_sum > best_score and com_sum <= M):  # 목표 점수 이하의 수
        best_score = com_sum

    if (com_sum == M):
        break

print(best_score)
