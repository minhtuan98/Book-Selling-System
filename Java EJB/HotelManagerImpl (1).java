

import java.rmi.RemoteException;

public class HotelManagerImpl implements HotelManager{
    @Override
    public String listRoom(Room x) throws RemoteException{
        return x.toString();
    }
}