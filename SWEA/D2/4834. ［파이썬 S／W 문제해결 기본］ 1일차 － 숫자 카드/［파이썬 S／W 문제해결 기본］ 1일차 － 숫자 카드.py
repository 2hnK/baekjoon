T = int(input())
for tc in range(1, T+1):
    N = int(input())
    ai = input()
    arr = [0]*10

    for a in ai:
        arr[int(a)] += 1

    max_len = 0
    max_num = 0
    for a in range(len(arr)):
        if (max_len <= arr[a]):
            max_len = arr[a]
            max_num = a

    print(f'#{tc} {max_num} {max_len}')