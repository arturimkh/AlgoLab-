import java.util.Scanner;

public class Main {
    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

    }
    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    static void shellSort(int a[], int n)
    {
        /* Rearrange the array elements at n/2, n/4, ..., 1 intervals */
        for (int interval = n/2; interval > 0; interval /= 2)
        {
            for (int i = interval; i < n; i += 1)
            {
            /* store a[i] to the variable temp and make

the ith position empty */
                int temp = a[i];
                int j;
                for (j = i; j >= interval && a[j - interval] >
                        temp; j -= interval)
                    a[j] = a[j - interval];

            /* put temp (the original a[i]) in its correct
position */
                a[j] = temp;
            }
        }
    }
    public static int partition (int a[], int start, int end)
    {
        int pivot = a[end]; // pivot element
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++)
        {
            // If current element is smaller than the pivot
            if (a[j] < pivot)
            {
                i++; // increment index of smaller element
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i+1];
        a[i+1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    /* function to implement quick sort */
    public static void quickSort(int a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */
    {
        if (start < end)
        {
            int p = partition(a, start, end);  //p is partitioning index
            quickSort(a, start, p - 1);
            quickSort(a, p + 1, end);
        }
    }
    static void printArr(int a[])
    {
        int n = a.length-1;
        int i;
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
    public static void main(String a[]){
        int[] arr1 = {9,14,3,2,43,11,58,22};
        printArr(arr1);
        Scanner input=new Scanner(System.in);
        System.out.println("Enter what sort you wanna use");
        System.out.println("1. Сортировка вставками (Insertion sort)\n"+
        "2. Сортировка выбором (Selection sort)\n"+
        "3. Пузырьковая сортировка (Bubble sort)\n"+
        "4. Сортировка слиянием (Merge sort)\n"+
        "5. Сортировка Шелла (Shell sort)\n"+
        "6. Быстрая сортировка (Quick sort)\n");
        switch(input.nextInt()){
            case 1:
                insertionSort(arr1);
                break;
            case 2:
                selectionSort(arr1);
                break;
            case 3:
                bubbleSort(arr1);
                break;
            case 4:
                mergeSort(arr1,arr1.length-1);
                break;
            case 5:
                shellSort(arr1,arr1.length-1);
                break;
            case 6:
                quickSort(arr1,0,arr1.length-1);
                break;
        }
        printArr(arr1);
    }
}
