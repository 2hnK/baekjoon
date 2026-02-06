def switchCard(idx):
    global prize
    global card
    if idx == num:
        prize = max(prize, int(''.join(card)))  # 현재 카드 값과 prize 값 중 더 큰 금액을 prize에 저장
        return

    for i in range(l):
        for j in range(l):
            if i == j:  # 동일한 자리 교환 X
                continue
            card[i], card[j] = card[j], card[i]
            # idx+1번 교환 후 값 중 현재 card 값이 없는 경우에만
            if ''.join(card) not in switched.get(idx+1):
                switched[idx+1].append(''.join(card))
                switchCard(idx+1)
            card[j], card[i] = card[i], card[j]

T = int(input())
for tc in range(1, T+1):
    card, num = input().split()
    num = int(num)
    card = list(card)
    l = len(card)

    switched = {i: [] for i in range(1, num+1)}    # idx번 교환에서 card 값 저장
    prize = 0
    switchCard(0)
    print(f'#{tc} {prize}')