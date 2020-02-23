/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.persistence;

import javax.ejb.Remote;

/**
 *
 * @author vu
 */
@Remote
public interface ShopBeanRemote {
    boolean checkLogin(String user,String pass);
    Taikhoan insertTK(Taikhoan tk);
    Taikhoan updateTK(Taikhoan tk);
    boolean deleteTK(String id);
    Nhanvien insertNV(Nhanvien nv);
    Nhanvien updateNV(Nhanvien nv);
    boolean deleteNV(String id);
    Sanpham insertSP(Sanpham sp);
    Sanpham updateSP(Sanpham sp);
    boolean deleteSP(String idsp);
    Hoadon insertHD(Hoadon hd);
    Hoadon updateHD(Hoadon hd);
    boolean deleteHD(String idhd);
}
