T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    ai = [list(map(int, input().split())) for _ in range(N)]
    sum_ai = [[0]*(N+1) for _ in range(N+1)]
    
    for i in range(1, N+1):
        for j in range(1, N+1):
            sum_ai[i][j] = ai[i-1][j-1] + sum_ai[i-1][j] + sum_ai[i][j-1] - sum_ai[i-1][j-1]

    max_sum = 0
    for x in range(M, N+1):
        for y in range(M, N+1):
            cur_sum = sum_ai[x][y] - sum_ai[x-M][y] - sum_ai[x][y-M] + sum_ai[x-M][y-M]
            max_sum = max(max_sum, cur_sum)
            
    print(f'#{tc} {max_sum}')