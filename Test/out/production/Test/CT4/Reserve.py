t = int(input())
while(t):
    t -= 1
    n = int(input())
    arr = []
    arr = [int(a) for a in input().split()]
    arr = sorted(arr)
    sel = []
    while(len(arr)):
        n = len(arr)
        sel.append(arr[n-1])
        if arr[n-1]-1 in arr:
            del arr[arr.index(arr[n-1]-1)]
            del arr[n-2]
        else:
            del arr[n-1]
    print(sum(sel))