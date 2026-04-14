import sys
input = sys.stdin.readline


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


# 집의 수, 길의 수
N, M = map(int, input().split())

parent = list(range(N+1))
rank = [0] * (N+1)
edges = []
cost = 0
cost_best = 0
counts = 0

for _ in range(M):
    A, B, val = map(int, input().split())
    edges.append((val, A, B))
edges.sort()

for val, A, B in edges:
    if union(A, B):
        cost += val
        cost_best = max(val, cost_best)
        counts += 1
        if counts >= (N - 1):
            break

print(cost - cost_best)
