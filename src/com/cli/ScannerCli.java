package com.cli;
import java.io.IOException;
import java.util.Scanner;

public class ScannerCli {
  public static void main (String args[]) throws IOException {
	  Scanner in = new Scanner(System.in);
	 
	  while (in.hasNextLine()) 
	  {
	       String commands = in.nextLine();
	       String cmd=commands;
	       String key="";
	       String value="";
	       if(!commands.isEmpty() && commands.contains(" ")) {
	    	  String[] splitStr=commands.split(" "); 
	    	  cmd=splitStr[0];
	    	  if(splitStr.length>1) {
	    		  key= splitStr[1];
	    	  }
	    	  if(splitStr.length>2) {
	    		  value= splitStr[2];
	    	  }
	       }
	       switch (cmd.toUpperCase()) {
	      
	          case "ADD":
	        	Add.addCache(key, value);	        	 
	          break;
	          case "KEYS":
	            Keys.getKeys();
	          break;
	          case "ALLMEMBERS":
	        	  Members.getAllMembers();
	          break;
	          case "ITEMS":
	             Items.getAllItems();
	          break;
	          case "CLEAR":
	             Remove.clear();
	          break;
	          case "KEYEXISTS":
	             KeyExist.isKeyExist(key);
	          break;
	          case "VALUEEXISTS":
	             ValueExist.isValueExist(key, value);
	          break;
	          case "MEMBERS":
	            Members.getValue(key);
	          break;
	          case "REMOVE":
	            Remove.remove(key, value);
	          break;
	          case "REMOVEALL":
	            Remove.removeAll(key);
	          break;
	          case "EXIT":
	 	        System.exit(0);
		      break;
	        default:
	        	 System.out.println(cmd+"is not a valid command!");
	          break;
	      }
	  }
  }
}
