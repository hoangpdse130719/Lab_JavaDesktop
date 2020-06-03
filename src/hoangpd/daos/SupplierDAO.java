/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangpd.daos;

import hoangpd.dtos.SupplierDTO;
import hoangpd.utils.MyConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author phamduchoang
 */
public class SupplierDAO implements Serializable {

    Connection cnn;
    PreparedStatement preSta;
    ResultSet rs;

    public void closeConnection() throws Exception {
        if (rs != null) {
            cnn.close();
        }
        if (preSta != null) {
            cnn.close();
        }
        if (cnn != null) {
            cnn.close();
        }
    }

    public ArrayList<SupplierDTO> getAllSupplier() throws Exception {
        ArrayList<SupplierDTO> supplierList = new ArrayList<>();
        String sql = "  Select SupCode,SupName,Address,colloborating \n"
                + "  from Suppliers";
        cnn = MyConnection.getConnect();
        preSta = cnn.prepareStatement(sql);

        rs = preSta.executeQuery();
        while (rs.next()) {
            String supCode = rs.getString("SupCode");
            String supName = rs.getString("SupName");
            String address = rs.getString("Address");
            boolean colloborating = rs.getBoolean("colloborating");
            SupplierDTO newSupplier = new SupplierDTO(supCode, supName, address, colloborating);
            supplierList.add(newSupplier);
        }

        closeConnection();

        return supplierList;
    }

    public boolean addNewSupplier(SupplierDTO newSup) throws Exception {

        boolean result;
        cnn = MyConnection.getConnect();
        String sql = "Insert into Suppliers values(?,?,?,?)";

        preSta = cnn.prepareStatement(sql);

        preSta.setString(1, newSup.getSupCode());
        preSta.setString(2, newSup.getSupName());
        preSta.setString(3, newSup.getAddress());
        preSta.setBoolean(4, newSup.isColloborating());
        result = (preSta.executeUpdate() > 0);

        closeConnection();

        return result;
    }

    public boolean validDeleteSup(String supCode) throws Exception {

        boolean result = true;
        cnn = MyConnection.getConnect();
        String sql = "SELECT itemCode FROM Items WHERE supCode = ?";

        preSta = cnn.prepareStatement(sql);
        preSta.setString(1, supCode);
        rs = preSta.executeQuery();
        while (rs.next()) {
            result = false;
        }

        closeConnection();

        return result;
    }

    public boolean deleteSup(String supCode) throws Exception {

        boolean result = false;
        cnn = MyConnection.getConnect();
        String sql = "DELETE FROM Suppliers \n"
                + "WHERE supCode = ?";

        preSta = cnn.prepareStatement(sql);
        preSta.setString(1, supCode);
        result = (preSta.executeUpdate() > 0);
        closeConnection();

        return result;
    }

    public boolean supCodeIsExist(String supCode) throws Exception {

        boolean result = true;
        cnn = MyConnection.getConnect();
        String sql = "SELECT Supname FROM Suppliers WHERE SupCode = ?";

        preSta = cnn.prepareStatement(sql);
        preSta.setString(1, supCode);
        rs = preSta.executeQuery();
        while (rs.next()) {
            result = false;
        }

        closeConnection();

        return result; //true = ko tồn tại; false = có tồn lại
    }

    public boolean updateSupplier(SupplierDTO supplier) throws Exception {

        boolean result;
        cnn = MyConnection.getConnect();
        String sql = "UPDATE Suppliers set SupName = ?, Address = ? WHERE SupCode =?";

        preSta = cnn.prepareStatement(sql);
        preSta.setString(1, supplier.getSupName());
        preSta.setString(2, supplier.getAddress());
        preSta.setString(3, supplier.getSupCode());
        result = (preSta.executeUpdate() > 0);
        closeConnection();

        return result;
    }
}
