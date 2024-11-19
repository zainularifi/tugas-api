/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datamahasisw;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;
/**
 *
 * @author zainu
 */
public class Datamahasisw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
            .header("Content-Type", "application/json")
            .header("Cookie", "siakadtm1=t466f5cfklinfkde45cn8qp8d4")
            .body("{\"token\":\"ufb2a73edle2bae2403ea3b3e9b5eb8e6ed6fdb6b649\", \"query\":\"select * from t_mhs where angkatan='2022'\"}")
            .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");

        if (rows > 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
                String nama = item.getString("mhs_nama");
                System.out.println(nama);
            }
        }
    }
}
        
    
    

