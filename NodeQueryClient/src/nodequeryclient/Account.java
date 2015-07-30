/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodequeryclient;

import org.joda.time.DateTimeZone;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Robert
 */

public class Account {
    private String api="R0ScJcFjU3v6T1VjllIy7m7iRQHMoBW40d5oceDCJKhqhxNg";
    
    public void setAPI()
    {
    
    }

    private String getAccount()
{
     String uri = "https://nodequery.com/api/account?api_key="+api;
     
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(uri, String.class);
     System.out.println(result);
    return result;
}
    public String getAPI(){return api;}
    
   
    
    public static void main(String[] args) {
        DB db1=new DB();
        //getAccount();
      //  getName();
        //getRequests();
        
        
        // TODO code application logic here
    }
    public String getName()
    {
    JSONObject obj = new JSONObject(getAccount());
    String Name=obj.getJSONObject("data").getString("name");
 Name = Name.replaceAll("\\s",""); 

    System.out.println("Name: "+Name);
        return Name;
    
    }
    public int getMaxServ()
    {
    JSONObject obj = new JSONObject(getAccount());
int sl = obj.getJSONObject("data").getInt("server_limit");

    System.out.println("Timezone: "+sl);
        return sl;
    
    }
    public int getTimezone()
    {
    JSONObject obj = new JSONObject(getAccount());
int tz = obj.getJSONObject("data").getInt("timezone");

    System.out.println("Timezone: "+tz);
        return tz;
    
    }
    public int getRequests()
    {
    JSONObject obj = new JSONObject(getAccount());
int req = obj.getJSONObject("data").getJSONObject("api").getInt("requests");

    System.out.println("Requests: "+req);
        return req;
    
    }
    public int getRateLimit()
    {
    JSONObject obj = new JSONObject(getAccount());
int rl = obj.getJSONObject("data").getJSONObject("api").getInt("rate_limit");

    System.out.println("Requests: "+rl);
        return rl;
    
    }
    public DateTimeZone getTimeInzone()
    {
        DateTimeZone zoneUTC = DateTimeZone.forOffsetHours(getTimezone());
        return zoneUTC;
    }
    
    
    
    public void InsertAccount()
    {
    DB db3=new DB();
    db3.insertInto(getName(),getTimezone(),getRequests(),getRateLimit(),getMaxServ());
    }
    
}
