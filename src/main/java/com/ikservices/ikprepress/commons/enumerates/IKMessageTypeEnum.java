package com.ikservices.ikprepress.commons.enumerates;

import com.ikservices.ikprepress.commons.constants.IKConstant;
import com.ikservices.ikprepress.commons.exceptions.IKExceptions;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IKMessageTypeEnum {
    SUCCESS(1, "Success"),
    WARNING(2, "Warning"),
    ERROR(3, "Error");

    private final Integer code;
    private final String description;

    public static IKMessageTypeEnum findByIndex(int index) {
        for (IKMessageTypeEnum value : IKMessageTypeEnum.values()) {
            if (value.ordinal() == index) {
                return value;
            }
        }
        throw new IKExceptions(IKConstant.INVALID_PARAM_MESSAGE);
    }
}
