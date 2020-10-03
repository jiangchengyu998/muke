package com.fsm.v4;


public class ApplicationDemo {
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        mario.obtainFireFlower();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score: " + score + "; state: " + state);

        mario.meetMonster();

        System.out.println("mario score: " + mario.getScore() + "; state: " + mario.getCurrentState());

    }
}

