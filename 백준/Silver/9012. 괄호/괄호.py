import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    brackets = list(input().strip())
    queue = deque([])

    valid = True  # 수식 유효성 검사
    for b in brackets:
        if (b == '('):
            queue.append('(')
        elif (b == ')'):
            # 비어있지 않고 최상단 스택이 '('인 경우
            if (queue and queue[-1] == '('):
                queue.pop()
            else:
                valid = False
                break

    # 유효한 수식이며, 비어있는 경우
    if (valid and not queue):
        result = 'YES'
    else:
        result = 'NO'

    print(result)
