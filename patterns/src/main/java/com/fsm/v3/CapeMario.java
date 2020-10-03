package com.fsm.v3;

public class CapeMario implements IMario{

    private MarioStateMachine stateMachine;

    public CapeMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom() {
        // 没有定义
    }

    @Override
    public void obtainCape() {
        // 没有定义
    }

    @Override
    public void obtainFireFlower() {
        // 没有定义
    }

    @Override
    public void meetMonster() {
        stateMachine.setCurrentState(new SmallMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() - 200);
    }
}
