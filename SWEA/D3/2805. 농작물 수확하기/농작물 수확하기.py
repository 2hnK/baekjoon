def sumValue(mid, i):
    global profit
    # 배열 범위 초과하면
    if (i > mid):
        return 0
    for k in range(i, N-i):
        profit += value[mid-i][k]
        profit += value[mid+i][k]
    return sumValue(mid, i+1)

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    value = [list(map(int, list(input()))) for _ in range(N)]

    profit = 0
    mid = N // 2
    # 배열의 중간 행은 다 포함
    profit += sum(value[mid])
    sumValue(mid, 1)
    print(f'#{tc} {profit}')