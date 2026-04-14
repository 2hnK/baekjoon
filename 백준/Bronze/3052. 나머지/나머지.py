import sys
input = sys.stdin.readline

remains = set()
for _ in range(10):
    x = int(input()) #0 < x <= 1000
    remains.add(x % 42)
    
print(len(remains))

"""
set1 = set([1, 2, 3])
set1.update([4, 5 ,6]) > [1, 2, 3, 4, 5, 6]
set1.remove(2) > [1, 3, 4, 5, 6]
"""