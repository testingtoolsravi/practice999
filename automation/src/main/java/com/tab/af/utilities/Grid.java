package com.tab.af.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Grid {

  public String startGrid(String portNumber) throws UnknownHostException {

    String url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + portNumber;
    String consoleURL=url+ "/grid/console";
        
    HttpURLConnection huc = null;

    try {
      huc = (HttpURLConnection) (new URL(consoleURL).openConnection());

      huc.setRequestMethod("HEAD");

      huc.connect();
      if (huc.getResponseCode() == 200) {

        System.out.println("Hub Already running");

      }

    } catch (Exception e) {
      if (e.getMessage().contains("Connection refused")) {
        System.out.println("Hub is not Started");

        // For Hidden Mode Append " /B " After Start

        String hubPath = System.getProperty("user.dir") + "\\grid\\hub.bat";
        String command = "cmd.exe /C Start  " + hubPath;
        try {
          Runtime.getRuntime().exec(command);
          // wait so as to Let Hub Initializes Properly
          Thread.sleep(5000);
          System.out.println("Hub Started");
        } catch (InterruptedException | IOException ex) {

          ex.printStackTrace();
        }

      } else {
        e.printStackTrace();
      }
    }
    
    return url+"/wd/hub";
  }

}
