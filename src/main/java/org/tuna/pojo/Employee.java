package org.tuna.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {

    private Integer emp_id;
    private String  emp_name;
    private String  gender;
    private String  email;
    private Integer dep_id;

}
