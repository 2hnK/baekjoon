t = int(input())
for i in range(t):
    n,k = map(int,input().split())
    a =list(map(int,input().split()))
    answer = 10**9
    for j in range(1<<n):
        index = 0
        for e in range(n):
            if j & (1<<e):
                index+=a[e]
        if index>=k:
            result = index-k
            answer = min(result,answer)
    print(f"#{i+1} {answer}")