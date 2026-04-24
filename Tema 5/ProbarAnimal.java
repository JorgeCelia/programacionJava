class ProbarAnimal {

   public static void main(String[] args) {
      //Creo un array de animales
      Animal animales [] = new Animal[3];

      //Introduzco uno de cada
      animales[0] = new Animal();
      animales[1] = new Perro("Bobby");
      animales[2] = new Gato("Loki");

      //Recorro el array y hago que cada animal haga su sonido
      for (int i=0; i<animales.length; i++) {
         animales[i].hacerSonido();
      }

      //Recorro el array presentando a los animales
      for (Animal a : animales) {
         a.presentarse();
      }
   }

}
