package com.example.test_ks.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ClientUtils {
    public static String postDataToServer(String hostUrl, String param, String postType) {
        String response = "";
        if (param != null && !param.isEmpty()) {
            try {
                // Construct data
                String data = URLEncoder.encode("data", "UTF-8") + "=" + URLEncoder.encode(encodeString(param), "UTF-8")
                        + "&" + URLEncoder.encode("type", "UTF-8") + "="
                        + URLEncoder.encode(encodeString(postType), "UTF-8");
                // Send data
                URL url = new URL(hostUrl);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();
                // Get the response
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    response += line;
                    //System.err.println(line);
                }
                wr.close();
                rd.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//		System.err.println(response);
        return response;
    }

    public static String encodeString(String str) throws UnsupportedEncodingException {
        String encoding = "UTF-8";
        byte[] encoded = str.getBytes(encoding);
        return new String(encoded, encoding);
    }
}
