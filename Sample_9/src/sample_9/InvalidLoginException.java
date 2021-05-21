/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample_9;

/**
 *
 * @author Haseeb
 */
public class InvalidLoginException  extends Exception
{
    InvalidLoginException(String data)
    {
        super(data);
    }
}
