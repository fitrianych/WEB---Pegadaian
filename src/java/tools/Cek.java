/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import dao.CustomerDAO;
import java.util.List;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class Cek {
    public static void main(String[] args) {
        List<Object> datas = new CustomerDAO().getAll();
        System.out.println(datas.size());
    }
}
