package com.example.springboot_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseServiceEntity {
    private Long id;
    private String planId;
    private Long serviceId;
    private String serviceName;
    private String pkgVersion;
    private Long pipelineId;
    private String pipelineName;
    private Byte isDeleted;
    private String creator;
    private String updater;
    private Date createTime;
    private Date updateTime;
}
