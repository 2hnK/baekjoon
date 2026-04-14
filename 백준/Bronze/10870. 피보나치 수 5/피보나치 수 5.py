import sys
input = sys.stdin.readline


def fibo(n):
    if (n <= 1):
        return n
    return fibo(n-1) + fibo(n-2)


N = int(input())
print(fibo(N))
