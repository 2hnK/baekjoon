t = int(input())
for i in range(t):
    n = int(input())
    m = int(input())
    INF = 10**9
    dist = [[INF] *(n+1) for _ in range(n+1)]
    a = [list(map(int,input().split())) for _ in range(m)]
    for j in range(len(a)):
        first = a[j][0]
        second = a[j][1]
        dist[first][second]=1
    for k in range(1,n+1):
        for s in range(1,n+1):
            for e in range(1,n+1):
                dist[s][e] = min(dist[s][e], dist[s][k] +dist[k][e])
    answer = 0
    for j in range(1,n+1):
        check = True
        for e in range(1,n+1):
            if j==e:
                continue
            if dist[j][e] == INF and dist[e][j] == INF:
                check = False
                break
        if check == True:
            answer+=1
    print(f"#{i+1} {answer}")