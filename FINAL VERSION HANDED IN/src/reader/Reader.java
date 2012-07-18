package reader;
import mainStart.NavigationStart;
import mapView.*;

import java.io.*;
import java.util.*;
import javax.comm.*;
import java.lang.Process;

import calculations.Sleep;

import dijkstra.*;
import parser.NMEAparser;
import dataTypes.record;
import exceptions.ParseExcemption;

/**
 *  This class reads serial data and identifies
 * serial port connection.
 * There is main method to test codes
 * 
 * @author Aydan Halilov
 */
public class Reader implements Runnable, SerialPortEventListener {

	static CommPortIdentifier portId;

	static Enumeration portList;

	static InputStream inputStream;

	static SerialPort serialPort;

	static Thread readThread;

	// creating a new instance of record
	public static record gpsData = new record();

	public static void start() {



		portList = CommPortIdentifier.getPortIdentifiers();

		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
			{
				if (portId.getName().equals("COM1")||portId.getName().
						equals("COM2")||portId.getName().equals("COM3")||
						portId.getName().equals("COM4")||portId.getName().
						equals("COM5")||portId.getName().equals("COM6")||
						portId.getName().equals("COM7")||portId.getName().
						equals("COM8")||portId.getName().equals("COM9")||
						portId.getName().equals("COM10"));
				{
					//if (portId.getName().equals("COM1")) {
					Reader reader = new Reader();
				}
			}
		}
	}

	public Reader() {


		try {
			serialPort = (SerialPort) portId.open("MainClassApp", 2000);
		} catch (PortInUseException e) {
		}
		try {
			inputStream = serialPort.getInputStream();
		} catch (IOException e) {
		}
		try {
			serialPort.addEventListener(this);
		} catch (TooManyListenersException e) {
		}
		serialPort.notifyOnDataAvailable(true);
		try {
			serialPort.setSerialPortParams(
					4800, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
		} catch (UnsupportedCommOperationException e) {
		}
		readThread = new Thread(this);
		readThread.start();
	}

	public void serialEvent(SerialPortEvent event) {
		//SerialPort thePort;
		BufferedReader ifile = null;
		String line;



		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:

			try {
				ifile = new BufferedReader(
						new InputStreamReader(serialPort.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				line = ifile.readLine();
				if (line == null) {
					System.out.println("EOF on serial port.");
					System.exit(0);
				}
				//System.out.println(line);

				try {
					NMEAparser.parser(line, gpsData);
					//parser2 ps2 = new parser2();
					//gpsData = ps2.parser(line);

					System.out.println("longitude :"+gpsData.longitude);
					System.out.println("altitude :"+gpsData.latitude);
					//System.out.println("status :"+gpsData.status);
				} catch (ParseExcemption e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					//System.out.println("it is an error!..MainClass.");
				}

			} catch (IOException ex) {
				System.err.println("IO Error " + ex);

			}

			/*	if(gpsData.dataFound == true){
	    			try {
						inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}*/
		}

	}
	
	/*public static void cutStream(){
			try {
				stop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}*/
	
	public static void stop()throws Exception{
		//Process.getInputStream().close();
		serialPort.close();
		inputStream=null;
		readThread.interrupt();
		readThread.destroy();
	}
	
	public void run(){
			NavigationStart.calculateNaviagte();
	}
	
}
