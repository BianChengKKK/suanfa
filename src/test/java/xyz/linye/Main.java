package xyz.linye;

public class Main {



    public static void main(String[] args) {
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

        manLi(arr1,arr2);
        System.out.println();




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
}