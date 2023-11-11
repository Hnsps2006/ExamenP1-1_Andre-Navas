/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication18; 

import java.util.Scanner; //importo archivos externos en este caso el scanner para leer
import java.util.Random; //nuevamente impporto pero esta vez para crear numeros aleatorios mas adelante
/**
 *
 * @author eliza
 */
public class JavaApplication18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   //comienza mi main
        Scanner entrada = new Scanner(System.in); //creo scanner 
        System.out.print("Bienvenido a mi programa"); //bienvenida x
        entrada.nextLine();
        // esto obliga al usuario a hacer enter para que el programa pueda seguir 
        int opcion=8;
        while(opcion==8){ //ciclo de menu que se cumplira solo si opcion es 8
            System.out.println("Elija una de las siguientes ocpiones: ");
            System.out.println("1. opcion 1. Dígito Solitario vs Dígito Popular");
            System.out.println("2. opcion 2. Cintas magnéticas");
            System.out.println("3. opcion 3. Descifra la combinación");
            System.out.println("4. opcion 4. bonus ");
            System.out.println("5. opcion 5. Salir");
            int option = entrada.nextInt(); 
            entrada.nextLine();
            // sirve para leer un entero y darle la option al usuario
            //de ingresar un numero 
            switch (option) {   
                
                case 1: //comienza el caso 1
                    System.out.println("No se pudo pero se intento");
                    System.out.print("Ingrese un número entero positivo mayor a 999: ");
                        int numero = entrada.nextInt();
                        entrada.nextLine();

                        String resultado = encontrarDigitosSolitariosYPopulares(numero);
                        System.out.println(resultado);
                    System.out.println("Desea continuar s/n"); //le obligo a ingresar al usuario un numero entero que simulara 
                    String respuesta = entrada.next();
                    opcion=8;
                    if (respuesta=="n"){
                            opcion=3;
                        }
                    break;
                case 2:
                System.out.print("Ingrese una cadena: ");
                String cadena = entrada.next(); // Se solicita al usuario que ingrese una cadena de texto

                for (int i = 0; i < cadena.length(); i++) {
                    char caracter = cadena.charAt(i); // Se obtiene el carácter en la posición i de la cadena
                    int valorAscii = (int) caracter; // Se obtiene el valor ASCII del carácter

                    String binario = convertirABinario(valorAscii); // Se convierte el valor ASCII a su representación en binario
                    String binarioConParidad = agregarBitParidad(binario); // Se agrega un bit de paridad al valor binario

                    System.out.println("Carácter: " + caracter); // Se muestra el carácter original
                    System.out.println("Valor en Ascii: " + valorAscii); // Se muestra el valor ASCII del carácter
                    System.out.println("Valor en binario: " + binario); // Se muestra el valor en binario
                    System.out.println("Valor en binario con bit de paridad: " + binarioConParidad); // Se muestra el valor en binario con el bit de paridad
                    System.out.println();
                }

                System.out.println("Desea continuar s/n"); // Se le pide al usuario que ingrese si desea continuar o no
                String respuesta1 = entrada.nextLine(); // Se lee la respuesta del usuario
                opcion=8; // Se asigna un valor a la variable "opcion" para salir del bucle
                    if (respuesta1=="n"){
                            opcion=3;
                        }
                    break;
                case 3:
                    System.out.println("Usted ha elegido la opción número 4.Cintas magnéticas");
                    combinacion();
                    System.out.println("Desea continuar s/n"); //le obligo a ingresar al usuario un numero entero que simulara 
                    String respuesta2 = entrada.nextLine();
                    opcion=8;
                    if (respuesta2=="n"){
                    opcion=3;
                        }
                    break;
                case 4:
                    System.out.println("Usted ha elegido la opción número 4.Bonus");
                    System.out.println("Bonus"); 
                    System.out.println("Desea continuar s/n"); //le obligo a ingresar al usuario un numero entero que simulara 
                    String respuesta3 = entrada.nextLine();
                    opcion=8;
                    if (respuesta3=="n"){
                            opcion=3;
                        }
                    break;
                case 5:
                    System.out.println("Usted ha elegido la opción número 5.Salir"); 
                    System.out.println("Elegiste la opcion de salir");
                    System.out.println("Desea continuar s/n"); //le obligo a ingresar al usuario un numero entero que simulara 
                    String respuesta4 = entrada.nextLine();
                    if (respuesta4=="s"){
                        opcion=8;
                    }
                    if (respuesta4=="n") {
                        opcion=6;
                    } 
                    else{
                        System.out.println("No invente, ponga opcion valida porfavor"); 
                        opcion=8;
                    }
                    break;
                default:
                    System.out.println("Deje de estar inventando y ponga opcion valida");
                    opcion=8;
                    break;
            }
        }
    }
  
//* Esto es como un ciclo donde uno tiene diferentes caminos a tomar,
//que son los case, la funcion del swicth es poner la condición como si
//fuera un if, el break sirve para terminar el ciclo (en otras palabras 
//terminar con el caso y no seguir adelante.La condición se pone adentro
// de los parentesis. //*



 public static String convertirABinario(int valorDecimal) {
            String binario = "";

            // Convertir a binario
            while (valorDecimal > 0) {
                int residuo = valorDecimal % 2; //se consigue el residuo
                binario = residuo + binario; //residuo+binario guardando el residuo cada vez que se repite ciclo en binario
                valorDecimal = valorDecimal / 2;  //valor decimal entre dos
            }

            // Agregar ceros a la izquierda hasta que tenga 8 bits
            while (binario.length() < 8) {
                binario = '0' + binario;
            }

            return binario;
        }

        // Agrega un bit de paridad al final del código binario
        public static String agregarBitParidad(String binario) {
            int unos = 0;
            int ceros = 0;

            // Contar unos y ceros en el código binario
            for (int i = 0; i < binario.length(); i++) {
                if (binario.charAt(i) == '1') {
                    unos++;
                } else {
                    ceros++;
                }
            }

            // Agregar el bit de paridad
            if ((unos + ceros) % 2 == 0) {
                return binario + '0'; // Bit de paridad 0 si la suma de unos y ceros es par
            } else {
                return binario + '1'; // Bit de paridad 1 si la suma de unos y ceros es impar
            }
        }


//Estas funciones forman parte de un conversor de valores decimales a binarios y agregan un bit de paridad al final del código binario para propósitos de detección de errores. convertToBinary convierte un valor decimal a binario y asegura que tenga 8 bits, mientras que addParityBit agrega un bit de paridad al final del código binario dependiendo de la paridad de unos y ceros en el código.

    
   public static void combinacion() {
        // Inicializar el Scanner para la entrada del usuario y el generador de números aleatorios
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Mostrar opciones de dificultad al usuario
        System.out.println("Seleccione la dificultad:");
        System.out.println("1. Fácil");
        System.out.println("2. Media");
        System.out.println("3. Difícil");

        // Leer la elección de dificultad del usuario
        int dificultad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de la entrada

        // Variables para almacenar el tamaño de la combinación y los intentos restantes
        int tamano;
        int intentosRestantes;

        // Configurar la dificultad según la elección del usuario
        switch (dificultad) {
            case 1:
                tamano = 6;
                intentosRestantes = 26;
                break;
            case 2:
                tamano = 8;
                intentosRestantes = 22;
                break;
            case 3:
                tamano = 10;
                intentosRestantes = 18;
                break;
            default:
                // Mensaje de salida si la dificultad ingresada no es válida
                System.out.println("Dificultad no válida. Saliendo del programa.");
                return;
        }

        // Generar combinación aleatoria 
        String combinacion = "";
        String progreso = "";

        // Generar combinación aleatoria
        for (int i = 0; i < tamano; i++) {
            // Generar una letra aleatoria entre 'A' y 'Z'
            char letra = (char) (random.nextInt(26) + 'A');

            // Agregar la letra a la combinación
            combinacion += letra;

            // Agregar un guion '-' al progreso (representando que la letra no ha sido adivinada)
            progreso += "-";
        }


        // Juego
        while (intentosRestantes > 0 && !combinacion.equals(progreso)) { 
            System.out.println("Progreso: " + progreso);
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.print("Ingrese una letra: ");
            char letraUsuario = scanner.nextLine().toUpperCase().charAt(0); //mayuscualas aceptables 

            boolean acierto = false;

            // Verificar si la letra ingresada está en la combinación  
             for (int i = 0; i < tamano; i++) {
                if (combinacion.charAt(i) == letraUsuario) { 
                    progreso = progreso.substring(0, i) + '+' + progreso.substring(i + 1);
                    acierto = true;
                }
            }

            // Actualizar intentos y dar mensaje al usuario
            if (acierto) {
                System.out.println("¡Bien hecho! La letra está en la combinación.");
            } else {
                System.out.println("¡Oops! La letra no está en la combinación.");
                intentosRestantes--;
            }

            System.out.println(); // Salto de línea
            if (progreso.equals("++++++")||progreso.equals("++++++++") || progreso.equals("++++++++++" )) {
                System.out.println("++++++");
                break;
            }
        }
        
        // Mostrar resultado final
        if (combinacion.equals(progreso)) {
            System.out.println("¡Felicidades! Has desactivado la bomba.");
        } else {
            System.out.println("¡Boom! La bomba ha explotado. La combinación era: " + combinacion);
        }
    }
}