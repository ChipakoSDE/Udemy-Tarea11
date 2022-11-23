import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalcularEdad {
    public static void main(String[] args) {

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Scanner s = new Scanner(System.in);
        System.out.println("Por favor ingrese su fecha de nacimiento con el formato (dd-mm-yyyy)");
        try {
            Calendar nac = Calendar.getInstance(); // creo una instancia de calendario para fecha nacimiento
            Calendar actual = Calendar.getInstance(); // creo una instancia de calendario para fecha actual
            Date fechaNacimiento = df.parse(s.next()); // creo una instancia de Date para fecha de nacimiento
            Date fechaActual = new Date(); // creo una instancia de Date para fecha actual

            nac.setTime(fechaNacimiento);
            actual.setTime(fechaActual);

            int edad = actual.get(Calendar.YEAR) - nac.get(Calendar.YEAR);
            if (actual.get(Calendar.MONTH) < nac.get(Calendar.MONTH) ||
                    (actual.get(Calendar.DAY_OF_MONTH) < nac.get(Calendar.DAY_OF_MONTH) && actual.get(Calendar.MONTH) == nac.get(Calendar.MONTH))){
                edad -= 1;
                System.out.println("La edad es " + edad + " años");
            } else {
                System.out.println("La edad es " + edad + " años");
            }

        } catch (ParseException e) {
            System.out.println("Por favor ingrese la fecha con el formato solicitado");
            main(args);
        }

    }
}
