def fibonacci(num):
    if (num == 0):
        return("1 0") # return값이 아니고 print문으로 사용 시 None이 출력 된다
    elif (num == 1):
        return("0 1")
    else:
        arr = [[0]*(2) for x in range(num+1)] #(num+1)*2 Array
        arr[0][0] = 1
        arr[0][1] = 0
        arr[1][0] = 0
        arr[1][1] = 1
        for j in range(2,num+1):
            for k in range(0,2):
                arr[j][k] = arr[j-1][k] + arr[j-2][k]
        return(repr(arr[num][0]) + " " + repr(arr[num][1]))

for _ in range(int(input())):
    print(fibonacci(int(input())))


# 참고할 코드.. 생각을 약간 다르게 해서 사용, 시간은 내 코드가 살짝 빠르기는 하지만;;;
# def fib(n):
#     a = (1, 0)
#     b = (0, 1)
#     for i in range(n):
#         a, b = b, (a[0] + b[0], a[1] + b[1])
#
#     return a
#
# for _ in range(int(input())):
#     print(*fib(int(input())))
## cf) *args : index가 존재하는 객체를 *표시를 붙여 인자로서 함수에 입력하면 함수의 정의된 위치에 맡게 입력이 됩니다.
