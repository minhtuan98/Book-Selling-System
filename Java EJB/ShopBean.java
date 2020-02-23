/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.persistence;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vu
 */
@Stateful
public class ShopBean implements ShopBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "SampleEJB1PU")
    private EntityManager em;
    
    @Override
    public boolean checkLogin(String user,String pass){
        Taikhoan tk = em.find(Taikhoan.class,user);
        if(tk != null){
            if(tk.getPassword() == pass){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Taikhoan insertTK(Taikhoan tk){
        return null;
    }
    
    @Override
    public Taikhoan updateTK(Taikhoan tk){
        return null;
    }
    
    @Override
    public boolean deleteTK(String id){
        return false;
    }
    
    @Override
    public Nhanvien insertNV(Nhanvien nv){
        return null;
    }
    
    @Override
    public Nhanvien updateNV(Nhanvien nv){
        return null;
    }
    
    @Override
    public boolean deleteNV(String id){
        return false;
    }
    
    @Override
    public Sanpham insertSP(Sanpham sp){
        return null;
    }
    
    @Override
    public Sanpham updateSP(Sanpham sp){
        return null;
    }
    
    @Override
    public boolean deleteSP(String idsp){
        return false;
    }
    
    @Override
    public Hoadon insertHD(Hoadon hd){
        return null;
    }
    
    @Override
    public Hoadon updateHD(Hoadon hd){
        return null;
    }
    
    @Override
    public boolean deleteHD(String idhd){
        return false;
    }
}
