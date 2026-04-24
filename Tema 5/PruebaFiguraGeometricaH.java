public class PruebaFiguraGeometricaH {
    public static void main(String[] args) {
        CirculoH c = new CirculoH(2);
        RectanguloH r = new RectanguloH(4,7);
        c.setColor("Rojo");
        r.setColor("Verde");
        System.out.println("El círculo es de color " + c.getColor());
        System.out.println("Área del círculo " + c.area());
        System.out.println("El rectángulo es de color " + r.getColor());
        System.out.println("Área del rectángulo " + r.area());
    }
}
