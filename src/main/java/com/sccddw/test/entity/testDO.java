package com.sccddw.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * description
 *
 * @author dell
 * date 2020/5/6 17:27
 * @version 1.0
 **/
@Data
@TableName("drsrs_allocate_depot_order_detail")
public class testDO {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableId(value = "disaster_material_use_id")
    private Integer disasterMaterialUseId;

    @TableField(value = "allocate_material_order_id")
    private Integer allocateMaterialOrderId;

    @TableId(value = "allocate_depot_order_id")
    private Integer allocateDepotOrderId;

    @TableField(value = "material_info_id")
    private Integer materialInfoId;

    @TableField(value = "material_info_temp_id")
    private Integer materialInfoTempId;

    @TableField(value = "batch")
    private String batch;

    @TableField(value = "storage_year")
    private String storageYear;

    @TableField(value = "depot_info_id")
    private Integer depotInfoId;

    @TableField(value = "storage_id")
    private Integer storageId;

    @TableField(value = "transfer_quantity")
    private Integer transferQuantity;
}
