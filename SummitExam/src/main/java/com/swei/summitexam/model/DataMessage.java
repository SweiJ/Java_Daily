package com.swei.summitexam.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-14
 * Time: 16:49
 */
@Data
public class DataMessage {
    private String message;
    private Object data;
    private boolean success;
}
