def maximizeSum(a, n) :

    # stores the occurrences of the numbers
    ans = dict.fromkeys(range(0, n + 1), 0)

    # marks the occurrence of every
    # number in the sequence
    for i in range(n) :
        ans[a[i]] += 1

    # maximum in the sequence
    maximum = max(a)

    # traverse till maximum and apply
    # the recurrence relation
    for i in range(2, maximum + 1) :
        ans[i] = max(ans[i - 1],
                     ans[i - 2] + ans[i] * i)

        # return the ans stored in the
    # index of maximum
    return ans[maximum]

# Driver code
if __name__ == "__main__" :

    a = [1, 2, 3]
    n = len(a)
    print(maximizeSum(a, n))