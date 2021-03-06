package org.academiadecodigo.bootcamp8.duckhunt.gameobjects;

import org.academiadecodigo.bootcamp8.duckhunt.simplegfx.SpecialRepresentation;
import org.academiadecodigo.bootcamp8.duckhunt.sound.Sound;

/**
 * Created by prashanta on 27-05-2017.
 */
public class Special {
    private SpecialsType type;
    private MovableRepresentable specRep;
    private int x;
    private int y;
    private Sound sound;


    public Special(SpecialsType type) {
        this.type = type;
        this.x = type.getxStart();
        this.y = type.getyStart();
        this.specRep = new SpecialRepresentation(type);
        sound = new Sound(type.getSound());
    }

    public void move(){
        sound.play(false);
        specRep.move(getXSpeed(), getYSpeed());
        x += getXSpeed();
        y += getYSpeed();
    }

    public void remove() {
        sound.stop();
        specRep.delete();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXOffSet() {
        return x + specRep.getOffsetX();
    }

    public int getYOffSet() {
        return y + specRep.getOffsetY();
    }

    public int getXSpeed() {
        return type.getxSpeed();
    }

    public int getYSpeed() {
        return type.getySpeed();
    }

}
