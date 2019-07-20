package xyz.linye;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyTest {


    public static void main(String[] args) {
        //初始化选择数字
        int selectNum = 0;

        //判断输入号码
        while (selectNum != 99){

            System.out.print(
                "－－－－－－－－－－－－－－－－－－－－－－－－－\n" +
                " \t《算法设计与分析》实验\n" +
                "－－－－－－－－－－－－－－－－－－－－－－－－－\n" +
                "1.算法分析基础——Fibonacci序列问题\n" +
                "2.分治法在数值问题中的应用——矩阵相乘问题\n" +
                "3.减治法在组合问题中的应用——8枚硬币问题\n" +
                "4.变治法在排序问题中的应用——堆排序问题\n" +
                "99. 退出本实验\n" +
                "－－－－－－－－－－－－－－－－－－－－－－－－－\n" +
                "请输入您所要执行的操作（1，2，3，4，5，99）：\n");

            //输入操作数
            Scanner sc = new Scanner(System.in);
            //拿到操作数
            selectNum = sc.nextInt();

            //斐波那契数列
            if(selectNum == 1){
                Scanner sc1 = new Scanner(System.in);
                System.out.print("请输入(1.递归算法   2.非递归算法   3.查找计算机承受最大值)：");
                int num = sc1.nextInt();
                if(num == 1){
                    System.out.print("请输入n个Fibonacci数： ");
                    int n = sc1.nextInt();
                    //获取开始时间
                    long startTime = System.currentTimeMillis();
                    System.out.println("第n个Fibonacci数是:"+digui(n));
                    //获取结束时间
                    long endTime = System.currentTimeMillis();
                    System.out.println("花费时间："+(endTime - startTime)+"ms");
                }else if (num == 2){
                    //非递归
                    System.out.print("请输入n个Fibonacci数：");
                    int n = sc1.nextInt();
                    //获取开始时间
                    long startTime = System.currentTimeMillis();
                    System.out.println("第n个Fibonacci数是:"+diedai(n));
                    //获取结束时间
                    long endTime = System.currentTimeMillis();
                    System.out.println("花费时间："+(endTime - startTime)+"ms");
                }else if (num == 3){
                    //计算机能承受最大值
                    finddiedai();
                }
            }else if(selectNum == 2){
                //初始化二维数组
                int [][]arr1 = new int[4][4];
                int [][]arr2 = new int[4][4];

                //赋值
                for(int i = 0; i < arr1.length; i++){
                    for (int j = 0; j < arr2.length; j++) {
                        arr1[i][j] = i;
                        arr2[i][j] = i;
                    }
                }

                System.out.print("请输入：1.蛮力法 2.Strassen ");
                Scanner sc2 = new Scanner(System.in);
                int n = sc2.nextInt();
                //蛮力法
                if(n == 1){

                    manLi(arr1,arr2);
                }else {
                    //初始化结果矩阵
                    int [][]arr = new int[4][4];
                    //返回结果矩阵
                    arr = Strassen(arr.length,arr1, arr2, arr);

                    //打印输出
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr.length; j++) {
                            System.out.print(arr[i][j]+"\t");
                        }
                        System.out.println();
                    }
                }
            }else if (selectNum == 4){
                //标记变量
                int num = 1;
                //初始化集合
                List<Integer> list = new ArrayList<Integer>();
                while (num != 0){
                    System.out.print("请输入数组中的数字(输入数字0时退出)：");
                    Scanner scanner = new Scanner(System.in);
                    num = scanner.nextInt();
                    list.add(num);
                    //初始化数组
                    Integer []arr = list.toArray(new Integer[list.size()]);
                    //返回排序后的数组
                    Integer[] heapSort = heapSort(arr);
                    //遍历
                    System.out.print("堆排序后：");
                    for (int i = 0; i < heapSort.length; i++) {
                        System.out.print(heapSort[i]+"\t");
                    }
                    System.out.println();
                }

            }else if (selectNum == 3){
                findCoins();
        }

        }

    }


    /**
     * 斐波那契数列迭代--查找计算机能承受的最大值
     */
    public static int finddiedai() {
        int num1 = 0;
        int num2 = 1;
        int num3 = 0;

        int count = 0;
        while (true){
            num3= num1 + num2;
            num1 = num2;
            num2 = num3;

            count++;

            if(num3 < 0){
                System.out.println("第"+count+"个时为最大值");
                return num1;
            }
        }

    }


    /**
     * 斐波那契数列--递归算法
     */
    public static int digui(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return digui(n - 1) + digui(n - 2);
        }
    }

    /**
     * 斐波那契数列--迭代算法
     */
    public static int diedai(int n) {
        int num1 = 0;
        int num2 = 1;
        int num3 = 0;

        for (int i = 0; i < n; i++) {
            num3= num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }


    public static void matrixSub(int[][] matrixA, int[][] matrixB, int[][] result){
        for(int i = 0; i < matrixA.length; i++)
            for(int j = 0; j < matrixA.length; j++)
                result[i][j] = matrixA[i][j] - matrixB[i][j];
    }
    public static void matrixAdd(int[][] matrixA, int[][] matrixB, int[][] result){
        for(int i = 0; i < matrixA.length; i++)
            for(int j = 0; j < matrixA.length; j++)
                result[i][j] = matrixA[i][j] + matrixB[i][j];
    }
    public static int[][] Strassen(int N, int[][] matrixA, int[][] matrixB, int[][] result){
        if(N == 1){
            result[0][0] = matrixA[0][0] * matrixB[0][0];
            return null;
        }
        int halfSize = N / 2;
        int[][] A = new int[halfSize][halfSize];
        int[][] B = new int[halfSize][halfSize];
        int[][] C = new int[halfSize][halfSize];
        int[][] D = new int[halfSize][halfSize];
        int[][] E = new int[halfSize][halfSize];
        int[][] F = new int[halfSize][halfSize];
        int[][] G = new int[halfSize][halfSize];
        int[][] H = new int[halfSize][halfSize];
        int[][] C1 = new int[halfSize][halfSize];
        int[][] C2 = new int[halfSize][halfSize];
        int[][] C3 = new int[halfSize][halfSize];
        int[][] C4 = new int[halfSize][halfSize];

        int[][] P1 = new int[halfSize][halfSize];
        int[][] P2 = new int[halfSize][halfSize];
        int[][] P3 = new int[halfSize][halfSize];
        int[][] P4 = new int[halfSize][halfSize];
        int[][] P5 = new int[halfSize][halfSize];
        int[][] P6 = new int[halfSize][halfSize];
        int[][] P7 = new int[halfSize][halfSize];

        int[][] tempA = new int[halfSize][halfSize];
        int[][] tempB = new int[halfSize][halfSize];
        for(int i = 0; i < halfSize; i++)
            for(int j = 0; j < halfSize; j++){
                A[i][j] = matrixA[i][j];
                B[i][j] = matrixA[i][halfSize + j];
                C[i][j] = matrixA[i + halfSize][j];
                D[i][j] = matrixA[i + halfSize][j + halfSize];

                E[i][j] = matrixB[i][j];
                F[i][j] = matrixB[i][halfSize + j];
                G[i][j] = matrixB[i + halfSize][j];
                H[i][j] = matrixB[i + halfSize][j + halfSize];
            }
        matrixSub(F,H,tempB);
        Strassen(halfSize,A,tempB,P1);

        matrixAdd(A,B,tempA);
        Strassen(halfSize,tempA,H,P2);

        matrixAdd(C,D,tempA);
        Strassen(halfSize,tempA,E,P3);

        matrixSub(G,E,tempB);
        Strassen(halfSize,D,tempB,P4);

        matrixAdd(A,D,tempA);
        matrixAdd(E,H,tempB);
        Strassen(halfSize,tempA,tempB,P5);

        matrixSub(B,D,tempA);
        matrixAdd(G,H,tempB);
        Strassen(halfSize,tempA,tempB,P6);

        matrixSub(A,C,tempA);
        matrixAdd(E,F,tempB);
        Strassen(halfSize,tempA,tempB,P7);

        matrixAdd(P5,P4,C1);
        matrixSub(C1,P2,C1);
        matrixAdd(C1,P6,C1);

        matrixAdd(P1,P2,C2);

        matrixAdd(P3,P4,C3);

        matrixAdd(P5,P1,C4);
        matrixSub(C4,P3,C4);
        matrixSub(C4,P7,C4);

        for(int i = 0; i < halfSize; i++)
            for(int j = 0; j < halfSize; j++){
                result[i][j] = C1[i][j];
                result[i][j + halfSize] = C2[i][j];
                result[i + halfSize][j] = C3[i][j];
                result[i + halfSize][j + halfSize] = C4[i][j];
            }

        return result;
    }





    //蛮力法计算矩阵相乘
    public static void manLi(int [][]arr1,int [][]arr2){
        //返回的数组
        int [][]arr = new int[4][4];

        int num = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

    }

    /**
     * 堆排序
     * @param arr
     * @return
     */
    //每趟循环使得非叶子节点的节点和它的叶子节点保持为大顶堆
    //创建大顶堆，前提是数组为完全二叉树
    public static Integer[] makeHeap(Integer [] arr){
        //从最后一个节点直到第一个节点，进行调整
        for (int i = (arr.length-1)/2; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        return arr;
    }

    //此方法谨调整一次根节点k和子节点的大小关系保持大顶堆，而不是调整所有的数组直接变成大顶堆
    //调整堆，arr为数组，k为根节点，length为数组长度
    private static void adjustHeap(Integer[] arr, int k, int length) {
        //首先拿到根节点的值
        int temp = arr[k];
        for (int i = 2*k+1; i < length-1; i=i*2+1) {
            //如果左节点小于右节点
            if(i < length && arr[i] < arr[i+1]){
                i++;
            }
            //如果根节点值大于左右子节点，则直接跳出
            if(temp >= arr[i]){
                break;
            }else {
                //如果根节点小于左右子节点中任意一个，则将左右子节点中大的一个赋值给根节点，然后根节点重新设置为左右子节点中较大的那个节点的位置
                arr[k] = arr[i];
                k = i;
            }
        }

        arr[k] = temp;
    }

    //进行排序
    private static Integer[] heapSort(Integer[] arr) {
        //将混乱数组初始化堆
        Integer[] heap = makeHeap(arr);

        for (int i = heap.length-1; i > 1 ; i--) {
            //交换根节点(最大值)和最后一个节点
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            //进行调整
            adjustHeap(heap,0,i);
        }
        return heap;
    }


    /**
     * 8枚假币问题
     */
    static int[] coins = {2, 2, 2, 2, 2, 2, 1, 2};
    static int flag;

    public static void findCoins() {


        //设置第fakeNum枚是假的
        int fakeNum;

        //分成三堆
        //若前两堆一样重，假的肯定在c中
        if (sum(0, 2) == sum(3, 5)) {
            fakeNum = compare(6, 7);

            //前两堆重量不同,若第一堆重量大于第二堆
        } else if (sum(0, 2) > sum(3, 5)) {
            //丢掉每堆的最后一个币，比较前两个堆的前两个币，若相等，假币肯定在3或者6中间
            if (sum(0, 1) == sum(3, 4)) {
                fakeNum = compare(2, 5);
            } else if (sum(0, 1) > sum(3, 4)) {
                fakeNum = compare(0, 3);
                //如果第一个和第四个相等，则说明第二个和第五个当中肯定有一个是假币
                if(fakeNum == 200){
                    fakeNum = compare(1, 4);
                }
            } else {
                fakeNum = compare(1, 4);
                //如果第一个和第四个相等，则说明第二个和第五个当中肯定有一个是假币
                if(fakeNum == 200){
                    fakeNum = compare(1, 4);
                }
            }


            //若第一堆轻于第二堆
        } else {
            if (sum(0, 1) == sum(3, 4)) {
                fakeNum = compare(2, 5);
            } else if (sum(0, 1) > sum(3, 4)) {
                fakeNum = compare(1, 4);
                //如果第一个和第四个相等，则说明第二个和第五个当中肯定有一个是假币
                if(fakeNum == 200){
                    fakeNum = compare(1, 4);
                }
            } else {
                fakeNum = compare(0, 3);
                //如果第一个和第四个相等，则说明第二个和第五个当中肯定有一个是假币
                if(fakeNum == 200){
                    fakeNum = compare(1, 4);
                }
            }

        }

        if (flag == 1) {
            System.out.println("假币轻，为第" + ++fakeNum + "枚");
        } else {
            System.out.println("假币重，为第" + ++fakeNum + "枚");


        }

    }

    //进行比较
    public static int compare(int l, int r) {
        flag = 0;

        //定义一个真币
        int realCoin = 2;


        if (coins[l] > realCoin) {
            //重
            flag = 0;
            return l;
        } else if (coins[l] < realCoin) {
            //轻
            flag = 1;
            return l;
        }

        if (coins[r] > realCoin) {
            //重
            flag = 0;
            return r;
        } else if (coins[r] < realCoin) {
            //轻
            flag = 1;
            return r;
        }


        return 200;

    }


    //求和
    public static int sum(int l, int r) {

        int sumCount = 0;

        for (int i = l; i <= r; i++) {
            sumCount += coins[i];
        }

        return sumCount;
    }

}

