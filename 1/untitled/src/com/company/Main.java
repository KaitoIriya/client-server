package com.company;

class Main {
    public static void main(String[] args) {

        Game clean = new Game();
        new PingPong("Ping", clean);
        new PingPong("Pong", clean);
    }
}

class Game {
    String currentState = "";

    synchronized void Lather() {
        currentState = "Ping";
        System.out.println(currentState);
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized void Rinse(){
        currentState = "Pong";
        System.out.println(currentState);
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class PingPong extends Thread {
    String name;
    Game cleanRef;

    PingPong(String name, Game cleanRef){
        this.name = name;
        this.cleanRef = cleanRef;
        setName(name);
        start();
    }
    @Override
    public void run(){
        if (name.equals("Ping")){
            for(int i = 0; i<10; i++) {cleanRef.Lather();}
        }
        if (name.equals("Pong")) {
            for(int i = 0; i<10; i++)  {cleanRef.Rinse();}
        }
    }

}