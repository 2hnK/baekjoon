# 두 난쟁이의 키 + 100 = 전체 난쟁이 키
import sys

input = sys.stdin.readline
heights = []

# 난쟁이 키 입력
for i in range(9):
    heights.append(int(input()))

heights = sorted(heights)  # 오름차순 정렬
sum_heights = sum(heights)  # 아홉 난쟁이 키의 합
found = False  # 반복문 탈출 플래그

for i in range(9):
    for j in range(i + 1, 9):
        two_dwarfs = heights[j] + heights[i]

        if ((two_dwarfs + 100) == sum_heights):
            heights.pop(j)  # 큰 값부터 제거
            heights.pop(i)
            found = True
            break

    if found:
        break

for i in range(7):
    print(heights[i])
