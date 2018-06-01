import acm.program.GraphicsProgram;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new joc().start(args);
    }
    public static class joc extends GraphicsProgram {
        @Override
        public void run() {
            setSize(1025,725);
//            GImage fons = new GImage("..\\imatges\\fons.jpg"); fons.setSize(getWidth(),getHeight());
//            add(fons,0,0);

            ArrayList<AnimalAcuatic> animals = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                animals.add(new PeixNormal());
                animals.add(new Dofi());
                animals.add(new Tauro());
            }

            for (AnimalAcuatic animal:animals) {
                add(animal.getAnimal(), generarRandom(animal, getWidth(), animal.getAnimal().getWidth()),
                        generarRandom(animal, getHeight(), animal.getAnimal().getHeight())
                );
            }

            while (animals.size()>1){

                for (AnimalAcuatic animal:animals) {
                    animal.nadar(getWidth(),getHeight());

                }
            }
        }
        public int generarRandom(AnimalAcuatic animal,int numero, double dadaAnimal){
            Random random = new Random();

            return random.nextInt( ((int) (numero - dadaAnimal)));
        }
    }
}
