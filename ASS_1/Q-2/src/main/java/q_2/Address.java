/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q_2;

/**
 *
 * @author root
 */
public class Address {
    public String name, homeAddress, homePhone, busAddress, busPhone, fax, cell, pager;

    public Address(String name, String homeAddress, String homePhone, String busAddress, 
                   String busPhone, String fax, String cell, String pager) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.homePhone = homePhone;
        this.busAddress = busAddress;
        this.busPhone = busPhone;
        this.fax = fax;
        this.cell = cell;
        this.pager = pager;
    }
}