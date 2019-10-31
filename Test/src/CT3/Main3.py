def GetChar(q):

    g_str = ['1', '2', '3', '4', '5', '$', '5', '4', '3', '2', '1']

    while q > len(g_str):
        m, itr = GetValues(q)

        val = int(((m - itr) / 2) + itr);

        if(q <= val):
            q = 6
            break
        q -= val
    if(q > 0):
        return g_str[q-1]
    return ""

def GetValues(q):
    size = 5;
    itr = 0;

    while True:

        if(q <= size):
            return (size, itr)
        itr += 1;
        size = (size * 2) + itr


T = int(input())

for i in range(0, T):
    q = int(input())
    print(GetChar(q)) 