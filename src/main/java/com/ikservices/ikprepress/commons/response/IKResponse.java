package com.ikservices.ikprepress.commons.response;

import com.ikservices.ikprepress.commons.vo.IKMessageVO;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class IKResponse <T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T obj;
    private List<T> objList;
    private final List<IKMessageVO> messages;

    private IKResponse() {
        this.messages = new ArrayList<>();
    }

    public static <T> IKResponse<T> build() {
        return new IKResponse<T>();
    }

    public IKResponse<T> body(T obj) {
        this.obj = obj;
        return this;
    }

    public IKResponse<T> body(List<T> objList) {
        this.objList = objList;
        return this;
    }

    public IKResponse<T> addMessage(IKMessageVO ikMessage) {
        this.messages.add(ikMessage);
        return this;
    }
}
