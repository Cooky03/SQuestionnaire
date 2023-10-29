package com.demo1.controller;

import com.demo1.beans.HttpResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Random;

@RestController
@RequestMapping("/admin")
public class ShortUrlController {
    private String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String shortUrlPrefix = "http://127.0.0.1:8089/q/";
    private HashMap<String,String> map = new HashMap<>();

    @RequestMapping(value = "getShortUrl", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity getShortUrl(String questionnaireId){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
//        String key = creatKey();
//        while (map.containsKey(key)){
//            key = creatKey();
//        }
//        map.put(key, longUrl);
        httpResponseEntity.setCode("666");
//        httpResponseEntity.setData(shortUrlPrefix + key);
        httpResponseEntity.setData(shortUrlPrefix + questionnaireId);
        httpResponseEntity.setMessage("生成链接成功");
        return httpResponseEntity;
    }

    @RequestMapping(value = "getLongUrl", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity getLongUrl(String shortUrl){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        httpResponseEntity.setData(map.get(shortUrl.replace(shortUrlPrefix, "")));
        httpResponseEntity.setMessage("生成链接成功");
        return httpResponseEntity;
    }

    private String creatKey(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 6;i++){
            sb.append(BASE62.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }
}
