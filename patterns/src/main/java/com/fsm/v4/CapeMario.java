package com.fsm.v4;

public class CapeMario implements IMario {

    public static final CapeMario instance = new CapeMario();

    private CapeMario() {
    }

    public static CapeMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine marioStateMachine) {
        // 没有定义
    }

    @Override
    public void obtainCape(MarioStateMachine marioStateMachine) {
        // 没有定义
    }

    @Override
    public void obtainFireFlower(MarioStateMachine marioStateMachine) {
        // 没有定义
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 200);
    }
}
