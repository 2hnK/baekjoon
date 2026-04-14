import sys
input = sys.stdin.readline


def cutTree(ptr_s, ptr_e, need_length, best):
    if (ptr_s > ptr_e):
        return best

    center = (ptr_s + ptr_e) // 2
    cnt = sum((tree - center) for tree in trees if tree > center)

    if (cnt >= need_length):
        return cutTree(center + 1, ptr_e, need_length, center)

    else:
        return cutTree(ptr_s, center - 1, need_length, best)


# N: 나무의 수, M: 필요한 목재 길이
N, M = map(int, input().split())
trees = list(map(int, input().split()))

target_length = cutTree(0, max(trees), M, 0)
print(target_length)