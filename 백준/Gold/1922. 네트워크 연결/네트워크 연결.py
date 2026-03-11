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


N = int(input())  # 컴퓨터 수
M = int(input())  # 연결 수

parent = list(range(N + 1))
rank = [0] * (N + 1)
edges = []
counts = 0
total = 0
for _ in range(M):
    a, b, val = map(int, input().split())
    edges.append((val, a, b))

edges.sort()

for val, x, y in edges:
    if union(x, y):
        total += val
        counts += 1

        if counts == (N - 1):
            break
print(total)
