public class Homework_3
{
    static void changeOneZero()
    {
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = (int)(Math.random() * 2.0);
        }
        System.out.println("Before changes");
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        System.out.println();
        System.out.println("After changes");
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    static void getOneToHundred()
    {
        int size = 100;
        int[] arr = new int[size];
        for (int i = 1; i <= size; i++)
        {
            arr[i - 1] = i;
        }
        for (int i = 0; i < size; i++)
        {
            if ((i % 10 == 0) && (i != 0)) System.out.print(".." + '\n' + ".. ");
            System.out.print(arr[i] + " ");
        }
    }
    static void mulSix()
    {
        int[] arr = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int size = arr.length;
        System.out.println("Before changes");
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
            if (arr[i] < 6) arr[i] *= 2;
        }
        System.out.println();
        System.out.println("After changes");
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    static void setDiagonal()
    {
        int size = 9;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++)
        {
            arr[i][i] = 1;
            arr[size - 1 - i][i] = 1;
        }
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[] init(int len, int initialValue)
    {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++)
        {
            arr[i] = initialValue;
        }
        return arr;
    }
    static void printMaxMin()
    {
        int size = 10;
        int[] arr = new int[size];
        System.out.println("Array:");
        for (int i = 0; i < size; i++)
        {
            arr[i] = (int) (Math.random() * 101.0);
            System.out.print(arr[i] + " ");
        }
        int maxValue = arr[0], minValue = arr[0];
        for (int i = 0; i < size; i++)
        {
            if (arr[i] > maxValue) maxValue = arr[i];
            else if (arr[i] < minValue) minValue = arr[i];
        }
        System.out.println();
        System.out.println("Maximum = " + maxValue);
        System.out.println("Minimum = " + minValue);
    }
    static boolean checkBalance(int[] arr)
    {
        int size = arr.length;
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < size; i++)
        {
            sumRight += arr[i];
        }
        for (int i = 0; i < size; i++)
        {
            sumLeft += arr[i];
            sumRight -= arr[i];
            if (sumLeft == sumRight) return true;
        }
        return false;
    }
    static void shiftArr(int[] arr, int n)
    {
        int size = arr.length;
        int temp;
        System.out.println("Array before shift:");
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        if (n >= 0)
        {
            for (int i = 0; i < n; i++)
            {
                temp = arr[size - 1];
                for (int j = size - 1; j > 0; j--)
                {
                    arr[j] = arr[j - 1];
                }
                arr[0] = temp;
            }
        }
        else
        {
            for (int i = 0; i < Math.abs(n); i++)
            {
                temp = arr[0];
                for (int j = 0; j < size - 1; j++)
                {
                    arr[j] = arr[j + 1];
                }
                arr[size - 1] = temp;
            }
        }

        System.out.println("Array after shift:");
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args)
    {
        // #1
        changeOneZero();
        System.out.println('\n');

        // #2
        getOneToHundred();
        System.out.println('\n');

        // #3
        mulSix();
        System.out.println('\n');

        // #4
        setDiagonal();
        System.out.println();

        // #5
        int len = 15, value = 123;
        System.out.println("Len: " + len + " Value: " + value);
        int[] mas = new int[len];
        mas = init(len, value);
        for (int i = 0; i < len; i++)
        {
            System.out.print(mas[i] + " ");
        }
        System.out.println('\n');

        // #6
        printMaxMin();
        System.out.println();

        // #7
        int[] arr = new int[len];
        System.out.print("Array ");
        for (int i = 0; i < len; i++)
        {
            arr[i] = (int)(Math.random() * 5.0);
            System.out.print(arr[i] + " ");
        }
        if (checkBalance(arr)) System.out.println("has a balance");
        else System.out.println("has no balance");
        System.out.println();

        // #8
        int size = 10;
        int shift = -2;
        System.out.println("Shift = " + shift);
        int[] newArr = new int[size];
        for (int i = 0; i < size; i++)
        {
            newArr[i] = (int)(Math.random() * 100.0);
        }
        shiftArr(newArr, shift);
    }
}



