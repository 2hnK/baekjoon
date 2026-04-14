import sys
input = sys.stdin.readline

# N: 전체 날짜, K:연속적인 날짜
N, K = map(int, input().split())

temp = list(map(int, input().split()))
temp_acc = [0]

for i in range(N):
    temp_acc.append(temp_acc[-1] + temp[i])

max_temp = -float('inf')
for i in range(N-K+1):
    temp_block = temp_acc[i+K] - temp_acc[i]
    if (temp_block > max_temp):
        max_temp = temp_block

print(max_temp)
# print(f"temp{temp}")
# print(f"temp_acc{temp_acc}")

#    3 -2 -4 -9   0   3  7 13  8 -3
# 0  3  1 -3 -12 -12 -9 -2 11 19 16
# [a, b] 구간의 합 > acc[b] - acc[a-1]
