package server_v2.pkg0;
import java.net.*;
import java.io.*;
import com.pi4j.io.gpio.*;

public class Server_v20{
  MCP3008 ADC=new MCP3008(); //crea un oggetto MCP3008 per prendere segnale potenziometro
  final GpioController gpio = GpioFactory.getInstance();
  final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
  final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
  final GpioPinDigitalOutput ON = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00); 
  final GpioPinDigitalOutput TX = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
  
  ServerSocket server;
  Socket client;
  BufferedReader in;
  PrintWriter out;
  
  public void StartServer(){
    ON.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF); 
    pin.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF); 
    pin2.setShutdownOptions(true, PinState.HIGH, PinPullResistance.OFF);
    TX.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
    
    ON.setState(PinState.HIGH);
    pin.setState(PinState.HIGH);
    pin2.setState(PinState.HIGH);
    
    try {
      server = new ServerSocket(4000);// dichiarazione del socket client e del buffer di ingresso
      
      while(true){
        System.out.println("Server ready (CTRL-C quits)\n");
        // chiamata bloccante, in attesa di connessione da parte di un client client = server.accept();
        System.out.println("Client connected: "+client); TX.setState(PinState.HIGH);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(new BufferedWriter(newOutputStreamWriter(client.getOutputStream())), true); 
        String x="";
        
        new Thread(new Runnable() { public void run() {
          while (true){ out.println(ADC.ReadADC().substring(0,4)); }}).start();
        do{
          try{
          x=in.readLine(); }
          catch (Exception e) { e.printStackTrace();
         }
        

  switch(new Integer(x)){
    case 1:
    try {
      Thread.sleep(500);
      } catch(InterruptedException e) { } 
      System.out.println("SINISTRA");
      pin.setState(PinState.HIGH); 
      pin2.setState(PinState.LOW); 
      break;
      
    case 0:
      //try {
      // Thread.sleep(500);
      } catch(InterruptedException e) { } System.out.println("DESTRA"); 
      pin.setState(PinState.LOW);
      pin2.setState(PinState.HIGH);
      break;
      
    case 2:
      pin.setState(PinState.HIGH);
      pin2.setState(PinState.HIGH); 
      System.out.println("FERMO");
      break;
      }
      }while(!x.equals("-1"));
      TX.setState(PinState.LOW); 
      pin.setState(PinState.HIGH);
      pin2.setState(PinState.HIGH);
} }
catch (Exception e) { e.printStackTrace();
} }

public static void main(String[] args) {
  Server_v20 x=new Server_v20();
  x.StartServer(); }
}
