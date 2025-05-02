package com.ikservices.ikprepress.commons.exceptions;

import com.ikservices.ikprepress.commons.enumerates.IKMessageTypeEnum;
import com.ikservices.ikprepress.commons.vo.IKMessageVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IKExceptions extends RuntimeException{

    private IKMessageVO ikMessage;

    public IKExceptions(String message) {
        super(message);
    }

    public IKExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public IKExceptions(IKMessageVO ikMessage) {
        super(ikMessage.getMessage());
        this.ikMessage = ikMessage;
    }

    public IKExceptions(IKMessageVO ikMessage, Throwable cause) {
        super(ikMessage.getMessage(), cause);
        this.ikMessage = ikMessage;
    }
}
