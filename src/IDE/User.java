package IDE;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by wenxi on 2017/5/8.
 */
public class User {

    private final static File userInfo= new File("src/data/userInfo.txt");

    /*
    增加用户
     */
    public static void addUser(String userName,String psd) throws IOException {


        PrintWriter writer = new PrintWriter(new FileWriter(userInfo,true));

        writer.println(userName+":"+psd);
        writer.flush();
        writer.close();
    }

    /*
    用户是否存在
     */
    public static boolean isExisted(String userName) throws IOException {

        BufferedReader reader=new BufferedReader(new FileReader(userInfo));

        //ArrayList<String> users=new ArrayList<>();

        String line;
        while ((line=reader.readLine())!=null){
            if(userName.equals(line.split(":")[0])){
                return true;
            }
        }

        return false;
    }


    /*
    检查用户名与密码
    已经确定用户名存在
     */
    public static boolean chechInfo(String userName,String psd) throws IOException {

        String line;

        BufferedReader reader=new BufferedReader(new FileReader(userInfo));


        while ((line=reader.readLine())!=null){
            if(userName.equals(line.split(":")[0])){
                if(psd.equals(line.split(":")[1])){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }


}
