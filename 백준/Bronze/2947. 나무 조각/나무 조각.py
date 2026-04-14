import sys
input = sys.stdin.readline

tree_piece = list(map(int, input().split()))
answer = [1, 2, 3, 4, 5]

while (tree_piece != answer):
    for i in range(4):
        if (tree_piece[i] > tree_piece[i+1]):
            temp = tree_piece[i]
            tree_piece[i] = tree_piece[i+1]
            tree_piece[i+1] = temp
            print(*tree_piece)
