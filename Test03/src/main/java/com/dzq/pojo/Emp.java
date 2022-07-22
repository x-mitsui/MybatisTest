package com.dzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 15:37
 * @Description: com.dzq.pojo
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp implements Serializable {
//    使用包装类，尽量和数据库保持一致吧，免去麻烦
    private Integer EmpNo;
    private String EName;
    private String Job;
    private String MGR;
    private Date HireDate;//使用父类Date，虽然返回的是sql date
    private Double Sal;
    private Double Comm;
    private Integer DeptNo;
}
