import java.util.Scanner;

public class PruebaLibroCalificacionesMejorado {
    //el metodo main comienza la ejecucion del programa
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Numero de Estudiantes");
        int numEstudiantes = scan.nextInt();

        System.out.println("Numero De Examenes");
        int numExamenes = scan.nextInt();

        LibroCalificacionesMejorado miLibroCalificaciones = new LibroCalificacionesMejorado("CS101 Introduccion a la programacion en Java", numEstudiantes,numExamenes);

        for (int numeroEstudiantes = 0; numeroEstudiantes < numEstudiantes; numeroEstudiantes++) {
            for (int numeroExamenes = 0; numeroExamenes < numExamenes; numeroExamenes++) {
                System.out.printf("Ingrese la calificación para el estudiante %d en el examen %d: ", numeroEstudiantes + 1, numeroExamenes + 1);
                int calificacion = scan.nextInt();
                miLibroCalificaciones.setCalificaciones(numeroEstudiantes,numeroExamenes, calificacion);
            }
        }
        System.out.printf("Bienvenido al libro de calificaciones para%n%s%n%n", miLibroCalificaciones.getNombreDelCurso());
        miLibroCalificaciones.procesarCalificaciones();
    }
}
