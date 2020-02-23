

public class Room{
    private int sophong,type,price;

    
    public Room(){

    }

    public Room(int sophong, int type, int price){
        this.sophong = sophong;
        this.type = type;
        this.price = price;
    }

    public String toString(){
        return "We have" + sophong + " type " + type + " price "+price+" in one night";
    }
}