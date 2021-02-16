public class SortPart {

    public static void insertArray(int[] firstArray, int[] secondArray, int k){
        if (firstArray.length <= 1 || k >= firstArray.length){
            throw new IllegalArgumentException();
        }
        int[] resultArray = new int[firstArray.length + secondArray.length];
        int resultIndex = 0;
        for (int i = 0; i < firstArray.length; i++){
            if (resultIndex == k + 1){
                for (int j = 0; j < secondArray.length; j++){
                    resultArray[resultIndex] = secondArray[j];
                    resultIndex++;
                }
                i--;
            } else {
                resultArray[resultIndex] = firstArray[i];
                resultIndex++;
            }
        }
        printArray(resultArray);
    }

    public static void nonDecreasing(int[] firstArray, int[] secondArray){
        for (int i = 1; i < firstArray.length; i++){
            if (firstArray[i - 1] > firstArray[i]){
                throw new IllegalArgumentException();
            }
        }
        for (int i = 1; i < secondArray.length; i++){
            if (secondArray[i - 1] > secondArray[i]){
                throw new IllegalArgumentException();
            }
        }
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int[] resultArray = new int[firstArray.length + secondArray.length];
        for (int i = 0; i < resultArray.length; i++){
            if (firstArray[firstArrayIndex] <= secondArray[secondArrayIndex]) {
                resultArray[i] = firstArray[firstArrayIndex];
                firstArrayIndex++;
                if (firstArrayIndex == firstArray.length){
                    firstArrayIndex--;
                    firstArray[firstArrayIndex] = Integer.MAX_VALUE;
                }
            } else {
                resultArray[i] = secondArray[secondArrayIndex];
                secondArrayIndex++;
                if (secondArrayIndex == secondArray.length){
                    secondArrayIndex--;
                    secondArray[secondArrayIndex] = Integer.MAX_VALUE;
                }
            }
        }
        printArray(resultArray);
    }

    public static void sortByChoice(int[] array){
        for (int i = 0; i < array.length; i++){
            int max = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] > array[max]){
                    max = j;
                }
            }
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
        }
        printArray(array);
    }

    public static void sortByExchanges(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        printArray(array);
    }

    public static void sortByInserts(int[] array){
        for (int i = 1; i < array.length; i++){
            if (array[i] < array[i - 1]){
                int index = binarySearch(array, array[i], 0, i - 1);
                int temp = array[i];
                for (int j = i; j >= index; j--){
                    if (j == 0){
                        break;
                    }
                    array[j] = array[j - 1];
                }
                array[index] = temp;
            }
        }
        printArray(array);
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
                if (sortedArray[low] > key){
                    index = low;
                    break;
                }
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
                if (high == -1){
                    index = 0;
                    break;
                }
                if (sortedArray[high] < key){
                    index = high + 1;
                    break;
                }
            } else if (sortedArray[mid] == key) {
                index = mid + 1;
                break;
            }
        }
        return index;
    }

    public static void shellSort(double[] array){
        int i = 0;
        while (i < array.length - 1){
            if (array[i] <= array[i + 1]){
                i++;
            } else {
                double temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                if (i != 0){
                    i--;
                }
            }
        }
        printArray(array);
    }

    public static void placesToInsert(double[] firstArray, double[] secondArray) {
        int k = 0;
        for (int i = 0; i < secondArray.length; i++) {
            for (int j = k; j <= firstArray.length; j++) {
                if (j == firstArray.length){
                    System.out.println(i + " элемент из второй последовательности на место " + (j - 1) + " из первой");
                    break;
                }
                if (firstArray[j] >= secondArray[i]) {
                    System.out.println(i + " элемент из второй последовательности на место " + j + " из первой");
                    k = j + 1;
                    break;
                }
                if ((i == secondArray.length - 1) && (j == firstArray.length - 1) && (firstArray[j] <= secondArray[i])) {
                    System.out.println(i + " элемент из второй последовательности на место " + j + " из первой");
                    break;
                }
            }
        }
    }

    public static void commonDenominator(int[] numerators, int[] denominators){
        if (numerators.length != denominators.length){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < numerators.length; i++){
            if (numerators[i] <= 0 || denominators[i] <= 0){
                throw new IllegalArgumentException();
            }
        }
        int lcm = lcm(denominators);
        for (int i = 0; i < denominators.length; i++){
            numerators[i] *= lcm / denominators[i];
            denominators[i] = lcm;
        }
        System.out.println("Отсортированные знаменатели:");
        sortByExchanges(numerators);
        System.out.println("Отсортированные дроби:");
        for (int i = 0; i < numerators.length; i++){
            System.out.println(numerators[i] + "/" + denominators[i] + " ");
        }
    }

    private static int gcd(int a,int b){
        if (b==0)
            return a;
        else
            return gcd(b,a%b);
    }

    private static int lcm(int a, int b)
    {
        return a * (b / gcd(a, b));
    }

    private static int lcm(int[] input)
    {
        int result = input[0];
        for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }

    public static void printArray(int[] array){
        for (int el : array){
            System.out.print(el + " ");
        }
        System.out.println("");
    }

    public static void printArray(double[] array){
        for (double el : array){
            System.out.print(el + " ");
        }
        System.out.println("");
    }
}
