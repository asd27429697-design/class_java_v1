package com.oop20;

// implements - 구현 한다.
public class TV implements RemoteControl{

    private int volume;

    @Override
    public void turnOn() {
        System.out.println("TV 전원을 켭니다");
    }

    @Override
    public void turnOff() {
        System.out.println("TV 전원을 끕니다");
    }

    @Override
    public void setMaxVolume(int volume) {
        if (volume > MAX_VOLUME) {
            this.volume = MAX_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("TV 볼륨을 " + this.volume + " 으로 설정합니다");
    }
}
