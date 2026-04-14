from collections import defaultdict
import sys


def preOrder(node):
    if node == '.':
        return

    print(node, end="")
    preOrder(tree[node][0])
    preOrder(tree[node][1])


def inOrder(node):
    if node == '.':
        return

    inOrder(tree[node][0])
    print(node, end="")
    inOrder(tree[node][1])


def postOrder(node):
    if node == '.':
        return

    postOrder(tree[node][0])
    postOrder(tree[node][1])
    print(node, end="")


input = sys.stdin.readline
N = int(input())
tree = defaultdict(list)

for _ in range(N):
    node, left, right = input().split()
    tree[node].append(left)
    tree[node].append(right)

    # if node not in tree:
    #     tree[node] = []
    #     tree[node].append(left)
    # else:
    #     tree[node].append(right)

preOrder('A')
print()
inOrder('A')
print()
postOrder('A')
