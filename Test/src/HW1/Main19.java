package HW1;

import java.util.*;

/**
 * @program: Test
 * @ClassName Main19.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-14 11:04
 */
public class Main19 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        for (int i = 0; i < caseNum; i++) {
            int[] input = StringarrToIntarr(cin.nextLine());
            input = randomCommon(-900, 900, 20);


            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int t : input) {
                arrayList.add(t);
            }
            func(arrayList);
            System.out.println("============================================");


            int[] lis = LIS(input);
            int[] lds = LDS(input);
            int[] maxI = GetMaxArr(lis, lds);
            int MaxLen = GetArrMax(maxI);
            Set<String> setResult = new HashSet<String>();
            for (int j = 0; j < maxI.length; j++)
                if (maxI[j] == MaxLen)
                    GetStringResu(GetSetNode(input, lis, lds, j, MaxLen), "", 0,-1, setResult);
            List<String> listResult = new LinkedList<String>(setResult);
            Collections.sort(listResult);

            if (IsValid(listResult.get(0)))
                System.out.println(listResult.get(0));
            for (int j = 1; j < listResult.size(); j++)
                if (!listResult.get(j - 1).equals(listResult.get(j)) && IsValid(listResult.get(j)))
                    System.out.println(listResult.get(j));
        }


    }


    private static boolean IsValid(String s) {
        int[] input = StringarrToIntarr(s);
        if (input.length == 1)
            return true;
        boolean isup = true;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1])
                return false;
            if (isup && input[i] < input[i - 1])
                isup = false;
            if (!isup && input[i] > input[i - 1])
                return false;
        }
        return true;
    }

    private static void GetStringResu(List<String>[] listInput, String curStr, int curIndex, int preIndex, Set<String> result) {
        for (int i = curIndex; i < listInput.length; i++) {
            for (int j = 1; j < listInput[i].size(); j++) {
                if(Integer.parseInt(listInput[i].get(j).split("/")[1])>preIndex)
                    GetStringResu(listInput, curStr + " " + listInput[i].get(j).split("/")[0], i + 1,Integer.parseInt(listInput[i].get(j).split("/")[1]), result);
            }
            if(Integer.parseInt(listInput[i].get(0).split("/")[1])<=preIndex)
                continue;
            curStr = curStr + " " + listInput[i].get(0).split("/")[0];
            preIndex = Integer.parseInt(listInput[i].get(0).split("/")[1]);
        }
        if(curStr.trim().split(" ").length==listInput.length)
            result.add(curStr.trim());
    }

    private static List<String>[] GetSetNode(int[] input, int[] lis, int[] lds, int slice, int strLen) {
        List<String>[] outList = new List[strLen];
        for (int i = 0; i < outList.length; i++)
            outList[i] = new LinkedList<>();
        for (int i = 0; i < slice; i++)
            outList[lis[i] - 1].add(input[i]+"/"+i);
        for (int i = slice; i < input.length; i++)
            outList[strLen - lds[i]].add(input[i]+"/"+i);

//        for(int i=0;i<result.length;i++) {
//            System.out.print(i + ": ");
//            for(Object val : result[i].toArray())
//                System.out.print(" "+val);
//            System.out.println();
//        }

        return outList;
    }

    private static void GetResult(int[] input, int[] lis, int[] lds, int slice, int curSlice, String s, List<String> result, int[] ints) {
        if (curSlice <= slice) {
            int layer = lis[curSlice];
            for (--curSlice; curSlice >= 0; curSlice--) {
                if (lis[curSlice] == layer && layer != lis[slice] && input[curSlice] != input[curSlice + 1]) {
                    GetResult(input, lis, lds, slice, curSlice, input[curSlice] + s.substring(s.indexOf(" ")), result, ints);
                } else if ((lis[curSlice] + 1) == layer) {
                    if (layer != lis[slice] && input[curSlice] >= Integer.parseInt(s.substring(0, s.indexOf(" "))))
                        continue;
                    else if (layer == lis[slice] && input[curSlice] >= Integer.parseInt(s))
                        continue;
                    s = input[curSlice] + " " + s;
                    layer = lis[curSlice];
                }
            }
        }
        if (curSlice <= 0) {
            curSlice = slice;
        }
        int layerdown = lds[curSlice];
        for (++curSlice; curSlice < input.length; curSlice++) {
            if (lds[curSlice] == layerdown && layerdown != lds[slice] && input[curSlice] != input[curSlice - 1]) {
                String tempS = s.substring(0, s.lastIndexOf(" "));
                GetResult(input, lis, lds, slice, curSlice, s.substring(0, s.lastIndexOf(" ")) + " " + input[curSlice], result, ints);
            } else if ((lds[curSlice] + 1) == layerdown) {
                if (layerdown != lds[slice] && input[curSlice] >= Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1)))
                    continue;
                else if (layerdown == lds[slice] && input[curSlice] >= input[slice])
                    continue;
                s = s + " " + input[curSlice];
                layerdown = lds[curSlice];
            }
        }
        result.add(s.trim());
    }

    private static int GetArrMax(int[] arr) {
        if (arr.length == 0)
            throw new IllegalArgumentException();
        int result = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > result)
                result = arr[i];
        return result;
    }

    private static int[] GetMaxArr(int[] arr1, int[] arr2) {
        int[] OP = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            OP[i] = arr1[i] + arr2[i] - 1;
        return OP;
    }

    public static int[] LIS(int[] arr) {
        int[] output = new int[arr.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = 1;
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && output[i] < output[j] + 1)
                    output[i] = output[j] + 1;
        }
        return output;
    }

    public static int[] LDS(int[] arr) {
        int[] output = new int[arr.length];
        for (int i = output.length - 1; i >= 0; i--) {
            output[i] = 1;
            for (int j = output.length - 1; j > i; j--)
                if (arr[i] > arr[j] && output[i] < output[j] + 1)
                    output[i] = output[j] + 1;
        }
        return output;
    }

    public static int Sum(int[] arr) {
        int result = 0;
        for (int val : arr)
            result += val;
        return result;
    }

    /**
     * @param string
     * @return int[]
     * @throws
     * @title StringarrToIntarr
     * @description
     * @author Mr. jun
     * @updateTime 2019/10/10 9:20
     */
    public static int[] StringarrToIntarr(String string) {
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }

    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n   随机数个数
     */
    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    private static void func(ArrayList<Integer> arrayList) {
        int n = arrayList.size();
        Integer[] a = new Integer[n];
        arrayList.toArray(a);

//        <当前下标,当前等长列>
//        <当前下标，当前下标，<数列>>
//        <当前下标,<当前下标,<当前下标,当前数字>>>
        Map<Integer, ArrayList<HashMap<Integer, Integer>>> left = new HashMap<>();

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> list = new HashMap<>();
            list.put(i, a[i]);
            ArrayList<HashMap<Integer, Integer>> map = new ArrayList<>();
            map.add(list);
            left.put(i, map);

            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    int l1 = left.get(j).get(0).size();
                    int l2 = left.get(i).get(0).size();

                    if (l1 == l2 - 1) {

                        ArrayList<HashMap<Integer, Integer>> arrayList1 = new ArrayList<>();
                        arrayList1.addAll(left.get(i));

                        for (HashMap<Integer, Integer> map2 : left.get(j)) {

                            HashMap<Integer, Integer> map1 = new HashMap<>();
                            map1.putAll(map2);
                            map1.put(i, list.get(i));

                            arrayList1.add(map1);
                        }

                        left.put(i, arrayList1);

                    }
                    if (l1 > l2 - 1) {

                        ArrayList<HashMap<Integer, Integer>> arrayList1 = new ArrayList<>();

                        for (HashMap<Integer, Integer> map2 : left.get(j)) {

                            HashMap<Integer, Integer> map1 = new HashMap<>();
                            map1.putAll(map2);
                            map1.put(i, list.get(i));

                            arrayList1.add(map1);
                        }

                        left.put(i, arrayList1);
                    }
                }
            }
        }


        Map<Integer, ArrayList<HashMap<Integer, Integer>>> right = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            HashMap<Integer, Integer> list = new HashMap<>();
            list.put(i, a[i]);
            ArrayList<HashMap<Integer, Integer>> map = new ArrayList<>();
            map.add(list);
            right.put(i, map);

            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[i]) {
                    int l1 = right.get(j).get(0).size();
                    int l2 = right.get(i).get(0).size();

                    if (l1 == l2 - 1) {

                        ArrayList<HashMap<Integer, Integer>> arrayList1 = new ArrayList<>();
                        arrayList1.addAll(right.get(i));

                        for (HashMap<Integer, Integer> map2 : right.get(j)) {

                            HashMap<Integer, Integer> map1 = new HashMap<>();
                            map1.putAll(map2);
                            map1.put(i, list.get(i));

                            arrayList1.add(map1);
                        }

                        right.put(i, arrayList1);

                    }
                    if (l1 > l2 - 1) {

                        ArrayList<HashMap<Integer, Integer>> arrayList1 = new ArrayList<>();

                        for (HashMap<Integer, Integer> map2 : right.get(j)) {

                            HashMap<Integer, Integer> map1 = new HashMap<>();
                            map1.putAll(map2);
                            map1.put(i, list.get(i));

                            arrayList1.add(map1);
                        }

                        right.put(i, arrayList1);
                    }
                }
            }
        }

        int max = 0;
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            int l1 = left.get(i).get(0).size();
            int l2 = right.get(i).get(0).size();

            int now = l1 + l2;

            if (now == max) {
                pos.add(i);
            }
            if (now > max) {
                max = now;
                pos = new ArrayList<>();
                pos.add(i);
            }
        }

        Set<ArrayList<Integer>> result = new HashSet<>();

        for (int t : pos) {

            ArrayList<Integer> arrayList1 = new ArrayList<>();

            for (HashMap<Integer, Integer> temp : left.get(t)) {
                for (HashMap<Integer, Integer> temp1 : right.get(t)) {

                    arrayList1 = new ArrayList<>();
                    HashMap<Integer, Integer> map = new HashMap<>();
                    map.putAll(temp);
                    map.putAll(temp1);

                    Map<Integer, Integer> map1 = new TreeMap<>(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    map1.putAll(map);
                    //排序
//                    map.entrySet().stream()
//                            .sorted(Map.Entry.comparingByKey()).forEachOrdered(e -> map1.put(e.getKey(), e.getValue()));

                    arrayList1.addAll(map1.values());
                    result.add(arrayList1);
                }
            }

        }

        ArrayList<String> strings = new ArrayList<>();
        for (ArrayList<Integer> arrayList1 : result) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i : arrayList1) {
                stringBuffer.append(i + " ");
            }
            strings.add(stringBuffer.toString().trim());
        }
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String stringBuffer : strings) {
            System.out.println(stringBuffer);
        }

    }
}

