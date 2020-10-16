package com.Custom_tree;

public class Node
{
    private String Id_card;
    private String name;
    private String gender;
    private Node partner;
    boolean m_status;
    private Node children[];
    private Node father;
    private Node mother;
    public void add_child(Node node)
    {


    }

    public void setM_status(boolean m_status)
    {
        this.m_status = m_status;
    }

    public String getId_card() {
        return Id_card;
    }

    public void setId_card(String id_card) {
        Id_card = id_card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Node getPartner() {
        return partner;
    }

    public void setPartner(Node partner) {
        this.partner = partner;
    }
}
