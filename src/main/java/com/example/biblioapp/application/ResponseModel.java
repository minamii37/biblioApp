package com.example.biblioapp.application;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Data
public class ResponseModel<T> {
    public List<T> viewModelList;
    ResponseEntity<String> responseEntity;
//    ResponseEntity<Map<String, String>> responseEntity;

    public ResponseModel(List<T> viewModelList, ResponseEntity<String> responseEntity) {
        this.viewModelList = viewModelList;
        this.responseEntity = responseEntity;
    }
}
