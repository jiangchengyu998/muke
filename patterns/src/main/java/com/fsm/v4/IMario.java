package com.fsm.v4;


public interface IMario { //所有状态类的接口
    State getName();
    //以下是定义的事件
    void obtainMushRoom(MarioStateMachine marioStateMachine);
    void obtainCape(MarioStateMachine marioStateMachine);
    void obtainFireFlower(MarioStateMachine marioStateMachine);
    void meetMonster(MarioStateMachine marioStateMachine);
}

// 省略CapeMario、FireMario类...
