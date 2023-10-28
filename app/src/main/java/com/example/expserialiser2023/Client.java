package com.example.expserialiser2023;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Client implements Serializable
{
    private int num;
    private String nom;
    private static  ArrayList<Client> lstClients= new ArrayList<>();
   public static ArrayList<Client> getLstClients() {
        return lstClients;
    }

    public Client() {
    }
    public Client(int num, String nom) {
        this.num = num;
        this.nom = nom;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getNum() {
        return num;
    }
    public String getNom() {
        return nom;
    }
    @Override
    public String toString() {
        return "Client{" +
                "num=" + num +
                ", nom='" + nom + '\'' +
                '}';
    }

public static void serialiser(Context context)
{

    try{
        File path = context.getFilesDir();
        File file = new File(path, "client.txt");
       FileOutputStream  fos = new FileOutputStream(file,false);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Client.lstClients);

    } catch (Exception e) {
        Log.e("err : ", e.getMessage());
    }
}
    public static void deSerialiser(Context context){
        try{
            File path = context.getFilesDir();
            File file = new File(path, "client.txt");

            FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis);
            Client.lstClients = (ArrayList) ois.readObject();
        } catch (Exception e) {
            Log.e("err", e.getMessage());

        }

    }
    public static void ajouter(Client C)
    {
        lstClients.add(C);
    }

}
