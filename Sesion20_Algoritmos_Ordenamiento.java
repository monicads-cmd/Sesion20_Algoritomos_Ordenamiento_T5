import java.util.Arrays;


class MetodosOrdenamiento {

    public static void ordenamientoBurbuja1(int numeros[]) {
        int intercambios = 0;
        long tInicio, tFin;

        tInicio = System.nanoTime();
        for (int i = 1; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - i; j++) {
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
        System.out.println("Cantidad de intercambios: " + intercambios);
    }

    public static void ordenamientoBurbuja2(int numeros[]) {
        int intercambios = 0;
        long tInicio, tFin;
        int i = 1;
        boolean ordenado = false;

        tInicio = System.nanoTime();
        while (i < numeros.length && !ordenado) {
            ordenado = true;
            for (int j = 0; j < numeros.length - i; j++) { 
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
        System.out.println("Cantidad de intercambios: " + intercambios);
    }

    public static void ordenamientoBurbuja3(int numeros[]) {
        int intercambios = 0;
        long tInicio, tFin;
        int i = 1;
        int aux;
        boolean ordenado;

        tInicio = System.nanoTime();
        do {
            ordenado = true;
            for (int j = 0; j < numeros.length - i; j++) {
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
        System.out.println("Cantidad de intercambios: " + intercambios);
    }
// ORDENAMIENTO QUICKSORT EVELYN 11/11/2026

    public static void ordenamientoQuiksort(int numeros[]){
        long tInicio, tFin;
        tInicio = System.nanoTime();
        int intercambios = 0;
        if(numeros != null && numeros.length>1){
            quickSort(numeros, 0, numeros.length-1);
        }
        tFin = System.nanoTime();
            System.out.println("El tiempo de ejecucion fue> " + (tFin - tInicio) + " nanosegundos");
            System.out.println("Cantidad de intercambios: "+ intercambios);
    }

    private static void quickSort(int[] numeros, int inicio, int fin){
        if(fin<= inicio)
            return;
            int pivote = division(numeros, inicio, fin);
            quickSort(numeros, inicio, pivote-1);
            quickSort(numeros, pivote+1, fin);
        
    }
    private static int division(int[] numeros, int inicio, int fin){
        int pivote = numeros[fin];
        int i = inicio -1;

        for(int j = inicio; j< fin; j++){
            if(numeros[j]<pivote){
                i++;
                int temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
            }
        }
        i++;
        int temp = numeros[i];
        numeros[i] = numeros[fin];
        numeros[fin] = temp;

        return i;
    }


    //METODO DE ORDENAMIENTO SHELL SORT ALEXA 11/11/2026

    public void ordenamientoShellSort(int[] numeros){
        long tInicio, tFin;
        tInicio = System.nanoTime();
        int intercambios = 0;
        int salto = numeros.length/2;
        while(salto>0){
            for(int i=salto; i<numeros.length; i++){
                int aux = numeros[i];
                int j = i;
                while(j>=salto && numeros[j-salto]>aux){
                    numeros[j] = numeros[j-salto];
                    j = j-salto;
                }
                numeros[j] = aux;
            }
            salto = salto/2;
        }
        tFin = System.nanoTime();
        System.out.println("cantidad de tiempo> " + (tFin - tInicio)+ " nanosegundos");
        System.out.println("Intercambios> "+ intercambios);
    }

    //METODO RADIX CLAUDIA 13/11/2026
    public static void ordenamientoRadix(int[] numeros) {
        long tInicio, tFin;
        tInicio = System.nanoTime();
        int intercambios = 0;
        int maxValor = numeros[0];

        for (int i = 0; i < numeros.length; i++) {
            int num = numeros[i];
            if (num > maxValor) {
                maxValor = num;
            }
        }

        int exp = 1;
        int[] contador = new int[10];
        int[][] cajitas = new int[10][numeros.length];

        while (maxValor / exp > 0) {
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
    System.out.println("Cantidad de intercambios: " + intercambios);
    }

}// class




public class Sesion20_Algoritmos_Ordenamiento {
    public static void main(String[] args) {
        int[] datosOriginales = {9, 243, 1236, 2, 8, 9, 4, 2, 6, 7, 8, 9, 8, 76, 654, 3, 23, 456, 7, 8, 94, 1213};
        int[] datos = new int[datosOriginales.length];

        System.out.println("=========== PRUEBA DE ALGORITMOS =========");

        // --- PRUEBA BURBUJA 1 ---
        System.out.println("\n------ BURBUJA 1 --------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
        System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoBurbuja1(datos);
        System.out.println("Datos despues: " + Arrays.toString(datos));

        // --- PRUEBA BURBUJA 2 ---
        System.out.println("\n------ BURBUJA 2 --------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
        System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoBurbuja2(datos);
        System.out.println("Datos despues: " + Arrays.toString(datos));

        // --- PRUEBA BURBUJA 3 ---
        System.out.println("\n------ BURBUJA 3 --------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
        System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoBurbuja3(datos);
        System.out.println("Datos despues: " + Arrays.toString(datos));

        // --- PRUEBA QUICKSORT --- 
        System.out.println("\n ------ QUICKSORT ------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
        System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoQuiksort(datos);
        System.out.println("Datos despues: " + Arrays.toString(datos));

        MetodosOrdenamiento.ordenamientoQuiksort(datos);

        // --- PRUEBA SHELL SORT ---
      //  MetodosOrdenamiento.ordenamientoShellSort(datos);
        System.out.println("\n ----- RADIX ------");
        System.arraycopy(datosOriginales, 0, datos, 0, datosOriginales.length);
        System.out.println("Datos antes: " + Arrays.toString(datos));
        MetodosOrdenamiento.ordenamientoRadix(datos);
        System.out.println("Datos despues: " + Arrays.toString(datos));
    }
}