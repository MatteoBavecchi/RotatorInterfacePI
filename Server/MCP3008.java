package server_v2.pkg0;
import java.io.*;

public class MCP3008 {
  public String ReadADC(){
    try{
    Process p = Runtime.getRuntime().exec("python readADC.py ");
    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String ret = in.readLine();
    return ret;
    }catch(Exception e){System.out.println(e);}
  return null;
  }
}
