// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LibroCalificacionesMejorado
{

    private String nombreDelCurso; // nombre del libro que representa este libroCalificaciones
    private int[][] calificaciones; // arreglo de calificaciones de estudiantes

    // contructor
    public LibroCalificacionesMejorado(String nombreDelCurso, int numeroEstudiantes, int numeroExamenes)
    {
        this.nombreDelCurso = nombreDelCurso;
        this.calificaciones = new  int[numeroEstudiantes][numeroExamenes];

        for (int i = 0; i < numeroEstudiantes; i++) {
            for (int j = 0; j < numeroExamenes; j++) {
                calificaciones[i][j] = -1;
            }
        }
    }


    public void setCalificaciones(int numeroEstudiantes, int numeroExamenes, int calificacion)
    {
        if (numeroEstudiantes >= 0 && numeroEstudiantes < calificaciones.length &&
                numeroExamenes >= 0 && numeroExamenes < calificaciones[numeroEstudiantes].length) {
            calificaciones[numeroEstudiantes][numeroExamenes] = calificacion;
        } else {
            System.out.println("Índices de estudiante o examen fuera de rango.");
        }
    }

    //metodo para establecer el nombre del curso
    public void setNombreDelCurso(String nombreDelCurso)
    {
        this.nombreDelCurso = nombreDelCurso;
    }

    //metodo para obtener el nombre del curso
    public String getNombreDelCurso()
    {
        return this.nombreDelCurso;
    }
    // realiza varias operaciones de los datos
    public void procesarCalificaciones()
    {
        // imorime el arreglo calificaciones en pantalla
        imprimirCalificacion();


        // llama a los metodos getMinima y getMaxima
        System.out.printf("La calificacion mas baja es: %d%n La calificacion mas alta es: %d%n%n",getMinima(),getMaxima());

        // llama a imprimirGraficoBarras para imprimir el grafico de distribucion
        imprimirGraficosBaarras();
    }
    public void imprimirCalificacion()
    {
        System.out.println("Las Calificiones Son:\n");
        System.out.print("              "); // alinea encaabezados de colunnas

        // crea un encabezado de columna para cada una de las pruebas
        for (int prueba = 0; prueba < calificaciones[0].length; prueba++) {
            System.out.printf("Prueba %2d ",prueba + 1);
        }
        System.out.println(" Promedio"); // encabezado de columna de promedio de estudiantes

        // crea filas/columnas de texto que representa el arreglo calificcaciones
        for (int estudiante = 0; estudiante < calificaciones.length; estudiante++)
        {
            System.out.printf("Estudiante %d", estudiante + 1);

            for (int prueba : calificaciones[estudiante]) {
                System.out.printf("%8d",prueba);
            }
            //llama al metodo obtener promedio para calcular la calififcacion promedio del estudiante
            // pasa fila de calificaciones como argumentos para obtenerPromedio
            double promedio = getPromedio(calificaciones[estudiante]);
            System.out.printf("%15f%n",promedio);
        }
    }
    // busca la calificacion mas baja
    public int getMinima()
    {
        // asume que el primer elemento del arreglo es el mas bajo
        int califBaja = calificaciones [0][0];

        //itera aatravez de las filas del arreglo calificaciones
        for (int[] califEstudiantes : calificaciones)
        {
            // itera atraves de las columnas de la fila actual
            for (int calificacion : califEstudiantes)
            {
                // si la calificacion es menor que califBaja, la asigna a califBaja
                if (calificacion < califBaja) {
                    califBaja = calificacion;
                }
            }
        }
        return califBaja;
    }

    // busca la calificacion mas alta
    public int getMaxima()
    {
        //asume que el primer elemento del arreglo Calificaciones es el mas alto
        int califAlta = calificaciones [0][0];

        // itera atraves de las filas del arreglo calificaciones
        for (int[] califEstudiante : calificaciones)
        {
            // itera atraves de la columna de la fila actual
            for (int calificacion : califEstudiante)
            {
                // si la calificacion es mayor que califAlta, la asigna a califAlta
                if (calificacion > califAlta) {
                    califAlta = calificacion;
                }
            }

        }
        return califAlta;
    }
    // determina la calificacion promedio para un conjunto especifico de calificaciones
    public double getPromedio(int[] conjuntoDeCalif)
    {
        int total = 0;

        //suma las calififcacion para un estuduiante
        for (int calificacion: conjuntoDeCalif) {
            total += calificacion;
        }
        //devuelve el promedio de calificaciones
        return (double) total / conjuntoDeCalif.length;
    }


    // imprimir grafico de barra que muestra la distribucion de las calificaciones
    public void imprimirGraficosBaarras()
    {
        System.out.println("Distribucion De Las Calificaciones:");
        //almacena las frecuencia de las calificaciones en cada rango de 10 calificaciones
        int[] frecuencia = new int[11];

        // para cada calificacion, incrementa la frecuencia apropiada
        for (int[] estudiante : calificaciones ) {
            for (int calificacion : estudiante) {
                ++frecuencia[calificacion / 10];
            }
        }
        // para cada frecuencia de calificacion imprime una barra en el grafico
        for (int cuenta = 0; cuenta < frecuencia.length; cuenta++)
        {
            //imprime etiqueta de barra ("00-09: ", ...., "90-99: ", "100: ")
            if (cuenta == 10)
            {
                System.out.printf("%5d: ",100);
            } else {
                System.out.printf("%2d-%2d: ",cuenta * 10, cuenta * 10 + 9);
            }

            for (int estrellas = 0; estrellas < frecuencia[cuenta]; estrellas++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
