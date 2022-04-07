package com.uyibai.base.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebugInterfaceImpl implements DebugInterface{
    @Override
    public int targetMethod(int num) {
        log.debug("调用目标类的方法，参数为:{}" , num);
        return num;
    }
}
