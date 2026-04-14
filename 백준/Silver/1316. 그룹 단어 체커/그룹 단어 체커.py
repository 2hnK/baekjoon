import sys

input = sys.stdin.readline
N = int(input())
words = []
cnt = 0

for i in range(int(N)):
    words.append(input().rstrip())

for word in words:
    checker = []
    isGroupWord = True

    for i in range(1, len(word)):
        checker.append(word[0])

        # 동일한 단어 continue
        if (word[i] == word[i-1]):
            continue

        # 탐색
        if (word[i] not in checker):
            checker.append(word[i])
        else:
            isGroupWord = False
            break

    if (isGroupWord):
        cnt += 1

print(cnt)
