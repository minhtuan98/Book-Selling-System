

import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
import java.rmi.server.*;

public class HotelServer extends HotelManagerImpl{
    public HotelServer(){

    }

    public static void main(String[] args){
        try{
            int index = 0;
            int port = Integer.parseInt(args[index++]);

            HotelManagerImpl obj = new HotelManagerImpl();

            HotelManager skeleton = (HotelManager) UnicastRemoteObject.exportObject(obj,0);

            Registry registry = LocateRegistry.getRegistry(port);
            registry.rebind("Hello",skeleton);

            System.err.println("Server ready");
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }
}