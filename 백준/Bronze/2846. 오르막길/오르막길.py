import sys

input = sys.stdin.readline

N = int(input())
Seq = list(map(int, input().split()))

best = 0  # 최고값
start_height = Seq[0]  # 언덕 시작높이

for i in range(1, N):
    if (Seq[i] > Seq[i-1]):  # 오르막길
        best = max(best, Seq[i] - start_height)

    else:  # 내리막길
        start_height = Seq[i]

print(best)

# 오르막길: 적어도 2개의 수로 이루어진 높이가 증가하는 부분 수열
# 오르막길의 크기: 부분 수열의 '마지막 높이 - 처음 높이'