package com.mycompany.openskyrestapi;

public class ActualTime {

    private int tempo;
    private Object [][] states;

    @Override
    public String toString() {
        return "ActualTime{" + "tempo=" + tempo + ", states=" + states + '}';
    }
    
    public ActualTime() {
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
}
