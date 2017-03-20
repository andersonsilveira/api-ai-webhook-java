/**
 * 
 */
package hello;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Anderson
 *
 */
public class HelloWordControllerTest {
    
String param = "{\r\n  \"id\": \"17e1ff98-1d84-4621-ac07-758bf3a508b6\",\r\n  \"timestamp\": \"2017-03-20T01:42:57.331Z\",\r\n  \"lang\": \"pt-br\",\r\n  \"result\": {\r\n    \"source\": \"agent\",\r\n    \"resolvedQuery\": \"Av. Professor Gomes de Matos, 40\",\r\n    \"action\": \"getAddress\",\r\n    \"actionIncomplete\": false,\r\n    \"parameters\": {\r\n      \"addressNumber\": {\r\n        \"number\": 40\r\n      },\r\n      \"any\": \"Professor Gomes de Matos\",\r\n      \"streetType\": \"Avenida\"\r\n    },\r\n    \"contexts\": [\r\n      {\r\n        \"name\": \"addresscontext\",\r\n        \"parameters\": {\r\n          \"streetType\": \"Avenida\",\r\n          \"streetType.original\": \"Av.\",\r\n          \"addressNumber.original\": \"40\",\r\n          \"addressNumber\": {\r\n            \"number\": 40,\r\n            \"number.original\": \"40\"\r\n          },\r\n          \"any.original\": \"Professor Gomes de Matos,\",\r\n          \"any\": \"Professor Gomes de Matos\"\r\n        },\r\n        \"lifespan\": 5\r\n      },\r\n      {\r\n        \"name\": \"citynamecontext\",\r\n        \"parameters\": {\r\n          \"streetType\": \"Avenida\",\r\n          \"streetType.original\": \"Av.\",\r\n          \"addressNumber.original\": \"40\",\r\n          \"addressNumber\": {\r\n            \"number\": 40,\r\n            \"number.original\": \"40\"\r\n          },\r\n          \"any.original\": \"Professor Gomes de Matos,\",\r\n          \"any\": \"Professor Gomes de Matos\",\r\n          \"addressCity.original\": \"Fortaleza\",\r\n          \"addressCity\": {\r\n            \"geo-city\": \"Fortaleza\",\r\n            \"geo-city.original\": \"Fortaleza\"\r\n          }\r\n        },\r\n        \"lifespan\": 4\r\n      }\r\n    ],\r\n    \"metadata\": {\r\n      \"intentId\": \"57a3e795-dfc6-4879-ac1d-e8ef0995ad0b\",\r\n      \"webhookUsed\": \"false\",\r\n      \"webhookForSlotFillingUsed\": \"false\",\r\n      \"intentName\": \"Address Prompt Intent\"\r\n    },\r\n    \"fulfillment\": {\r\n      \"speech\": \"\u00D3timo, vou estar verificando a disponibilidade.\",\r\n      \"messages\": [\r\n        {\r\n          \"type\": 0,\r\n          \"speech\": \"\u00D3timo, vou estar verificando a disponibilidade.\"\r\n        }\r\n      ]\r\n    },\r\n    \"score\": 1\r\n  },\r\n  \"status\": {\r\n    \"code\": 200,\r\n    \"errorType\": \"success\"\r\n  },\r\n  \"sessionId\": \"7bfb12a9-c35e-4b5c-8dad-9672a8ae7ec1\"\r\n}";
    @Test
    public void testName() throws Exception {
	HelloWorldController controller = new HelloWorldController();
	controller.webhook(param);
    }
}
