import sys
from math import sqrt

input = sys.stdin.readline


def find(ptr_want):
    ptr = ptr_want
    root = []
    root.append(ptr)  # 끝나는 위치 포함

    # ptr_start, root 구하기
    while ptr > 3:
        ptr = ptr // 2
        root.append(ptr)  # 역순 정렬 [0, ]

    isOccupied = False
    for i in root[::-1]:  # 순차 탐색
        if isOccupied == True:
            return

        # 목적지 도착
        if i == ptr_want and bin_tree[i] == 0:
            bin_tree[i] = 1
            print(0)

        # 점유된 경우
        elif bin_tree[i] == 1:
            print(i)
            isOccupied = True


# (2 ≤ N < 220 / 1 ≤ Q ≤ 200,000)
N, Q = map(int, input().split())

bin_tree = [0] * (N + 1)

for i in range(Q):
    x = int(input())
    find(x)

"""
root = 1, 완전이진트리

입력된 순서대로 원하는 노드 선택

탐색하는 중에 점유된 노드가 있다면 가질 수 없다

1. 가질 수 있는지? > 0
2. 가질 수 없다면 처음 마주치는 점유된 땅의 번호를 구하시오

"""
