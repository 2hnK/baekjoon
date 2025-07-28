cur_hour, cur_min = map(int, input().split(' '))
bake_time = int(input())

cur_min += bake_time
add_hour = cur_min //60
cur_hour += add_hour
cur_hour %= 24
cur_min %= 60

print(cur_hour, cur_min)