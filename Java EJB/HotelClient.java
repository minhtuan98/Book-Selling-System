
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.*;

public class HotelClient extends HotelManagerImpl{
    public HotelClient(){}

    public static void main(String[] args) {
        try{
            if(args.length != 5){
                System.out.println("usage: java Client host port input");
                System.exit(1);
            }
            int index = 0;
            String host = args[index++];
            int port = Integer.parseInt(args[index++]);
            int  inputsp  = Integer.parseInt(args[index++]);
            int inputtype = Integer.parseInt(args[index++]);
            int inputprice = Integer.parseInt(args[index++]);
            Room x = new Room(inputsp,inputtype,inputprice);

            Registry registry = LocateRegistry.getRegistry(host,port);

            HotelManager stub = (HotelManager) registry.lookup("Hello");

            stub.listRoom(x);

            System.err.println("Remote method invoked");
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}