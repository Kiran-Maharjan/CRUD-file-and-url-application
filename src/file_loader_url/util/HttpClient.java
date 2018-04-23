/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_loader_url.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author kiran
 */
public class HttpClient {

    public static String get(String link) throws MalformedURLException, IOException {

        URL url = new URL(link); //--equivalent to typing to browser
        //URLConnection conn =url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //--as http protocal specific, typecast it
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Safari/537.36");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        StringBuilder content = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\r\n");
        }
        reader.close();
        return content.toString();
    }
}
