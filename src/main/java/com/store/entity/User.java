package com.store.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

//import java.time.LocalDateTime;
//import java.util.Date;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.TableField;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

//    private static final long serialVersionUID=1L;

   // @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userAccount;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;

    //@TableField(fill = FieldFill.INSERT)
    //private LocalDateTime createTime;
    private String createTime;
    
    //@TableField(fill = FieldFill.INSERT_UPDATE)
    //private LocalDateTime updateTime;   
    private String updateTime;
}

