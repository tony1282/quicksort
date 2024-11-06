import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class quickSort {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada; 

    // Método para pedir los datos 
    public static int[] pedirDatos() throws IOException {
        // Tamano del arreglo
        System.out.println("Ingresa el tamano del arreglo:");
        entrada = bufer.readLine(); 
        int n = Integer.parseInt(entrada); 
        
        // Crear un arreglo de enteros 
        int[] datos = new int[n];
        
        // pide los datos al usuario 
        System.out.println("Ingresa los datos a ordenar:");
        // Bucle para pedir cada elemento
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            entrada = bufer.readLine(); 
            datos[i] = Integer.parseInt(entrada); 
        }
        
        
        return datos; 
    }

    
    public static void MquickSort(int[] arreglo, int izquierda, int derecha) {
        // si tiene un solo elemento no se ordena
        if (izquierda >= derecha) return; 
        
        // Elegir el primer elemento como pivote
        int pivote = arreglo[izquierda];
        int i = izquierda; 
        int j = derecha; 
        int temp; // Variable temporal para intercambiar los elementos
        
        // Bucle para colocar los elementos menores que el pivote a la izquierda y los mayores a la derecha
        while (i < j) {
            // Mover j hacia la izquierda cuando los elementos sean mayores o iguales al pivote
            while (i < j && arreglo[j] >= pivote) j--;
            // Mover i hacia la derecha mientras los elementos sean menores o iguales al pivote
            while (i < j && arreglo[i] <= pivote) i++;
            // Si i < j intercambiar los elementos en i y j
            if (i < j) {
                temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        // Colocar el pivote en la posicion correcta
        arreglo[izquierda] = arreglo[j];
        arreglo[j] = pivote;

        // ordena los arreglos
        MquickSort(arreglo, izquierda, j - 1); 
        MquickSort(arreglo, j + 1, derecha);
    }

   
    public static void main(String[] args) throws IOException {
        // se manda a llamar el metodo pedir datos 
        int[] arreglo = pedirDatos(); 
        
        // se manda a llamar el metodo quickSort 
        MquickSort(arreglo, 0, arreglo.length - 1); 

        // mostrar el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) { 
            System.out.print(num + " ");
        }
    }
}
