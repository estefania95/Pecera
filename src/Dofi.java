
import acm.graphics.GImage;

import java.util.ArrayList;
import java.util.Random;

public class Dofi extends AnimalAcuatic{
    boolean Mascle;

    public Dofi(){
        Random random = new Random();

        this.llargada=85; this.altura=80;
        direccioRandom(random);
        this.Mascle= random.nextBoolean();
        imatgeAnimal(random); animal.setSize(this.llargada, this.altura);
    }

    @Override
    public void imatgeAnimal(Random random){
        int num = random.nextInt(4);
        String sexe;
        if (Mascle){
            sexe="m";
        }else { sexe="f"; }

        this.animal = new GImage("imatges\\Dofi\\Dofi_"+sexe+"_"+this.direccio+".png");
    }

    /*Direcció sempre en diagonal*/
    @Override
    public void direccioRandom(Random random){
        int num = random.nextInt(4);

        switch (num){
            case 0: this.direccio="dretaEsquerraSuperior";break;
            case 1: this.direccio="dretaEsquerraInferior";break;
            case 2: this.direccio="esquerraDretaInferior";break;
            case 3: this.direccio="esquerraDretaSuperior";break;
        }
    }

    @Override
    public void nadar(int getWidth, int getHeight) {
        final int avanca = 5;
        Random random = new Random();
        if(this.direccio.equals("dretaEsquerraSuperior")){
            for (int i = 0; i < avanca; i++) {
                animal.move(-1,-1);
                animal.pause(3);
            }
            if (animal.getX()<0 || animal.getY()<0){
                int num = random.nextInt(getWidth);
                animal.setLocation(getWidth-llargada, num);
            }

        }
        else if(this.direccio.equals("dretaEsquerraInferior")){
            for (int i = 0; i < avanca; i++) {
                animal.move(-1,1);
                animal.pause(3);
            }
            if ((animal.getX()+llargada)<0 || animal.getY()>getHeight){
                int num = random.nextInt(getWidth);
                animal.setLocation(num, 0);
            }
        }
        else if(this.direccio.equals("esquerraDretaInferior")){
            for (int i = 0; i < avanca; i++) {
                animal.move(1,1);
                animal.pause(3);
            }
            if (animal.getX()>getWidth || animal.getY()>getHeight){
                int num = random.nextInt(getWidth);
                animal.setLocation(num, 0);
            }
        }
        else{
            for (int i = 0; i < avanca; i++) {
                animal.move(+1,-1);
                animal.pause(3);
            }
            if (animal.getX()>getWidth || (animal.getY()+altura)<0){
                int num = random.nextInt(getWidth);
                animal.setLocation(num, getHeight);
            }
        }
    }
    @Override
    public ArrayList<AnimalAcuatic> reproduirse(ArrayList<AnimalAcuatic> animals) {
        animals.add(new Dofi());

        return animals;
    }
}
