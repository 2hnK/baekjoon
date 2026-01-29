T = int(input())
for tc in range(1, T+1):
    n = int(input())
    ai = [input().split() for _ in range(n)]
    ai_90 = [['0']*n for _ in range(n)]
    ai_180 = [['0'] * n for _ in range(n)]
    ai_270 = [['0'] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            ai_90[j][n-i-1] = ai[i][j]
            ai_180[n-i-1][n-j-1] = ai[i][j]
            ai_270[n-j-1][i] = ai[i][j]

    print(f'#{tc}')
    for row in range(n):
        print(''.join(ai_90[row]), end=' ')
        print(''.join(ai_180[row]), end=' ')
        print(''.join(ai_270[row]))