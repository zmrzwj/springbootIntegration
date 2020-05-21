package com.sccddw.test.entity.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author dell
 * date 2020/5/8 15:11
 * @version 1.0
 **/
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(1, "成功"),
    ERROR(500,"程序内部错误"),
    EXIST_LIBRARY(501,"仓库下面存在库区"),
    EXIST_SHELF(502,"库区下面存在货架"),
    EXIST_LATTICE(503,"货架下面存在格子"),
    EXIST_MATERIAL(504,"格子下面存在物资"),
    LATTICE_EXCEED_1000(533,"每个货架最多可输入1000仓位"),
    MATERIAL_INFO_EXIST(505,"物资名称已存在"),
    NOT_REPEAT_REVIEW(506,"不能重复审核"),
    TRANSFER_APPLY_TITLE(507,"调拨单名称不能重复"),
    RECOVER_NAME(508,"回收单名称不能重复"),
    DISTRIBUTION_TITLE(509,"发放单名称不能重复"),
    EXIST_BEFORE_MATERIAL_INFO_TRANSFER(510,"存在更早入库的该物资可调拨"),
    EXIST_OPEN_LABEL_DEVICE(511,"请先关闭已开启的设备"),
    LABEL_DEVICE_IS_OPEN(512,"设备处于开启状态"),
    EXIST_SAME_LABEL_DEVICE(513,"不能添加设备型号相同的设备"),
    NO_CORRESPOND_OUT_ORDER(514,"该调拨单没有对应的出库单"),
    MATERIAL_TYPE_EXIST_MATERIAL_INFO(515,"该物资类型下面存在物资,不能删除"),
    MATERIAL_TYPE_EXIST(516,"该物资类型名称已存在"),
    CENTER_DEPOTINFO_NOT_DELETE(517,"中央仓库不能删除"),
    DONATION_ACTIVITY_NAME_EXIST(518,"活动标题已存在"),
    INTERFACE_CALL_EXCEPTION(519,"信息联动接口调用异常"),
    TRANSFER_FLAG_ERROR(520,"物资调拨标识位错误"),
    DEPOTINFO_BIND_USER_EXIST(521,"该仓库已经绑定用户,不能删除"),
    DEPOTINFO_BIND_DEP_EXIST(522,"该仓库已经绑定部门,不能删除"),
    DONATION_REPORT_FILE_UPLOAD_ERROR(523,"请检查文件格式及内容是否正确（参考下载模板）"),
    MATERIAL_INFO_TABLE_EXIST(524,"请先删除物资信息表中对应的物资"),
    DONATION_ACTIVITY_PUBLISH_SUCCESS(525,"发布成功,请前往民政网页查看"),
    DONATION_ACTIVITY_PUBLISH_ERROR(526,"发布失败!"),
    DONATION_ACTIVITY_HAS_PUBLISHED(527,"捐赠计划已发布,请前往民政网页查看"),
    EXIST_ORDER_NOT_FINISH(528,"存在未完成的单据,不能删除!"),
    MATERIAL_INFO_EXIST_STOCK(529,"仓库中存在该物资,不能删除!"),
    NO_DONATION_REPORT_MATERIAL_INFO(530,"请输入物资的实际捐赠数量!"),
    NO_CORRESPOND_TRANSFER_ORDER(531,"没有对应的调拨单!"),
    EXIST_SAME_USE_ORDER_NAME(532,"动用单名称不能重复"),
    STORAGE_QUANTITY_SHORT(533,"库存数量不足"),

    /* 参数错误：10001-19999 */
    PARAM_IS_ERROR(10005,"参数错误"),
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    PROGRAM_PROCESS_EXCEPTION(10006, "程序异常"),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_IS_LOCKED(20003, "账号已被锁定"),
    USER_UNLOCKED_ERROR(20004, "账号解锁失败"),
    USER_NOT_EXIST(20005, "用户不存在"),
    USER_HAS_EXISTED(20006, "用户已存在"),
    LOGINNAME_HAS_EXISTED(20007, "登录名已存在"),
    LOGINNAME_PWD_NOT_EXIST(20008, "用户名、密码不能为空"),
    OLD_LOGIN_PWD_ERROR(20009, "原密码错误"),
    LOGIN_PWD_EDIT_ERROR(20010, "密码修改失败"),
    LOGIN_SMS_CODE_ERROR(20011, "短信验证失败"),
    USER_QUESTION_ERROR(20012, "密保问题答案不正确"),
    USER_QUESTION_NOT_EXIST(20013, "还未设定密保"),
    PWD_IS_NULL(20014, "请输入密码"),
    LOGIN_PWD_ERROR(20015, "密码输入错误"),
    IMAGE_CODE_ERROR(20016, "验证码输入错误"),
    IMAGE_CODE_EXPIRED(20017, "验证码已过期"),
    USER_NOT_CCY(20018, "当前用户不是抽查员"),
    NO_PERMISSION_OPERATION(20019, "无权限操作"),

    /* 业务错误：30001-39999 */
    WORKSITECODE_HAS_EXISTED(30001, "工地编码已存在"),
    EQUIPMENTCODE_HAS_EXISTED(30002, "设备编码已存在"),
    MONITORDIVISORCODE_HAS_EXISTED(30003, "因子编码已存在"),
    ALARMSETTINGCODE_HAS_EXISTED(30004, "报警编号已存在"),

    SPECIFIED_QUESTIONED_DEPT_HAS_CHILDREN(31001,"该部门有子部门，请先移除其子部门"),
    SPECIFIED_QUESTIONED_DEPT_HAS_USER(31002,"该部门已分配用户，请先移除用户"),
    SPECIFIED_QUESTIONED_PRIV_HAS_CHILDREN(32001,"该权限有子权限，请先移除其子权限"),
    SPECIFIED_QUESTIONED_GROUP_HAS_CHILDREN(33001,"该通讯组有子通讯组，请先移除其子通讯组"),
    SPECIFIED_QUESTIONED_GROUP_HAS_BOOK(33002,"该通讯组有联系人，请先移除联系人"),



    AREA_CODE_HAS_EXISTED(35009,"区域编码已存在"),
    NETCELLCODE_HAS_EXISTED(35003, "工作网格设置编码已存在"),



    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),
    JWT_ERRCODE_NULL(40002, "签名不存在"),
    JWT_ERRCODE_EXPIRE(40003, "签名已过期"),
    JWT_ERRCODE_FAIL(40004, "签名验证不通过"),
    IP_IS_EMPTY(40005, "ip不存在"),
    IP_IS_ERROR(40005, "ip错误"),

    /* 数据错误：50001-599999 */
    RESULT_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    DATA_ADD_ERROR(50004, "数据新增失败"),
    DATA_EDIT_ERROR(50005, "数据更新失败"),
    DATA_DELETE_ERROR(50006, "数据删除失败"),
    DATA_QUERY_NONE(50007, "查询无结果"),
    DATA_OPERATE_ERROR(50006, "操作失败"),
    DATA_SAVE_ERROR(50009, "数据保存出错"),
    DATA_UPLOAD_ERROR(50010, "数据上传出错"),
    DATA_CAN_NOT_DEL(50011, "只能删除来源是资料管理的附件"),
    DATA_HISTORY_NULL(50012, "该记录暂无历史留痕"),
    DATA_EXIST(50013, "该记录已存在"),
    FILE_ERROR(50014,"系统找不到指定的文件"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, ""),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 业务受理系统 */
    INFO_IS_LOCKED(70001, "该条信息已被锁定"),

    DIR_NOT_EMPTY(80001, "文件夹不为空"),
    DIR_NOT_CHOOSE(80002, "索引不能为空"),
    CATEGORY_NOT_CHOOSE(80003, "请先选择一个类"),
    DIR_ERROR(80004, "目标文件夹是源文件夹的子文件夹"),
    DIR_EXIST(80006, "同名文件夹已存在"),
    CATEGORY_EXIST(80007, "类目已存在"),
    FILE_IS_NULL(80005, "没有上传的文件"),
    FILE_IS_MAX(80008, "文件大小不得超过10MB"),

    FILE_FAILURE(1009,"文件上传失败"),


    UNIT_IS_NULL(90001, "单位不存在"),
    SUBJECT_IS_NULL(90002, "科目不存在"),
    SERVICE_TYPE_IS_NULL(90003, "业务类型不存在"),


    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限");




    private static final Log LOGGER = LogFactory.getLog(ResultCode.class);

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取code
     * @return Integer
     * @author xiaozhiwei
     * date: 2018/10/18 16:50
     */
    public Integer code() {
        return this.code;
    }

    /**
     * 获取message
     * @return String
     * @author xiaozhiwei
     * date: 2018/10/18 16:50
     */
    public String message() {
        return this.message;
    }

    /**
     * 根据name获取message
     * @param name name
     * @return String
     * @author xiaozhiwei
     * date: 2018/10/18 16:52
     */
    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    /**
     * 根据name获取code
     * @param name name
     * @return Integer
     * @author xiaozhiwei
     * date: 2018/10/18 16:51
     */
    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

    /**
     * 校验重复的code值
     * @param args String[]
     * @author xiaozhiwei
     * date: 2018/10/18 16:51
     */
    public static void main(String[] args) {
        ResultCode[] apiResultCodes = ResultCode.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (ResultCode apiResultCode : apiResultCodes) {
            if (codeList.contains(apiResultCode.code)) {
                LOGGER.info(apiResultCode.code);
            } else {
                codeList.add(apiResultCode.code());
            }
        }
    }
}
