package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ContactTheAPIs {

    public static String interrogerCalcul(int a, int b, String operation){
        try {
            URL url = new URL("http://localhost:4242/api/v1/calcul/" + operation + "?a=" + a + "&b=" + b);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        }
        catch (Exception e){
            return "Erreur";
        }
    }

    public static int interrogerChrono(){
        try {
            URL url = new URL("http://localhost:8080/api/v1/chronometres/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return Integer.parseInt(content.toString());
        }
        catch (Exception e){
            return 0;
        }
    }
    public static int interrogerChrono(int id){
        try {
            URL url = new URL("http://localhost:8080/api/v1/chronometres/"+id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return Integer.parseInt(content.toString());
        }
        catch (Exception e){
            return 0;
        }
    }

    public static int creerMinuteur(int seconds){
        try {
            URL url = new URL("http://localhost:8080/api/v1/minuteurs/"+seconds);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return Integer.parseInt(content.toString());
        }
        catch (Exception e){
            return 0;
        }
    }
    public static int interrogerMinuteur(int id){
        try {
            URL url = new URL("http://localhost:8080/api/v1/minuteurs/"+id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return Integer.parseInt(content.toString());
        }
        catch (Exception e){
            return 0;
        }
    }
}
