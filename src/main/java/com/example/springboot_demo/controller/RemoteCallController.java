package com.example.springboot_demo.controller;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.ws.client.ResponseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/rest")
@Slf4j
public class RemoteCallController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "/debugTemplate")
    public void testTemplate() {
        String uri = UriComponentsBuilder.fromHttpUrl("http://www.baidu.com").toUriString();
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        log.error("{}", JSON.toJSONString(entity));
    }

}
