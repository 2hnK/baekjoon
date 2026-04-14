"""
[0, n-1]개의 점
어느 세 점도 일직선 위에 놓이지 않는다
두 점을 선택해서 연결 (이전에 그린 선분 다시X, 기존 선과 교차 가능, 사이클이 완성되면 종료)
"""


def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]


def union(x, y):
    x_root, y_root = find(x), find(y)

    if x_root == y_root:
        return False

    if rank[x_root] > rank[y_root]:
        parent[y_root] = x_root
    elif rank[x_root] < rank[y_root]:
        parent[x_root] = y_root
    else:
        parent[y_root] = x_root
        rank[x_root] += 1
    return True


import sys

input = sys.stdin.readline

# 정점, 간선
N, M = map(int, input().split())
parent = (list(range(N)))
rank = [0] * N
counts = 0

for _ in range(M):
    x, y = map(int, input().split())

    if union(x, y):
        counts += 1
        if counts == M:
            counts = 0
    else:
        counts += 1
        break

print(counts)
