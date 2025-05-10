package com.ikservices.ikprepress.commons.vo;

import com.ikservices.ikprepress.commons.enumerates.IKMessageTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IKMessageVO {
    private String code;
    private IKMessageTypeEnum type;
    private String message;
}
