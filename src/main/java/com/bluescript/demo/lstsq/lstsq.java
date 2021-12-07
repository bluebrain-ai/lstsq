package com.bluescript.demo.lstsq;

import com.bluescript.demo.model.ErrorMsg;
import com.bluescript.demo.model.WsRecv;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/lgstsq")
@Getter
@Setter
@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server/Application is down. Please contact support team.") })
public class lstsq {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/errormsg")
    public ResponseEntity<String> errorProcessor(@RequestBody String payload) {

        // if (payload.getWsRecvData() != null) {   
        //     if (payload.substring(0, 2) == "Q=") {
        //         log.warn("QMessgage");
        //     }
        // }
        ////Need to verify the data model -- Aggresive model kicked in.
        
      
        
        try {
            log.warn("Error Message:"+payload.toString());
            streamBridge.send("ibmtsq-out-0", payload);
        } catch (Exception e) {
            log.error(e);
        }

        try {
            //streamBridge.send("ibmtdq-out-0", payload);
        } catch (Exception e) {
            log.error(e);
        }

        return new ResponseEntity<>("Success", HttpStatus.OK);

    }

    
}
