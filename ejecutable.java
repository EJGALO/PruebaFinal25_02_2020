package prueba_grupal;

import java.util.Scanner;


public class ejecutable 
{static Scanner read= new Scanner(System.in);
public static void main(String[] args)
{	int op;
	int x=0;
	int y=0;



	Tablero tab = new Tablero();
	tab.setaux();
	tab.setcarros();
	int [][]H=new int[15][15]; // Arreglo de Huevos a lanzar. 
	for(int i = 0; i<15;i++) 
	{
		for(int j=0;j<15;j++)
		{
			H[i][j]=0; // se llena con 0s para saber que no hay huevos lanzados.
		}
	}
			
	int[][]K=new int[15][15];// ARREGLO KROMIS
	for(int i = 0; i<15;i++) 
	{
		for(int j=0;j<15;j++)
		{
			K[i][j]=0;
		}
	}
	int[][]C=new int[15][15];// ARREGLO CAHUANO
	for(int i = 0; i<15;i++) 
	{
		for(int j=0;j<15;j++)
		{
			C[i][j]=0;
		}
	}
	int[][]T=new int[15][15];// ARREGLO TRUPALLA
	for(int i = 0; i<15;i++) 
	{
		for(int j=0;j<15;j++)
		{
			T[i][j]=0;
		}
	}
	int cont=0;
	while(cont<10)// contador 10 = Trupallas
	{
		x=tab.dame_x(cont);// Se obtienen las coordenadas de las Trupallas
		y=tab.dame_y(cont);
		if(T[x][y]==0)
		{
		T[x][y]=1; // se le asigna un 1 en la posicion donde se haya ubicado una Trupalla
		cont++;
		}
		
	}

	while(cont<15)//contador 15 = suma Caguanos +Trupallas
	{
		x=tab.dame_x(cont); // Se obtienen las coordenadas de los Caguanos
		y=tab.dame_y(cont);
		if(C[x][y]==0&&T[x][y]==0&&C[x][y+1]==0&&T[x][y+1]==0)// Se comprueba que los espacios no esten ocupados
		{ 
		C[x][y]=1;
		C[x][y+1]=1;// Se asigna la posicion en el arreglo. 
		cont++;
		}

	}

	while(cont<18) // contador hasta 18, = suma de todos los vehiculos
	
	{
		x=tab.dame_x(cont);
		y=tab.dame_y(cont);
		if(K[x][y]==0&&C[x][y]==0&&T[x][y]==0&&K[x+1][y]==0&&C[x+1][y]==0&&T[x+1][y]==0
				&&K[x+2][y]==0&&C[x+2][y]==0&&T[x+2][y]==0)
		{
		K[x][y]=1;
		K[x+1][y]=1;
		K[x+2][y]=1;// se asegura haber disponibilidad para asignar los espacios de la Kromi
		cont++;
		}
	}

	do
	{
	System.out.println("OPCIONES DE JUEGO");
	System.out.println("1.- LANZAR HUEVO");
	System.out.println("2.- VER PUNTAJE");
	System.out.println("3.- SALIR");
	op=read.nextInt();
	if(op==1)
	{
		System.out.println("INGRESE FILA");
		x=read.nextInt();
		System.out.println("INGRESE COLUMNA");
		y=read.nextInt();
		H[x-1][y-1]=1;// se realiza la resta de -1 para que los datos ingresados
		// por el usuario sean representativos de la posicion de los arreglos 
		
		
		tab.mostrar_matriz(K, C, T, H, x, y); // se muestra matriz vacia 
		
	}
		if(op==2)
	{
		int puntaje= tab.calcular_puntaje(K, C, T, x-1, y-1);
		System.out.println("el puntaje obtenido es "+puntaje);
		System.out.println("");
	}
		if(op==3)
		{
			
			tab.mostrar_matriz_final(K, C, T, H); // se muestra matriz con Huevos lanzados + 
												// posicion de los carros
			System.out.println("");
			System.out.println("___________________________________________________________________________________________________________");
			System.out.println("");
			System.out.println("el puntaje final es "+tab.calcular_puntaje_total(K, C, T, H));
		}
	}while(op!=3);
	
	
}//FIN MAIN
}//FIN CLASE