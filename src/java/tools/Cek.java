/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import dao.AngsuranDAO;
import dao.BarangDAO;
import dao.CustomerDAO;
import dao.Detail_GadaiDAO;
import dao.GadaiDAO;
import dao.Jenis_BarangDAO;
import dao.UserManagementDAO;
import entities.Gadai;
import entities.Usermanagement;
import java.util.List;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class Cek {

    public static void main(String[] args) {
//        List<Object> datas = new CustomerDAO().getAll();
//        System.out.println(datas.size());

        //  System.out.println(new Detail_GadaiDAO().getAutoID());
//        AngsuranDAO aDAO = new AngsuranDAO();
//        System.out.println(aDAO.getAutoID());
        //Gadai gadd = (Gadai) fdao.getById(id_gadai);
        String ID = "1411521017";
        String password = "fitriany";
        String er;
        UserManagementDAO udao = new UserManagementDAO();

        Usermanagement u = (Usermanagement) new UserManagementDAO().getById(ID);
        if (udao.login(ID, password)) {
            if (u.getAkses().equals("manajer")) {
                System.out.println("index2");;
            } else {
                System.out.println("index");;
            }
        }
    }
}
