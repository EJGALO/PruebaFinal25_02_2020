# PruebaFinal26_02_2020
Archivos finales de la prueba grupal. Daniel Diaz, Eduardo Galo, Tatiana Iturriaga.
@Autores 
Daniel Diaz
Eduardo Galo
Tatiana Iturriaga


Este proyecto se realiza en el cuadro de la evaluación grupal de las clases de programación Java Full Stack de Talento Digital.  La tarea consiste en realizar un programa capaz de ejecutar una simulación similar al juego Batalla Naval. En este caso, se lanzan huevos a diferentes vehículos en un tablero de 15x15. Nuestro código tiene que ser capaz de generar y posicionar los vehículos en el tablero y luego, al nosotros ingresar las coordenadas de lanzamiento del huevo, saber donde cayó el huevo y si este golpeó algún objetivo. Si dicha situación ocurre, el jugador ganará puntos, y será bonificado si logra derribar vehículos enteros.
El ejercicio presenta múltiples desafíos, que para ser abordados se decidió de separar en diferentes temas.
## Clases
1.	Se crea la clase padre Carro con las variables ocupantes, fecha de ingreso y coordenadas x, y con sus respectivos setters, getters y constructores.
2.	Se crea la clase Kromi, clase hija de Carro con las variables año de fabricación y marca y su respectivo constructor.
3.	Se crea la clase Caguano, clase hija de Carro con las variables alcance de tiro y color de confeti y su respectivo constructor.
4.	Se crea la clase Huevo, en la cual se registran las coordenadas de todos los lanzamientos hechos, así como sus respectivos setters y getters. 
5.	Se crea la clase Tablero, la cual contiene un arreglo con todos los vehículos del tablero y los métodos para, calcular el puntaje, calcular el puntaje final, crear la matriz al momento de iniciar el juego y el método para mostrar la matriz final, revelando la posición de los carros. 

## Posicionamiento y creación del tablero. 
1.	Se crearon 3 matrices bidimensionales en las cuales se registran las coordenadas de los vehículos que harán parte del tablero. Un arreglo C, K y T, cada uno para su respectivo vehículo. Ademas, se crea una matriz bidimensional auxiliar, que superpone los diferentes arreglos con la finalidad de determinar la posición de los cuerpos de cada vehículo. 
2.	Luego de crear dichas matrices, se rellenaron con 0. Esto se hace para luego rellenar con 1s las posiciones de la matriz en la cual existen vehículos. 
3.	Se llama al método math.random para asignar las coordenadas aleatorias para 10 espacios del arreglo T, y C y finalmente 9 espacios del arreglo K. 
4.	Para prevenir la superposición de los diferentes vehículos en nuestro tablero de 15x15, optamos por comparar las coordenadas de todos los arreglos T, C y K, y de existir algún arreglo con las mismas coordenadas que el nuevo espacio a registrar, este se calcularía de nuevo hasta encontrar un espacio que no esté ocupado por alguno de los otros vehículos.  Se procede así a asignar las coordenadas en el tablero de las Trupallas, Caguanos y Kromis.
5.	Finalmente, se genera el tablero mostrando en pantalla una serie de líneas que conforman un tablero de 15x15 a través de ciclos for. A su vez, se recorren los arreglos K, T,C y de haber un 1 en las coordenadas actual del ciclo, se imprime la letra correspondiente al arreglo.

}

## Puntuación y huevos

1.	Para asignar la puntuación, se utiliza el método calcular_puntaje_total de la clase Tablero. En este se crean dos atributos, bonusCaguano y bonusKromi, inicializados con los valores pedidos por el ejercicio. Esto se hace para facilitar la edición del código. 
2.	Para calcular los puntos se compara el arreglo H (arreglo de los Huevos) con los arreglos T, C y K, que fueron superpuestos en un solo arreglo auxiliar. Sabemos que si en el espacio consultado del arreglo este tiene un 0 es porque no existe un vehículo, también sabemos que si el arreglo del huevo contiene un 1 es porque un huevo fue lanzado allí. Por lo tanto, de comparar los arreglos con el arreglo H, podemos determinar si es que el huevo golpeó o no alguno de los vehículos. 
3.	En una primera instancia, para calcular los bonus y saber si el jugador destruyó un Caguano o una Kromi, revisamos las coordenadas del arreglo C y K. Por ejemplo, si el arreglo K en x,y coordenadas == 1, procederemos a comparar las dos casillas que se encuentran debajo de la Kromi (porque sabemos que las Kromis ocupan 3 espacios en total), un ejemplo de esto sería:
                             if(K[i][j]==1) {
		puntaje=puntaje+3;
if(H[i+1][j]==1&&H[i+2][j]==1){
puntaje=puntaje+bonusKromi;}}
Si bien esta respuesta parecía ser suficiente, no consideraba la posibilidad de generar Kromis o Caguanos en fila, por lo tanto, se optó por utilizar el arreglo auxiliar, el cual siempre encontrará la “cabeza” de la Kromi o el Caguano.

## Limites 
No se creo el método datosBasicos. 
A su vez, está ausente el arraylist en el cual se registran los lanzamientos realizados por el usuario. 
