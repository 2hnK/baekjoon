import sys
input = sys.stdin.readline

N = int(input())

members = {}
for _ in range(N):
    name, state = input().strip().split()

    if state == "enter":
        members[name] = True
    elif state == "leave":
        if name in members:
            del members[name]

for name in sorted(members.keys(), reverse=True):
    print(name)