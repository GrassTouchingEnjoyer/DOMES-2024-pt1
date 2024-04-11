package org.tuc;

//We assume SimpleElement is a basic implementation of the Element interface
class SimpleElement implements Element{
    private int key;

    public SimpleElement(int key){
        this.key = key;
    }

    @Override
    public int getKey(){
        return this.key;
    }

    @Override
    public String toString(){ return "" + key;}
}