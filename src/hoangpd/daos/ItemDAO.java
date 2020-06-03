/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangpd.daos;

import hoangpd.dtos.ItemDTO;
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
public class ItemDAO implements Serializable {

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

    public ArrayList<ItemDTO> getAllItem() throws Exception {
        ArrayList<ItemDTO> itemList = new ArrayList<>();

        cnn = MyConnection.getConnect();
        String sql = "Select itemCode, itemName, supCode, unit, price, supplying\n"
                + "from Items";
        preSta = cnn.prepareStatement(sql);
        rs = preSta.executeQuery();
        while (rs.next()) {
            String itemCode = rs.getString("itemCode");
            String itemName = rs.getString("itemName");
            String supCode = rs.getString("supCode");
            String unit = rs.getString("unit");
            String price = rs.getString("price");
            boolean supplying = rs.getBoolean("supplying");

            ItemDTO newItem = new ItemDTO(itemCode, itemName, supCode, unit, price, supplying);
            itemList.add(newItem);

        }

        closeConnection();

        return itemList;
    }

    public String getSupName(String supCode) throws Exception {
        String supName = null;
        cnn = MyConnection.getConnect();
        String sql = "Select supName\n"
                + "from  Suppliers\n"
                + "WHERE Suppliers.SupCode = ?";
        preSta = cnn.prepareStatement(sql);
        preSta.setString(1, supCode);

        ResultSet rs = preSta.executeQuery();
        if (rs.next()) {
            supName = rs.getString("supName");
        }

        closeConnection();

        return supName;
    }

    public boolean itemCodeIsExist(String itemCode) throws Exception {

        boolean result = true;
        cnn = MyConnection.getConnect();
        String sql = "SELECT itemName FROM Items WHERE itemCode = ?";

        preSta = cnn.prepareStatement(sql);
        preSta.setString(1, itemCode);
        rs = preSta.executeQuery();
        while (rs.next()) {
            result = false;
        }

        closeConnection();

        return result; //true = ko tồn tại; false = có tồn lại
    }

    public boolean addNewItem(ItemDTO newItem) throws Exception {

        boolean result;
        cnn = MyConnection.getConnect();
        String sql = "Insert into Items values(?,?,?,?,?,?)";

        preSta = cnn.prepareStatement(sql);

        preSta.setString(1, newItem.getItemCode());
        preSta.setString(2, newItem.getItemName());
        preSta.setString(3, newItem.getSupCode());
        preSta.setString(4, newItem.getUnit());
        preSta.setString(5, newItem.getPrice());
        preSta.setBoolean(6, newItem.isSupplying());
        result = (preSta.executeUpdate() > 0);

        closeConnection();

        return result;
    }

    public boolean updateItem(ItemDTO item) throws Exception {

        boolean result;
        cnn = MyConnection.getConnect();
        String sql = "UPDATE Items set ItemName = ?, SupCode = ?, unit = ?,"
                + " price = ?, supplying = ?\n"
                + " WHERE itemCode = ?";

        preSta = cnn.prepareStatement(sql);
        preSta.setString(1, item.getItemName());
        preSta.setString(2, item.getSupCode());
        preSta.setString(3, item.getUnit());
        preSta.setString(4, item.getPrice());
        preSta.setBoolean(5, item.isSupplying());
        preSta.setString(6, item.getItemCode());

        result = (preSta.executeUpdate() > 0);
        closeConnection();

        return result;
    }

    public boolean deleteItem(String itemCode) throws Exception {

        boolean result;
        cnn = MyConnection.getConnect();
        String sql = "DELETE FROM Items\n"
                + "WHERE itemCode = ?";

        preSta = cnn.prepareStatement(sql);
        preSta.setString(1, itemCode);

        result = (preSta.executeUpdate() > 0);
        closeConnection();

        return result;
    }
}
