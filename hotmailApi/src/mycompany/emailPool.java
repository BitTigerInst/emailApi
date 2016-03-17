/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hliu
 */
public class emailPool {
    private static List<String> emailList=new ArrayList<>();
    static int emailNum=0;
    public emailPool(){
        emailList.add("wukongproject@hotmail.com");
        emailList.add("wukongproject01@hotmail.com");
        emailList.add("wukongproject02@hotmail.com");
        emailList.add("wukongproject03@hotmail.com");
    }
    public boolean tryNext(){
        emailNum++;
        if(emailNum==emailList.size()) return false;
        return true;
    }
    public String chooseEmail(){
        return emailList.get(emailNum);
    }
}
