package edu.tdt.test;
import edu.tdt.persistence.Nhanvien;
import edu.tdt.persistence.Sanpham;
import edu.tdt.persistence.Hoadon;
import edu.tdt.persistence.Taikhoan;
import edu.tdt.persistence.CThoadon;
import edu.tdt.persistence.ShopBean;
import edu.tdt.persistence.ShopBeanRemote;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class EJBTester {
private Properties props;
private InitialContext ctx;
    
    public EJBTester()
    {
    readJNDI();
    }
/**
* Read the JNDI properties file
*/
    private void readJNDI()
    {
    props = new Properties();
        try
        {
            props.load(new FileInputStream("jndi.properties"));
        } catch(IOException e)
        {
            System.err.println(e.toString());
        }
            try
        {
            ctx = new InitialContext(props);
            //ctx.close();
        } catch (NamingException ex)
        {
            ex.getMessage();
        }
    }
/**
* Construct and return the JNDI address of called class
* @return String
*/
    private String getJNDI()
    {
    String appName = "";
    String moduleName = "SampleEJB1";
    String distinctName = "";
    String sessionBeanName = ShopBean.class.getSimpleName();
    String viewClassName = ShopBeanRemote.class.getName()+ "?stateful";
    return "ejb:"+appName+"/"+moduleName+"/"+distinctName+"/"+sessionBeanName+"!"+viewClassName;
    }
/**
* Show the GUI in console window
*/
    private void showGUI()
    {
        System.out.println("\n=========================");
        System.out.println("Welcome to TDTU Shop");
        System.out.println("=========================");
        System.out.print("Options: \n1. Lien quan ve tai khoan \n2. Lien quan ve san pham \n3. Lien quan ve nhan vien \n4.Lien quan ve hoa don \n5.Lien quan ve chi tiet hoa don \n6.Thoat ");
    }
    private void showGUI1()
    {
        System.out.println("\n=========================");
        System.out.println("Welcome to TDTU Choice");
        System.out.println("=========================");
        System.out.print("Options: \n1. Them tai khoan \n2. Xoa tai khoan \n3. Sua tai khoan \n4.Danh sach tai khoan \n5.Exit");
    }
    private void showGUI2()
    {
        System.out.println("\n=========================");
        System.out.println("Welcome to TDTU Choice");
        System.out.println("=========================");
        System.out.print("Options: \n1. Them san pham \n2. Xoa san pham \n3. Sua san pham \n4.Danh sach san pham \n5.Exit");
    }
    private void showGUI3()
    {
        System.out.println("\n=========================");
        System.out.println("Welcome to TDTU Choice");
        System.out.println("=========================");
        System.out.print("Options: \n1. Them nhan vien \n2. Xoa nhan vien \n3. Sua nhan vien \n4.Danh sach nhan vien \n5.Exit");
    }
    private void showGUI4()
    {
        System.out.println("\n=========================");
        System.out.println("Welcome to TDTU Choice");
        System.out.println("=========================");
        System.out.print("Options: \n1. Them hoa don \n2. Xoa hoa don \n3. Sua hoa don \n4.Danh sach hoa don \n5.Exit");
    }private void showGUI5()
    {
        System.out.println("\n=========================");
        System.out.println("Welcome to TDTU Choice");
        System.out.println("=========================");
        System.out.print("Options: \n1. Them chi tiet hoa don \n2. Xoa chi tiet hoa don \n3. Sua chi tiet hoa don \n4.Danh sach chi tiet hoa don \n5.Exit");
    }

//Show thong tin
    private void ShowNhanvien()
        {
        try
        {
            // We can define another bean to access the LibrarySessionBeanRemote
            ShopBeanRemote libBean2 = (ShopBeanRemote) ctx.lookup(getJNDI());
            List<Nhanvien> nhanvien = libBean2.GetNhanvien();

            // Print all books
        if(nhanvien.isEmpty())
        {
            System.out.println("Khong ton tai nhan vien!\n");
            return;
        }

            System.out.println("\n=========================");
            System.out.println("Danh sach nhan vien");
            System.out.println("=========================");
        for (int i = 0; i < nhanvien.size(); i++)
        {
            System.out.println((i+1) + "\t" + nhanvien.get(i));
        }
            System.out.println();

        } 
        catch (NamingException ex)
        {
            ex.getMessage();
        }
    }
    private void ShowSanpham()
        {
        try
        {
            // We can define another bean to access the LibrarySessionBeanRemote
            ShopBeanRemote libBean2 = (ShopBeanRemote) ctx.lookup(getJNDI());
            List<Sanpham> sanpham = libBean2.GetSanpham();

            // Print all books
        if(sanpham.isEmpty())
        {
            System.out.println("Khong ton tai san pham!\n");
            return;
        }

            System.out.println("\n=========================");
            System.out.println("Danh sach san pham");
            System.out.println("=========================");
        for (int i = 0; i < sanpham.size(); i++)
        {
            System.out.println((i+1) + "\t" + sanpham.get(i));
        }
            System.out.println();

        } 
        catch (NamingException ex)
        {
            ex.getMessage();
        }
    }
    
     private void ShowHoadon()
        {
        try
        {
            // We can define another bean to access the LibrarySessionBeanRemote
            ShopBeanRemote libBean2 = (ShopBeanRemote) ctx.lookup(getJNDI());
            List<Hoadon> hoadon = libBean2.GetHoadon();

            // Print all books
        if(hoadon.isEmpty())
        {
            System.out.println("Khong ton tai hoa don!\n");
            return;
        }

            System.out.println("\n=========================");
            System.out.println("Danh sach hoa don");
            System.out.println("=========================");
        for (int i = 0; i < hoadon.size(); i++)
        {
            System.out.println((i+1) + "\t" + hoadon.get(i));
        }
            System.out.println();

        } 
        catch (NamingException ex)
        {
            ex.getMessage();
        }
    }
     private void ShowCTHoadon()
        {
        try
        {
            // We can define another bean to access the LibrarySessionBeanRemote
            ShopBeanRemote libBean2 = (ShopBeanRemote) ctx.lookup(getJNDI());
            List<CThoadon> cthd = libBean2.GetCThoadon();

            // Print all books
        if(cthd.isEmpty())
        {
            System.out.println("Khong ton tai chi tiet hoa don!\n");
            return;
        }

            System.out.println("\n=========================");
            System.out.println("Danh sach chi tiet hoa don");
            System.out.println("=========================");
        for (int i = 0; i < cthd.size(); i++)
        {
            System.out.println((i+1) + "\t" + cthd.get(i));
        }
            System.out.println();

        } 
        catch (NamingException ex)
        {
            ex.getMessage();
        }
    }
     private void ShowTaikhoan()
        {
        try
        {
            // We can define another bean to access the LibrarySessionBeanRemote
            ShopBeanRemote libBean2 = (ShopBeanRemote) ctx.lookup(getJNDI());
            List<Taikhoan> taikhoan = libBean2.GetTaikhoan();

            // Print all books
        if(taikhoan.isEmpty())
        {
            System.out.println("Khong ton tai tai khoan!\n");
            return;
        }

            System.out.println("\n=========================");
            System.out.println("Danh sach tai khoan");
            System.out.println("=========================");
        for (int i = 0; i < taikhoan.size(); i++)
        {
            System.out.println((i+1) + "\t" + taikhoan.get(i));
        }
            System.out.println();

        } 
        catch (NamingException ex)
        {
            ex.getMessage();
        }
    }
//

     //Insert Book
     
    
    public void testEntityEJB()
       {
       try
       {
        
         // Scanner definition
         Scanner sc = new Scanner(System.in);

         // Lookup the LibrarySessionBeanRemote
         ShopBeanRemote libBean = (ShopBeanRemote) ctx.lookup(getJNDI());
         System.out.println("Moi nhap tai khoan");
         String _user = sc.nextLine();
         System.out.println("Password: ");
         String _pass = sc.nextLine();
         
         if(libBean.checkLogin(_user) == _pass.hashCode()){
         int choice = 0;
         while(choice != 4)
         {
         this.showGUI();

         // Use this approach to avoid the error cause by nextInt() follows by nextLine()
        choice = Integer.parseInt(sc.nextLine());

        if(choice == 1)
             // Ve Tai khoan
        {
            System.out.print("Moi ban chon chuc nang: ");
            int choice1 = 0;
        while(choice1 !=4)
        {
            this.showGUI1();
            choice1 = Integer.parseInt(sc.nextLine());
            if(choice1 ==1)
            {
                //Them tai khoan
                System.out.println("Moi ban dien ten dang nhap: ");
                String username = sc.nextLine();
                System.out.println("Moi ban dien mat khau: ");
                String password = sc.nextLine();
                Taikhoan tk = new Taikhoan();
                tk.setUsername(username);
                tk.setPassword(password);
                libBean.insertTK(tk);
            }
            else if(choice1 ==2)
            {
                //Xoa tai khoan
                System.out.print("Moi ban chon tai khoan muon xoa: ");
                ShowTaikhoan();
                String user = sc.nextLine();
                libBean.deleteTK(user);
                //XoaTaiKhoan(id);
            }
            else if(choice1 == 3)
            {
                //Update tai khoan
                ShowTaikhoan();
                System.out.print("Moi ban chon tai khoan muon cap nhat: ");
                String userud = sc.nextLine();
                System.out.print("Nhap Password cap nhat: ");
                String passud = sc.nextLine();
                Taikhoan udtk = new Taikhoan(userud,passud);
                libBean.updateTK(udtk);
                ShowTaikhoan();
                //SuaTaiKhoan(id);
            }
            else if(choice1 == 4)
            {
               System.out.println("Danh sach tai khoan");
               ShowTaikhoan();
            }
            else
            {break;}
        }
      
    }
         
        else if(choice == 2)
        {
            //Ve san pham
            System.out.print("Moi ban chon chuc nang: ");
            int choice1 = 0;
            while(choice1 !=4)
            {
                this.showGUI2();
                choice1 = Integer.parseInt(sc.nextLine());
            if(choice1 ==1)
            {
                //Them san pham
                System.out.println("Chuc nang them san phan");
                System.out.print("ID san pham: ");
                String idsp = sc.nextLine();
                System.out.print("Ten san pham: ");
                String tensp = sc.nextLine();
                System.out.print("Loai san pham: ");
                String loaisp = sc.nextLine();
                System.out.print("Gia san pham: ");
                Integer giasp = Integer.parseInt(sc.nextLine());
                Sanpham sp = new Sanpham(idsp, tensp, loaisp, giasp);
                sp.setIdsp(idsp);
                sp.setTensp(tensp);
                sp.setLoaisp(loaisp);
                sp.setGiasp(giasp);
                libBean.insertSP(sp);
                //ShowSanpham();
            }
            else if(choice1 ==2)
            {
                //Xoa san pham
                System.out.print("Moi ban chon san pham muon xoa: ");
                ShowSanpham();
                String spxoa = sc.nextLine();
                libBean.deleteSP(spxoa);
                //XoaSanpham(id);
            }
            else if(choice1 == 3)
            {
                //Update san pham
                ShowSanpham();
                System.out.print("Moi ban chon san pham muon cap nhat: ");
                String _idsp = sc.nextLine();
                System.out.print("Moi ban nhap ten san pham: ");
                String _tensp = sc.nextLine();
                System.out.print("Moi ban nhap loai san pham: ");
                String _loaisp = sc.nextLine();
                System.out.print("Moi ban nhap gia san pham : ");
                Integer _giasp = Integer.parseInt(sc.nextLine());
                Sanpham spmoi = new Sanpham(_idsp, _tensp, _loaisp, _giasp);
                libBean.updateSP(spmoi);
                ShowSanpham();
                //Suasanpham(id);
            }
            else if(choice1 == 4)
            {
                System.out.print("Danh sach san pham");
                ShowSanpham();
            }
            else
            {
                break;
            }
            }
        }
        else if(choice == 3)
        {
            //Ve nhan vien
            System.out.print("Moi ban chon chuc nang: ");
            int choice1 = 0;
            while(choice1 !=4)
            {
                this.showGUI3();
                choice1 = Integer.parseInt(sc.nextLine());
             if(choice1 ==1)
            {
                //Them nhan vien
                System.out.println("Chuc nang them nhan vien");
                System.out.print("ID nhan vien: ");
                String idnv = sc.nextLine();
                System.out.print("Ten nhan vien: ");
                String tennv = sc.nextLine();
                System.out.print("Chuc vu: ");
                String chucvu = sc.nextLine();
                Nhanvien nv = new Nhanvien(idnv, tennv, chucvu);
                nv.setIdnv(idnv);
                nv.setTennv(tennv);
                nv.setChucvu(chucvu);
                libBean.insertNV(nv);
            }
             else if(choice1 ==2)
            {
                //Xoa nhan vien
                System.out.print("Moi ban chon nhan vien muon xoa: ");
                ShowNhanvien();
                String nvxoa = sc.nextLine();
                libBean.deleteNV(nvxoa);
                //XoaNhanvien(id);
            }
             else if(choice1 == 3)
            {
                //Update nhan vien
                ShowNhanvien();
                System.out.print("Moi ban chon nhan vien muon cap nhat: ");
                String _idnv = sc.nextLine();
                System.out.print("Moi ban nhap ten nhan vien: ");
                String _tennv = sc.nextLine();
                System.out.print("Moi ban nhap chuc vu nhan vien: ");
                String _loainv = sc.nextLine();
                Nhanvien nvmoi = new Nhanvien(_idnv, _tennv, _loainv);
                libBean.updateNV(nvmoi);
                ShowNhanvien();
                
            }
            else if(choice1 ==4)
            {
                System.out.println("Danh sach nhan vien");
                ShowNhanvien();
            }
            else
            {
                break;
            }
        }
        }
        else if(choice == 4)
        {
            //Ve hoa don
            System.out.print("Moi ban chon chuc nang: ");
            int choice1 = 0;
            while(choice1 !=4)
            {
                this.showGUI4();
                choice1 = Integer.parseInt(sc.nextLine());
            if(choice1 ==1)
            {
                //Them hoa don
                System.out.println("Chuc nang them hoa don");
                System.out.print("ID hoa don:");
                String idhd = sc.nextLine();
                System.out.print("ID nhan vien:");
                String idnv = sc.nextLine();
                System.out.print("Tong tien: ");
                int tongtien = sc.nextInt();
                Hoadon hd = new Hoadon(idhd, idnv, tongtien);
                hd.setIdhd(idhd);
                hd.setIdnv(idnv);
                hd.setTotal(tongtien);
                libBean.insertHD(hd);
            }
            else if(choice1 ==2)
            {
                //Xoa hoa don
                System.out.print("Moi ban chon hoa don muon xoa: ");
                ShowHoadon();
                String hd = sc.nextLine();
                libBean.deleteHD(hd);
            }
            else if(choice1 == 3)
            {
                //Update hoa don
                ShowHoadon();
                System.out.print("Moi ban chon hoa don muon cap nhat: ");
                String _idhd = sc.nextLine();
                System.out.print("Moi ban nhap ID nhan vien: ");
                String _idnv = sc.nextLine();
                System.out.print("Moi ban nhap tong tien: ");
                int _total = Integer.parseInt(sc.nextLine());
                Hoadon hdmoi = new Hoadon(_idhd, _idnv, _total);
                libBean.updateHD(hdmoi);
                ShowHoadon();
            }
            else if(choice1 ==4)
            {
                System.out.println("Danh sách hóa đơn");
                ShowHoadon();
            }
            else
            {
                break;
            }
            }
        }
        else if(choice == 5)
        {
            //Ve chi tiet hoa don
            System.out.print("Moi ban chon chuc nang: ");
            int choice1 = 0;
            while(choice1 !=4)
            {
                this.showGUI5();
                choice1 = Integer.parseInt(sc.nextLine());
            if(choice1 ==1)
            {
                //Them chi tiet hoa don
                System.out.println("Chuc nang them hoa don");
                System.out.print("ID hoa don:");
                String idhd = sc.nextLine();
                System.out.print("ID san pham:");
                String idsp = sc.nextLine();
                System.out.print("so luong: ");
                int soluong = sc.nextInt();
                CThoadon cthd = new CThoadon(idhd, idsp, soluong);
                cthd.setIdhd(idhd);
                cthd.setIdsp(idsp);
                cthd.setSoluong(soluong);
                libBean.insertCTHD(cthd);
            }
            else if(choice1 ==2)
            {
                //Xoa chi tiet hoa don
                System.out.print("Moi ban chon chi tiet hoa don muon xoa: ");
                ShowCTHoadon();
                String cthd = sc.nextLine();
                libBean.deleteCTHD(cthd);
                
            }
            else if(choice1 == 3)
            {
                //Update chi tiet hoa don
                ShowCTHoadon();
                System.out.print("Moi ban chon chi tiet hoa don muon cap nhat: ");
                String _idhd = sc.nextLine();
                System.out.print("Moi ban nhap ID san pham: ");
                String _idsp = sc.nextLine();
                System.out.print("Moi ban nhap so luong: ");
                int _soluong = Integer.parseInt(sc.nextLine());
                CThoadon cthdmoi = new CThoadon(_idhd, _idsp, _soluong);
                libBean.updateCTHD(cthdmoi);
                ShowCTHoadon();
            }
            else if(choice1 ==4)
            {
                ShowCTHoadon();
            }
            else{break;}
        }
        }
        else
        {
            //Exit
            break;
        }
    }
         }else{
             System.out.println("Fail");
         }
         sc.close();
    
    }
        catch (NamingException ex)
        {
            ex.getMessage();
        }
    }

    }
