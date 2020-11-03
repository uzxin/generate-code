package com.example.generatecode.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;

/**
 * @description: 自定义sql日志打印
 * @author: YX
 * @date: 2020/9/7 17:41
 */
@Slf4j
public class MybatisLog implements Log {

    public MybatisLog(String clazz) {
        log.info(clazz);
    }

    @Override
    public boolean isDebugEnabled() {
        // return log.isDebugEnabled();
        // 将debug级别输出权限改成info级别
        return log.isInfoEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    @Override
    public void error(String s, Throwable throwable) {
        log.info("msg:{},throwable:{}", s, throwable);
    }

    @Override
    public void error(String s) {
        log.error(s);
    }

    @Override
    public void debug(String s) {
        log.debug(s);
    }

    @Override
    public void trace(String s) {
        log.trace(s);
    }

    @Override
    public void warn(String s) {
        log.warn(s);
    }
}