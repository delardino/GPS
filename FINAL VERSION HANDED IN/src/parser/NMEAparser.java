package parser;
import dataTypes.record;
import exceptions.*;

import java.util.*;

/**
 *  This class stands for parsing GPS data
 * 
 * @author Aydan Halilov
 */
public class NMEAparser {
	public static final int TYPE_NA = -1;
	public static final int TYPE_START = -2;
	public static final int TYPE_GMRC = 0;
	public static final int TYPE_GPGGA = 1;
	
	public static int parser(String s, record rec)throws ParseExcemption{
		tokenizer tokenizer = new tokenizer(s);
		int type = 0;
		try{
			String token = tokenizer.next();
			
			while(token.endsWith("$GPRMC")==false){
				token = tokenizer.next();
				//System.out.println(token);
			}
			if(token.endsWith("$GPRMC")){
				type = TYPE_GMRC;
				// taken time of fix
				String row_dateTimeOfFix=tokenizer.next();
				String hour_dateTimeOfFix=row_dateTimeOfFix.substring(0,2);
				String min_dateTimeOfFix=row_dateTimeOfFix.substring(2,4);
				String sec_dateTimeOfFix=row_dateTimeOfFix.substring(4,6);
				record.dateTimeOfFix = 
					hour_dateTimeOfFix + ":" + min_dateTimeOfFix + 
					":" + sec_dateTimeOfFix + "";
				// Status
				String status = tokenizer.next();
				record.status = status;
				//Latitude
				String raw_lat=tokenizer.next();
				String lat_deg=raw_lat.substring(0,2);
				String lat_min1=raw_lat.substring(2,4);
				String lat_min2=raw_lat.substring(5);
				String lat_min3="0."+lat_min1+lat_min2;
				float lat_dec=Float.parseFloat(lat_min3)/.6f;
				float lat_val=Float.parseFloat(lat_deg)+lat_dec;
				//Latitude direction
				String lat_direction = tokenizer.next();
				if(lat_direction.equals("N")){
					//do nothing
					}else{
						lat_val = lat_val*-1;
					}
				record.latitude = lat_val+"";
		        // Longitude
                String raw_lon = tokenizer.next();
                String lon_deg = raw_lon.substring(0, 3);
                String lon_min1 = raw_lon.substring(3, 5);
                String lon_min2 = raw_lon.substring(6);            
                String lon_min3 = "0." + lon_min1 + lon_min2;
                float lon_dec = Float.parseFloat(lon_min3)/.6f;
                float lon_val = Float.parseFloat(lon_deg) + lon_dec;
                
                
                // Longitude direction
                String lon_direction = tokenizer.next();
                if(lon_direction.equals("E")){
                    // do nothing
                } else {
                    lon_val = lon_val * -1;
                }
                record.longitude = lon_val + "";

                record.groundSpeed = tokenizer.next();

                record.degree = tokenizer.next();
                record.date = tokenizer.next();
                record.magneticVariation = tokenizer.next();
                record.star = tokenizer.next();
                
                // Ignore rest
                return 200;
            }

        }
        // Parsing exception.
        catch (NoSuchElementException e) {
                throw new ParseExcemption("Unexpected end of the input data.");
        } 

        return type;

    }
	}


