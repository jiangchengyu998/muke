package com.fsm.v4;

public class SmallMario implements IMario {

    private static final SmallMario instance = new SmallMario();

    private SmallMario() {}

    public static SmallMario getInstance() {
        return instance;
    }
    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(SuperMario.getInstance());
        marioStateMachine.setScore(marioStateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(CapeMario.getInstance());
        marioStateMachine.setScore(marioStateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine marioStateMachine) {
        marioStateMachine.setCurrentState(FireMario.getInstance());
        marioStateMachine.setScore(marioStateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine marioStateMachine) {
        // do nothing...
    }
}

