import sys
input = sys.stdin.readline

n = int(input())  # 수열의 크기
a = list(map(int, input().split()))  # 수열
x = int(input())  # 목표값

a = sorted(a)

cnt = 0  # 목표값 카운터
s = 0  # 시작 포인터
e = n-1  # 끝 포인터

while (s < e):
    two_nums = a[s] + a[e]
    if(two_nums > x):
        e -= 1
    
    if(two_nums < x):
        s += 1
    
    if(two_nums == x):
        e -= 1
        s += 1
        cnt += 1

print(cnt)
