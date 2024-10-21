public class Seleccion {
    String base;
    String target;
    float amount;

    public ConversioDeMoneda activarOpcion(int opcion, float amount) {

        switch (opcion) {
            case 1:
                this.base = "USD";
                this.target = "ARS";
                break;
            case 2:
                this.base = "ARS";
                this.target = "USD";
                break;
            case 3:
                this.base = "USD";
                this.target = "BRL";
                break;
            case 4:
                this.base = "BRL";
                this.target = "USD";
                break;
            case 5:
                this.base = "USD";
                this.target = "COP";
                break;
            case 6:
                this.base = "COP";
                this.target = "USD";
                break;
        }


        BusquedaConversionDeMoneda cambio = new BusquedaConversionDeMoneda();
        ConversioDeMoneda resultado = cambio.conversion(this.base, this.target, amount);

        return resultado;

    }
}
