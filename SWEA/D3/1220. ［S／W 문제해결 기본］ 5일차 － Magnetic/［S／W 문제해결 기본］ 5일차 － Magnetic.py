for tc in range(1, 11):
    l = int(input())
    arr = [list(map(int, input().split())) for _ in range(l)]
    cnt = 0

    for line in list(map(list, zip(*arr))):
        # 각 행(열)을 문자열로 이어준 후 0을 기준으로 나눔
        new_line = ''.join(map(str, line)).split('0')
        # 0을 기준으로 나뉜 배열을 문자열로 이어줌 -> 각 행의 모든 0이 사라짐
        line_str = ''.join(map(str, new_line))
        cnt += line_str.count('12')

    print(f'#{tc} {cnt}')