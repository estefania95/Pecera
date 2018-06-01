import acm.graphics.GImage;

import java.util.ArrayList;
import java.util.Random;

public abstract class AnimalAcuatic implements Animal{
    protected GImage animal;
    protected int llargada;
    protected int altura;
    protected String direccio;
    protected boolean Mascle;

    public AnimalAcuatic(){}

    public boolean isMascle() { return Mascle; }

    public GImage getAnimal() { return animal; }

    public abstract void nadar(int getWidth,int getHeight);
    public abstract void direccioRandom(Random random);
    public abstract void imatgeAnimal(Random random);

    @Override
    public ArrayList<AnimalAcuatic> morir(ArrayList<AnimalAcuatic> animals) {
        return null;
    }

    @Override
    public ArrayList<AnimalAcuatic> reproduirse(ArrayList<AnimalAcuatic> animals) {
        return null;
    }
}
