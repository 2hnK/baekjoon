import sys
input = sys.stdin.readline

N = int(input())
words = []
visited = set()

for _ in range(N):
    x = input().strip()
    
    if x not in visited:
        visited.add(x)
        words.append([len(x), x])

words.sort()

for word in words:
    print(word[1])