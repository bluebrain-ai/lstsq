package com.bluescript.demo.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component

public class WsRecv {
    private String wsRecvTranid;
    private String wsRecvData;
 
 
}
