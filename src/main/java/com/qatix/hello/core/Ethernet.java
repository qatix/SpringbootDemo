package com.qatix.hello.core;

import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

@Component
public class Ethernet {
//	private String ipAddress;
//	
//	public Ethernet(String ipAddress){
//		this.ipAddress = ipAddress;
//	}
//	
//	public String getIP(){
//		return this.ipAddress;
//	}
//	public void setIP(String ipAddress){
//		this.ipAddress = ipAddress;
//	}
//	
//	public String getMAC(){
//		String macAddress = null;
//		try{
//			Runtime.getRuntime().exec("ping " + ipAddress);
//			Process process = Runtime.getRuntime().exec("arp -a " + ipAddress);
//			InputStreamReader input = new InputStreamReader(process.getInputStream());
//			LineNumberReader reader = new LineNumberReader(input);
//			while(true){
//				String content = reader.readLine();
//				if(content != null)
//					if(content.indexOf(ipAddress) > 0){
//						macAddress = content.substring(content.indexOf("ipAddress")+25, content.indexOf("ipAddress")+42);
//						break;
//					}
//			}
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
//		return macAddress;
//	}
	public String getMAC(String ip){
		String macAddress = null;
		try{
			Runtime.getRuntime().exec("ping " + ip);
			Process process = Runtime.getRuntime().exec("arp -a " + ip);
			InputStreamReader input = new InputStreamReader(process.getInputStream(),"UTF-8");
			LineNumberReader reader = new LineNumberReader(input);
			while(true){
				String content = reader.readLine();
				if(content != null) {
					if (content.indexOf("未找到 ARP 项") >=0) {
						macAddress = "00-15-5D-1F-C4-0F";
						break;
					}
					if(content.indexOf(ip) > 0){
						macAddress = content.substring(content.indexOf("ipAddress")+25, content.indexOf("ipAddress")+42);
						break;
					}
				} else break;
					
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return macAddress;
	}
}
