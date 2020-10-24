package com.RMI;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class Adder_Driver extends UnicastRemoteObject implements Adder
{
    Adder_Driver() throws RemoteException
    {
        super();
    }


    @Override
    public int add(int num1, int num2) throws RemoteException {
        return num1+num2;
    }
}
