public class ConversorDeDivisasApp {

    public static void main(String[] args) {
        ConversorDeDivisas convertir = new ConversorDeDivisas("https://v6.exchangerate-api.com/v6/edc9e5450d9143516a2735fb/latest/");
        InterfazDeUsuario ui = new InterfazDeUsuario(convertir);
        ui.ejecutar();
    }
}
