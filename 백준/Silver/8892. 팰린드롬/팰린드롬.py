from itertools import combinations
import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    K = int(input().strip())
    word = [input().strip() for _ in range(K)]

    found = False

    for com in combinations(word, 2):
        word1 = com[0] + com[1]
        word2 = com[1] + com[0]

        if (word1 == word1[::-1]):
            found = True
            print(word1)
            break

        if (word2 == word2[::-1]):
            found = True
            print(word2)
            break

    if (not found):
        print(0)
