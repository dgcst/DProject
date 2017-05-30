package org.academiadecodigo.bootcamp8.duckhunt;

// Created by dgcst on 25/05/17

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Gun {

    private int bullets;
    private GunController gunController;
    private int x;
    private int y;

    public Gun() {
        gunController = new GunController();
        bullets = 100;
    }



    public int getX() {
        return x;
    }

    public void resetX(){ x = -1;}

    public int getY() {
        return y;
    }

    public void resetY(){ y = -1;}


    public void shoot() {
        bullets--;
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
            shoot();
            x = (int) e.getX();
            y = (int) e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

}
