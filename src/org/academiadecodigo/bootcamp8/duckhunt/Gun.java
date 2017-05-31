package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.bootcamp8.duckhunt.SimpleGFX.BulletsRepresentation;
import org.academiadecodigo.bootcamp8.duckhunt.Sound.Sound;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Gun {

    private GunController gunController;
    private BulletsRepresentation bulletPic;
    private static final int maxBullets = 12;
    private int currBullets;
    private boolean loaded;
    private int x;
    private int y;
    private Sound sound;
    private Sound reload;

    public Gun() {
        gunController = new GunController();
        bulletPic = new BulletsRepresentation(maxBullets);
        currBullets = maxBullets;
        loaded = true;
        sound = new Sound ("/resources/sounds/gun3.wav");
        reload = new Sound ("/resources/sounds/reload.wav");

    }

    public void shoot() {
        if (currBullets == 0){
            loaded = false;
        }
        if ((x >= bulletPic.getXReload() && x <= bulletPic.getXOffSetReload()
                && y >= bulletPic.getYReload() && y <= bulletPic.getYOffSetReload()
                && currBullets != maxBullets)) {
            reload.play(true);
            bulletPic.drawBullets();
            currBullets = maxBullets;
            loaded = true;
            return;
        }
        if(currBullets > 0){
            bulletPic.shoot();
            sound.play(true);
            currBullets--;
        }

    }

    public int getX() {
        return x;
    }

    public void resetX(){ x = -1;}

    public int getY() {
        return y;
    }

    public void resetY(){ y = -1;}

    public boolean isLoaded() {
        return loaded;
    }

    
    private class GunController implements MouseHandler {
        private Mouse mouse;

        public GunController() {
            this.mouse = new Mouse(this);
            addEventListener();
        }

        public void addEventListener() {
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            x = (int) e.getX();
            y = (int) e.getY();
            shoot();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

}
