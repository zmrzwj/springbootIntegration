package com.sccddw.test.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/5/8 15:19
 * @version 1.0
 **/
@ApiModel(value = "用户")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("drsrs_user")
public class User implements Serializable {

    @Min(groups = {UserFindValidView.class,UserResetPwdValidView.class},value = 10, message="id错误")
    @NotNull(groups = {UserFindValidView.class,UserResetPwdValidView.class}, message="id不能为空")
    @TableId(value = "id",type = IdType.AUTO)
    Integer id;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableId(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableId(value = "update_time")
    private Date updateTime;

    @ApiModelProperty("创建用户id")
    @TableField(value = "create_id")
    private Integer createId;

    @ApiModelProperty("最后修改用户id")
    @TableField(value = "modify_id")
    private Integer modifyId;

    @ApiModelProperty(value = "用户名/定为输入的手机号码")
    @TableField(value = "username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty("账户人员姓名")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty("人员编码")
    @TableField(value = "code")
    private String code;

    @ApiModelProperty("性别/1男，2女")
    @TableField(value = "sex")
    private String sex;

    @ApiModelProperty("证件类型")
    @TableField(value = "ID_type")
    private String IDType;

    @ApiModelProperty("证件号码")
    @TableField(value = "ID_num")
    private String IDNum;

    @ApiModelProperty("所属部门")
    @TableField(value = "dep_id")
    private Integer depId;

    @ApiModelProperty("职务")
    @TableField(value = "duty")
    private String duty;

    @ApiModelProperty("用户类型")
    @TableField(value = "role_id")
    private Integer roleId;

    @ApiModelProperty("手机号码")
    @TableField(value = "phone")
    private String phone;

    @ApiModelProperty("邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty("联系人电话(固定电话)")
    @TableField(value = "fixed_line")
    private String fixedLine;

    @ApiModelProperty("紧急联系人")
    @TableField(value = "emergency_contact")
    private String emergencyContact;

    @ApiModelProperty("紧急电话")
    @TableField(value = "emergency_phone")
    private String emergencyPhone;

    @ApiModelProperty("备注")
    @TableField(value = "remark")
    private String remark;


    @ApiModelProperty(value = "本次登录时间", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableId(value = "login_time")
    private Date loginTime;

    @ApiModelProperty(value = "上次登录时间", hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableId(value = "last_login_time")
    private Date lastLoginTime;



    /*********************************/
//    //部门
//    @TableField(exist = false)
//    private Dep dep;
//    @TableField(exist = false)
//    private String depStr;
//    //用户类型
//    @TableField(exist = false)
//    private Role role;

    @TableField(exist = false)
    private String roleStr;

    //旧密码
    @TableField(exist = false)
    private String oldPassword;

//    //用户相关部门
//    @TableField(exist = false)
//    private List<UserDepot> userDepots;
//
//    @TableField(exist = false)
//    private List<Module> moduleList;
//
//    @TableField(exist = false)
//    private UserDepot depDepots;

    @TableField(exist = false)
    private Object depArr;

    @TableField(exist = false)
    private Boolean isPurchaser;

    public interface UserLoginValidView {
    }
    public interface UserFindValidView {
    }
    public interface UserResetPwdValidView {
    }
}
