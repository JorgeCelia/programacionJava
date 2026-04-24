public class Partido {
    private static Jugador[] jugadores = new Jugador[4];
    public static void main(String[] args) {
        // 1. COMPLETAR: inicializar las 4 jugadores
        jugadores[0] = new Portero("John James", 1);
        jugadores[1] = new Defensa("Juanpe Tardo", 9);
        jugadores[2] = new Centrocampista("Luisma Tao", 5);
        jugadores[3] = new Delantero("Armando Guerra", 10);

        // 2. COMPLETAR: presentar a los jugadores
       System.out.println("=== SALTAN AL CAMPO ===");
       for (Jugador j: jugadores) {
            System.out.println(j.toString());
       }

      // 3. COMPLETAR: jugar el partido
       System.out.println("=== EMPIEZA EL PARTIDO ===");
       jugadores[1].cometePenalti();
       jugadores[0].paraPenalti();
       jugadores[3].marcaGol();
       jugadores[2].tarjetaAmarilla();
       jugadores[0].encajaGol();
       jugadores[1].marcaGol();

      // 4. COMPLETAR: presentar de nuevo a los jugadores
       System.out.println("=== FIN DEL PARTIDO ===");
       for (Jugador j: jugadores) {
            System.out.println(j.toString());
       }
    }
}
