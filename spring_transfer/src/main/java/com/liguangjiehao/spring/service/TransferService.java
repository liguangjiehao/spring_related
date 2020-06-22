package com.liguangjiehao.spring.service;

/**
 * Date: 2020/6/22
 * Author: LLLiGJ
 * Desc:
 */
public interface TransferService {
    void transfer(String fromCardNo,String toCardNo,int money) throws
            Exception;
}
