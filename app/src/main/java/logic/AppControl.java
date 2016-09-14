package logic;

import com.isc.itsta.proyecto.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alejandra on 9/12/2016.
 */
public class AppControl {

    private static AppControl app;

    public static String[] users= new String[]{"doctor@example.com:doctor1"};

    public static ArrayList<Patient> patients = new ArrayList<Patient>();

    public AppControl(){
        patients.add(new Patient());
        patients.get(0).setAge(22);
        patients.get(0).setName("Luis Felipe Diaz Chica");
        patients.get(0).setBegin(new Date());
        patients.get(0).setMan(true);
        patients.add(new Patient());
        patients.get(1).setAge(43);
        patients.get(1).setName("Ricardo Suarez");
        patients.get(1).setBegin(new Date());
        patients.get(1).setMan(true);
        patients.add(new Patient());
        patients.get(2).setAge(75);
        patients.get(2).setName("Julia Romero");
        patients.get(2).setBegin(new Date());
        patients.get(2).setMan(false);
    }

    public static AppControl getInstance(){
        if(app==null){
            app = new AppControl();
        }
        return app;
    }

    public boolean login(String user, String password){
        Boolean log = false;
        String[] u;
        for(String s : users){
            u = s.split(":");
            log=log||(u[0].equals(user)&&u[1].equals(password));
        }
        return log;
    }

    public String getUser(String user){
        String res="";
        String[] u;
        for(String s : users){
            u=s.split(":");
            if(user.equals(u[0])){
               res = s;
            }
        }
        return res;
    }

    public int getNumberPatients(){
        return patients.size();
    }

    public Object[] getOPatient(int id){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Object[] patient = new Object[5];
        Patient p = patients.get(id);
        patient[0]=""+id;
        patient[1]=(p.isMan())? R.mipmap.sin_hombre:R.mipmap.foto_mujer;
        patient[2]=p.getName();
        patient[3]=sdfDate.format(p.getBegin());
        patient[4]=(p.getLast()!=null)?sdfDate.format(p.getLast()):"No disponible";
        return patient;
    }

    public Patient getPatient(int i){
        return patients.get(i);
    }


}
