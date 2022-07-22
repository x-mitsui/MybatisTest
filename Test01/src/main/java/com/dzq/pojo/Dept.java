package com.dzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 10:37
 * @Description: com.dzq.pojo
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {
    private Integer deptNo;
    private String DName;
    private String Loc;
}
