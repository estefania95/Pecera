import acm.graphics.GImage;

import java.util.ArrayList;
import java.util.Random;

public class Tauro extends AnimalAcuatic{
    private String direccio;
    private boolean Mascle;

    public Tauro() {
        super();
        Random random = new Random();

        this.llargada = 130;
        this.altura = 130;
        direccioRandom(random);
        this.Mascle = random.nextBoolean();
        imatgeAnimal(random);
        animal.setSize(this.llargada, this.altura);
    }

    public boolean isMascle() {
        return Mascle;
    }

    public void direccioRandom(Random random) {
        int num = random.nextInt(4);
        switch (num) {
            case 0:
                this.direccio = "dreta";
                break;
            case 1:
                this.direccio = "esquerra";
                break;
            case 2:
                this.direccio = "adalt";
                break;
            case 3:
                this.direccio = "abaix";
                break;
        }
    }

    public void imatgeAnimal(Random random) {
        int num = random.nextInt(4);
        String sexe;
        if (Mascle) {
            sexe = "m";
        } else {
            sexe = "f";
        }

        this.animal = new GImage("imatges\\Tauro\\Tauro_" + sexe + "_" + this.direccio + ".png");
    }

    @Override
    public void nadar(int getWidth, int getHeight) {
        final int avanca = 5;
        if (this.direccio.equals("dreta")) {
            for (int i = 0; i < avanca; i++) {
                animal.move(1, 0);
                animal.pause(3);
            }
            if (animal.getX() >= getWidth) {
                animal.setLocation(0, animal.getY());
            }

        } else if (this.direccio.equals("esquerra")) {
            for (int i = 0; i < avanca; i++) {
                animal.move(-1, 0);
                animal.pause(1);
            }
            if (animal.getX() + llargada <= 0) {
                animal.setLocation(getWidth - llargada, animal.getY());
            }

        } else if (this.direccio.equals("abaix")) {
            for (int i = 0; i < avanca; i++) {
                animal.move(0, 1);
                animal.pause(1);
            }
            if (animal.getY() >= getHeight) {
                animal.setLocation(animal.getX(), 0);
            }

        } else {
            for (int i = 0; i < avanca; i++) {
                animal.move(0, -1);
                animal.pause(1);
            }
            if (animal.getY() + altura <= 0) {
                animal.setLocation(animal.getX(), getHeight - altura);
            }

        }

    }

    @Override
    public ArrayList<AnimalAcuatic> reproduirse(ArrayList<AnimalAcuatic> animals) {
        animals.add(new Tauro());

        return animals;
    }
}
