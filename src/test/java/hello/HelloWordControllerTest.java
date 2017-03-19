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
    
    String param = "\r\n{\r\n    \"lang\": \"en\", \r\n    \"status\": {\r\n        \"errorType\": \"success\", \r\n        \"code\": 200\r\n    }, \r\n    \"timestamp\": \"2017-02-09T16:06:01.908Z\", \r\n    \"sessionId\": \"1486656220806\", \r\n    \"result\": {\r\n        \"parameters\": {\r\n            \"city\": \"Rome\", \r\n            \"name\": \"Ana\"\r\n        }, \r\n        \"contexts\": [], \r\n        \"resolvedQuery\": \"my name is Ana and I live in Rome\", \r\n        \"source\": \"agent\", \r\n        \"score\": 1.0, \r\n        \"speech\": \"\", \r\n        \"fulfillment\": {\r\n            \"messages\": [\r\n                {\r\n                    \"speech\": \"Hi Ana! Nice to meet you!\", \r\n                    \"type\": 0\r\n                }\r\n            ], \r\n            \"speech\": \"Hi Ana! Nice to meet you!\"\r\n        }, \r\n        \"actionIncomplete\": false, \r\n        \"action\": \"greetings\", \r\n        \"metadata\": {\r\n            \"intentId\": \"9f41ef7c-82fa-42a7-9a30-49a93e2c14d0\", \r\n            \"webhookForSlotFillingUsed\": \"false\", \r\n            \"intentName\": \"greetings\", \r\n            \"webhookUsed\": \"true\"\r\n        }\r\n    }, \r\n    \"id\": \"ab30d214-f4bb-4cdd-ae36-31caac7a6693\", \r\n    \"originalRequest\": {\r\n        \"source\": \"google\", \r\n        \"data\": {\r\n            \"inputs\": [\r\n                {\r\n                    \"raw_inputs\": [\r\n                        {\r\n                            \"query\": \"my name is Ana and I live in Rome\", \r\n                            \"input_type\": 2\r\n                        }\r\n                    ], \r\n                    \"intent\": \"assistant.intent.action.TEXT\", \r\n                    \"arguments\": [\r\n                        {\r\n                            \"text_value\": \"my name is Ana and I live in Rome\", \r\n                            \"raw_text\": \"my name is Ana and I live in Rome\", \r\n                            \"name\": \"text\"\r\n                        }\r\n                    ]\r\n                }\r\n            ], \r\n            \"user\": {\r\n                \"user_id\": \"PuQndWs1OMjUYwVJMYqwJv0/KT8satJHAUQGiGPDQ7A=\"\r\n            }, \r\n            \"conversation\": {\r\n                \"conversation_id\": \"1486656220806\", \r\n                \"type\": 2, \r\n                \"conversation_token\": \"[]\"\r\n            }\r\n        }\r\n    }\r\n}";
    @Test
    public void testName() throws Exception {
	HelloWorldController controller = new HelloWorldController();
	controller.webhook(param);
    }
}
