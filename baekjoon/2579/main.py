N = int(input())
stair = [0]
for i in range(N):
    stair.append(int(input()))

dp=[-1]*(N+1)
dp[0]=0
dp[1]=stair[1]
dp[2]=max(stair[1]+stair[2],stair[2])
for i in range(3, N+1):
    dp[i] = max(dp[i-2]+stair[i],stair[i-1]+stair[i]+dp[i-3])

print(dp[N])
