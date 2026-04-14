import sys
from collections import defaultdict

input = sys.stdin.readline
N = int(input())  # 판매 횟수
book_info = defaultdict(int)

for _ in range(N):
    name = input()
    book_info[name] += 1

book_names = sorted(book_info)  # 오름차순 정렬
cnt_sell = 0
best_seller = ''

for item in book_names:
    if (cnt_sell < book_info[item]):
        cnt_sell = book_info[item]
        best_seller = item

print(best_seller)
