package hello;

import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;

@Controller
@RequestMapping("/webhook")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody WebhookResponse webhook(@RequestBody String jsonData){

        System.out.println(jsonData);
        String action = getAction(jsonData);
        if(action.equalsIgnoreCase("getAddress")){
            String adrress = getAdrress(jsonData);
            GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCIN10kIcLKR4SVCaI21bq0_KrfPbfFgJI");
            
            GeocodingResult[] results = null;
            try {
        	results = GeocodingApi.newRequest(context)
        		.address(adrress)
        		.components(ComponentFilter.country("BRA")).await();
        	System.out.println("lat"+ results[0].geometry.location.lat);
        	System.out.println("long"+ results[0].geometry.location.lng);
            } catch (Exception e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
            }
            return new WebhookResponse("Olá! Confira no mapa de esse é o seu endereço\n link "
            	+ "-> http://maps.google.com/?q="+results[0].geometry.location.lat+","+results[0].geometry.location.lng, "Text " + action);
            
        }
        return new WebhookResponse("Test","Test");
    }

    private String getAction(String jsonData) {
	ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonData.getBytes());
          
            JsonNode result = rootNode.path("result");
            JsonNode action = result.path("action");
            String actionValue = action.asText();   
            return actionValue;
	} catch (JsonParseException e) {
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	}
	return "";
    }
    
    private String getAdrress(String jsonData) {
   	ObjectMapper objectMapper = new ObjectMapper();
           try {
               JsonNode rootNode = objectMapper.readTree(jsonData.getBytes());
             
               JsonNode result = rootNode.path("result");
               ArrayNode context = (ArrayNode) result.path("contexts");
               Iterator<JsonNode> fields = context.elements();
               while(fields.hasNext()){
        	   JsonNode next = fields.next();
        	   JsonNode nameTag = next.path("name");
		if(nameTag.asText().equals("citynamecontext")){
		    JsonNode parameters = next.path("parameters");
		    String streetType = parameters.path("streetType.original").asText();
		    String strName = parameters.path("any.original").asText();
		    String addressNumber = parameters.path("addressNumber.original").asText();
		    String addressCity = parameters.path("addressCity.original").asText();
		    return streetType+" "+strName+" "+addressNumber+" "+addressCity;
        	  }
               }
               return null;
   	} catch (JsonParseException e) {
   	    e.printStackTrace();
   	} catch (JsonMappingException e) {
   	    e.printStackTrace();
   	} catch (IOException e) {
   	    // TODO Auto-generated catch block
   	}
   	return "";
       }
}
