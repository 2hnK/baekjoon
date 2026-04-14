
import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    index, word = input().split()
    index = int(index)-1
    res = word[:index] + word[index+1:]
    print(res)