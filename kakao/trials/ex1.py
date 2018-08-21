# 22 line
# input example
# N = 5
# arr1 = [9, 20, 28, 18, 11]
# arr2 = [30, 1, 21, 17, 28]
# output example
# ["#####","# # #", "### #", "# ##", "#####"]

# N = 6
# arr1 = [46, 33, 33 ,22, 31, 50]
# arr2 = [27 ,56, 19, 14, 14, 10]
# ["######", "### #", "## ##", " #### ", " #####", "### # "]
def secret(n, arr1, arr2):
    arr = [] #array
    for i in range(N):
        #bin : 2, oct:8, hex:16
        temp_str = format(arr1[i] | arr2[i], str(n)+'b') #bit operation, 2진수 nbit로 반환
        temp_str = temp_str.replace('0',' ')
        temp_str = temp_str.replace('1', '#')
        arr.append(temp_str)
    return arr
N = 5
arr1 = [9, 20, 28, 18, 11]
arr2 = [30, 1, 21, 17, 28]
print(secret(N, arr1, arr2))

N = 6
arr1 = [46, 33, 33 ,22, 31, 50]
arr2 = [27 ,56, 19, 14, 14, 10]
print(secret(N, arr1, arr2))
# https://docs.python.org/2/library/functions.html#format

############################################################################
# example
num1 = 1
num2 = 9
print(format(num1 | num2, str(3)+'o'))