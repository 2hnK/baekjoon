T = int(input())
for tc in range(1, T+1):
    n, k = map(int, input().split())
    ai = [list(map(int, input().split())) for _ in range(n)]

    answer = 0
    for i in range(n):
        num_row = 0
        num_col = 0
        for j in range(n):
            # 행 검사
            if (ai[i][j]): num_row+=1
            else:
                if(num_row==k): answer+=1
                num_row = 0
            
            # 열 검사
            if (ai[j][i]): num_col+=1
            else:
                if(num_col==k): answer+=1
                num_col = 0
                
        # 행 끝까지 검사해 길이가 k개인 경우
        if (num_row == k): answer += 1
        # 열 끝까지 검사해 길이가 k개인 경우
        if (num_col == k): answer += 1

    print(f'#{tc} {answer}')