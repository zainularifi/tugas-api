/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;
/**
 *
 * @author zainu
 */
public class mahasiswa {
    String token = "ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49";
    String query ;
    private static JSONArray datamhs;
    private static int baris;
    public static int getbaris(){
        return baris;
    }
    public static void  setbaris(int baris){
        mahasiswa.baris=baris;
    }
    public static JSONArray getdatamhs(){
        return datamhs;
    }
    public static void  setdatamhs(JSONArray datamhs){
        mahasiswa.datamhs=datamhs;
}
    public JSONObject getmahasiswa(){
        query = "select * from t_mhs where angkatan = 2023 and deleted = 0 limit 200";
    HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
        .header("Content-Type", "application/json")
        .header("Cookie", "siakaditml=466fc5cfklinfidke45cn8gp8d4")
        .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
        .asString();

    String jsonresponse = response.getBody();
    JSONObject obj = new JSONObject(jsonresponse);

    return obj;
    }
}
