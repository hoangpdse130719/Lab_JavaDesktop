/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangpd.dtos;

import java.io.Serializable;

/**
 *
 * @author phamduchoang
 */
public class SupplierDTO implements Serializable{
    private String supCode;
    private String supName;
    private String address;
    private boolean colloborating;

    public SupplierDTO(String supCode, String supName, String Address, boolean colloborating) {
        this.supCode = supCode;
        this.supName = supName;
        this.address = Address;
        this.colloborating = colloborating;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public boolean isColloborating() {
        return colloborating;
    }

    public void setColloborating(boolean colloborating) {
        this.colloborating = colloborating;
    }
    public Object[] toArrayObject(){
        return new Object[]{supCode,supName,address,colloborating};
    }
    
}
