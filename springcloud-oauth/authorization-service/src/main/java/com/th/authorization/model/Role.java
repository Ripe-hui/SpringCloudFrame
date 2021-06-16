package com.th.authorization.model;

import com.th.common.core.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Role extends BasePo {
    private String code;
    private String name;
    private String description;
}
