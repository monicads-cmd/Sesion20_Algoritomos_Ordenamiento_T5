import java.util.Arrays;


class MetodosOrdenamiento {

    public static void ordenamientoBurbuja1(int numeros[]) {
        long intercambios = 0;
        long comparaciones =0;
        long recorridos = 0;
        long tInicio, tFin;

        tInicio = System.nanoTime();
        for (int i = 1; i < numeros.length; i++) {
            recorridos++;
            for (int j = 0; j < numeros.length - i; j++) {
                comparaciones ++;
                if (numeros[j] > numeros[j + 1]) {
                    int aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                    intercambios++;
                }
            }
        }
        tFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion: " + (tFin - tInicio) + " nanosegundos");
        System.out.println("Cantidad de recorridos: " + recorridos);
        System.out.println("Cantidad de comparaciones: " + comparaciones);
        System.out.println("Cantidad de intercambios: " + intercambios);
    }

    public static void ordenamientoBurbuja2(int numeros[]) {
        long intercambios = 0;
        long recorridos = 0;
        long comparaciones = 0;
        long tInicio, tFin;
        int i = 1;
        boolean ordenado = false;

        tInicio = System.nanoTime();
        while (i < numeros.length && !ordenado) {
            recorridos ++;
            ordenado = true;
            for (int j = 0; j < numeros.length - i; j++) { 
                comparaciones ++;
                if (numeros[j] > numeros[j + 1]) {
                    ordenado = false;
                    int aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                    intercambios++;
                }
            }
            i++;
        }
        tFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion: " + (tFin - tInicio) + " nanosegundos");
        System.out.println("Cantidad de recorridos: " + recorridos);
        System.out.println("Cantidad de comparaciones: " + comparaciones);
        System.out.println("Cantidad de intercambios: " + intercambios);
    }

    public static void ordenamientoBurbuja3(int numeros[]) {
        long intercambios = 0, recorridos = 0, comparaciones = 0;
        long tInicio, tFin;
        int i = 1;
        int aux;
        boolean ordenado;

        tInicio = System.nanoTime();
        do {
            recorridos++;
            ordenado = true;
            for (int j = 0; j < numeros.length - i; j++) {
                comparaciones ++;
                if (numeros[j] > numeros[j + 1]) {
                    ordenado = false;
                    aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                    intercambios++;
                }
            }
            i++;
        } while (i < numeros.length && !ordenado);

        tFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion: " + (tFin - tInicio) + " nanosegundos");
        System.out.println("Cantidad de recorridos: " + recorridos);
        System.out.println("Cantidad de comparaciones: " + comparaciones);
        System.out.println("Cantidad de intercambios: " + intercambios);
    }
// ORDENAMIENTO QUICKSORT EVELYN 11/11/2026

    static long recorridosQS = 0;
    static long comparacionesQS = 0;
    static long intercambiosQS = 0;

    public static void ordenamientoQuiksort(int numeros[]){
        long tInicio, tFin;
        tInicio = System.nanoTime();
        
        recorridosQS = 0;
        comparacionesQS =0;
        intercambiosQS =0;

        if(numeros != null && numeros.length>1){
            quickSort(numeros, 0, numeros.length-1);
        }
        tFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion: " + (tFin - tInicio) + " nanosegundos");
        System.out.println("Cantidad de recorridos: " + recorridosQS);
        System.out.println("Cantidad de comparaciones: " + comparacionesQS);
        System.out.println("Cantidad de intercambios: " + intercambiosQS);
    }

    private static void quickSort(int[] numeros, int inicio, int fin){
        if(fin<= inicio)
            return;
        recorridosQS ++;
        int pivote = division(numeros, inicio, fin);
        quickSort(numeros, inicio, pivote-1);
        quickSort(numeros, pivote+1, fin);
        
    }
    private static int division(int[] numeros, int inicio, int fin){
        int pivote = numeros[fin];
        int i = inicio -1;

        for(int j = inicio; j< fin; j++){
            comparacionesQS ++;
            if(numeros[j]<pivote){
                i++;
                int temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
                intercambiosQS ++;
            }
        }
        i++;
        int temp = numeros[i];
        numeros[i] = numeros[fin];
        numeros[fin] = temp;
        intercambiosQS ++;

        return i;
    }


    //METODO DE ORDENAMIENTO SHELL SORT ALEXA 11/11/2026

    public void ordenamientoShellSort(int[] numeros){
        long tInicio, tFin;
        tInicio = System.nanoTime();
        long intercambios = 0, recorridos =0, comparaciones =0;
        int salto = numeros.length/2;

        while(salto>0){
            recorridos = 0;
            for(int i=salto; i<numeros.length; i++){
                int aux = numeros[i];
                int j = i;
                while(j>=salto && numeros[j-salto]>aux){
                    comparaciones++;
                    numeros[j] = numeros[j-salto];
                    j = j-salto;
                    intercambios ++;
                }
                if(j >= salto){
                    comparaciones ++;
                }
                numeros[j] = aux;
            }
            salto = salto/2;
        }
        tFin = System.nanoTime();
        System.out.println("Tiempo de ejecucion: " + (tFin - tInicio) + " nanosegundos");
        System.out.println("Cantidad de recorridos: " + recorridos);
        System.out.println("Cantidad de comparaciones: " + comparaciones);
        System.out.println("Cantidad de intercambios: " + intercambios);
    }

    //METODO RADIX CLAUDIA 13/11/2026
    public static void ordenamientoRadix(int[] numeros) {
        long tInicio, tFin;
        tInicio = System.nanoTime();
        long intercambios = 0, recorridos = 0, comparaciones = 0;
        int maxValor = numeros[0];

        for (int i = 0; i < numeros.length; i++) {
            comparaciones ++;
            int num = numeros[i];
            if (num > maxValor) {
                maxValor = num;
            }
        }

        int exp = 1;
        int[] contador = new int[10];
        int[][] cajitas = new int[10][numeros.length];

        while (maxValor / exp > 0) {
            recorridos ++;
            for (int i = 0; i < numeros.length; i++) {
                int num = numeros[i];
                int digito = (num / exp) % 10;

                cajitas[digito][contador[digito]] = num;
                contador[digito]++;
            }

            int indice = 0;
            for (int fila = 0; fila < 10; fila++) {
                for (int col = 0; col < contador[fila]; col++) {
                    numeros[indice] = cajitas[fila][col];
                    indice++;
                    intercambios++;
                }
                contador[fila] = 0;
            }
            exp *= 10;
        }

    tFin = System.nanoTime();
    System.out.println("Tiempo de ejecucion: " + (tFin - tInicio) + " nanosegundos");
    System.out.println("Cantidad de recorridos: " + recorridos);
    System.out.println("Cantidad de comparaciones: " + comparaciones);
    System.out.println("Cantidad de intercambios: " + intercambios);
    }

}// class




public class Sesion20_Algoritmos_Ordenamiento {
    public static void main(String[] args) {

      //  int[] datosOriginales = {9, 243, 1236, 2, 8, 9, 4, 2, 6, 7, 8, 9, 8, 76, 654, 3, 23, 456, 7, 8, 94, 1213};
      //  int[] datos = new int[datosOriginales.length];
        int[] tamanio = {1000, 10000, 100000, 1000000};

        for(int k =0; k <tamanio.length; k++){
            int n = tamanio[k];
            int[] datosOriginales = new int[n];
            int[] datos = new int[n];

            for(int i =0; i < n; i++){
                datosOriginales[i] = (int) (Math.random() * 100000);
            }

            System.out.println("=========== PRUEBA DE ALGORITMOS =========");

        // --- PRUEBA BURBUJA 1 ---
        System.out.println("\n------ BURBUJA 1 --------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
       // System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoBurbuja1(datos);
       // System.out.println("Datos despues: " + Arrays.toString(datos));

        // --- PRUEBA BURBUJA 2 ---
        System.out.println("\n------ BURBUJA 2 --------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
       // System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoBurbuja2(datos);
      //  System.out.println("Datos despues: " + Arrays.toString(datos));

        // --- PRUEBA BURBUJA 3 ---
        System.out.println("\n------ BURBUJA 3 --------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
       // System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoBurbuja3(datos);
       // System.out.println("Datos despues: " + Arrays.toString(datos));

        // --- PRUEBA QUICKSORT --- 
        System.out.println("\n ------ QUICKSORT ------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
       // System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoQuiksort(datos);
       // System.out.println("Datos despues: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoQuiksort(datos);

        // --- PRUEBA SHELL SORT ---
      //  MetodosOrdenamiento.ordenamientoShellSort(datos);
        System.out.println("\n ----- RADIX ------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
       // System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoRadix(datos);
       // System.out.println("Datos despues: " + Arrays.toString(datos));
        }
    }
}