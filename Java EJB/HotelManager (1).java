

import java.rmi.*;

public interface HotelManager extends Remote{
    public String listRoom(Room x) throws RemoteException;
}