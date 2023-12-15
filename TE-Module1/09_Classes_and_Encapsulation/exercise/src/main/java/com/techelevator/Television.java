package com.techelevator;

public class Television {
    private boolean isOn = false;
private int currentChannel = 3;

private int currentVolume = 2;


  public boolean isOn() {
    if (isOn == true) {
            return true;
       }
       return false;
   }


    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void turnOff(){
        this.isOn = false;

    }
    public void turnOn(){
        this.isOn = true;
        this.currentChannel = 3;
        this.currentVolume = 2;
    }
    public void changeChannel(int newChannel) {
        if (isOn == true) {
            if (newChannel > 3 && newChannel < 18) {
                this.currentChannel = newChannel;
            }
        }
    }
    public void channelUp(){
        if (isOn == true) {
            currentChannel = currentChannel + 1;
            if (currentChannel > 18){
                currentChannel = 3;
            }
        }
    }


    public void channelDown(){
        if (isOn == true) {
            this.currentChannel = currentChannel - 1;
            if (currentChannel < 3){
                currentChannel = 18;
            }
        }
    }
 public void raiseVolume(){
        if (isOn == true){
            currentVolume = currentVolume + 1;
            if (currentVolume > 10){
                currentVolume = 10;
            }
        }
 }
    public void lowerVolume() {
        if (isOn == true) {
            currentVolume = currentVolume - 1;
            if (currentVolume < 0) {
                currentVolume = 0;
            }
        }
    }
}


