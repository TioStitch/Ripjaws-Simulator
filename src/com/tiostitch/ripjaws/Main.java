package com.tiostitch.ripjaws;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main extends JFrame {

    //Movimentação
    ImageIcon movendo_direita = new ImageIcon(getClass().getResource("animations/Aquatico_Direita.gif"));
    ImageIcon movendo_esquerda = new ImageIcon(getClass().getResource("animations/Aquatico_Esquerda.gif"));
    ImageIcon movendo_subida = new ImageIcon(getClass().getResource("animations/Aquatico_Subindo.gif"));
    ImageIcon movendo_descendo = new ImageIcon(getClass().getResource("animations/Aquatico_Descendo.gif"));

    ImageIcon parado = new ImageIcon(getClass().getResource("animations/Aquatico_Parado.gif"));
    ImageIcon oceano_fundo = new ImageIcon(getClass().getResource("background/Background.png"));
    ImageIcon dna_alien = new ImageIcon(getClass().getResource("animations/Aquatico_Parado.gif"));

    JLabel iParede = new JLabel(oceano_fundo);
    JLabel iPersonagem = new JLabel(parado);
    JLabel iDNAlien = new JLabel(dna_alien);
    int posXAquatico = 300, posYAquatico = 300;
    int posXAlienDNA = 0, posYAlienDNA = 0;

    public Main() {
        editarJanela();
        editarComponents();
        addMovimento();
    }

    public void editarComponents() {
        iParede.setBounds(0, 0, 800, 700);
        iPersonagem.setBounds(posXAquatico, posYAquatico, 100, 100);
    }

    public void editarJanela() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        add(iPersonagem);
        add(iParede);
    }

    public void addMovimento() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 38:
                        if (posYAquatico == 0) {
                            return;
                        }
                        iPersonagem.setIcon(movendo_subida);
                        posYAquatico -= 10;
                        break;
                    case 40:
                        if (posYAquatico >= 570) {
                            return;
                        }
                        iPersonagem.setIcon(movendo_descendo);
                        posYAquatico += 10;
                        break;
                    case 37:
                        if (posXAquatico == -20) {
                            return;
                        }
                        iPersonagem.setIcon(movendo_esquerda);
                        posXAquatico -= 10;
                        break;
                    case 39:
                        if (posXAquatico >= 700) {
                            return;
                        }

                        iPersonagem.setIcon(movendo_direita);
                        posXAquatico += 10;
                        break;
                }
                iPersonagem.setBounds(posXAquatico, posYAquatico, 100, 100);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                iPersonagem.setIcon(parado);
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
