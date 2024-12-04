package com.codingshuttle.production_ready_feature.prod.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private int id;

    private String name;


    private int age;
     private String email;
    private LocalDate dateOfJoining;
//    @JsonProperty("isActive")
    public boolean isActive;

    //@Pattern(regexp = "^(USER|ADMIN)$")   //---> as we will use custom validations here.
//    custom validation here

    private String role;   //USER,ADMIN ---> means role can be either user or admin

//    @DecimalMax(value= "150000.80",message="max value can not be greater than the specified value")
//    @DecimalMin(value="100000.90",message="min value can not be greater than the specified value")
    private Double salary;

}
