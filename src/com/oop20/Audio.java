package com.oop20;

public class Audio implements RemoteControl{

    private int volume;

    @Override
    public void turnOn() {
        System.out.println("오디오 전원을 켭니다");
    }

    @Override
    public void turnOff() {
        System.out.println("오디오 전원을 끕니다");
    }

    @Override
    public void setMaxVolume(int volume) {
        this.volume = volume;
        System.out.println("오디오 볼륨을 " + this.volume + "으로 설정합니다");
    }
}
