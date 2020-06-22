package com.liguangjiehao.spring.dao;

import com.liguangjiehao.spring.pojo.Account;

/**
 * Date: 2020/6/22
 * Author: LLLiGJ
 * Desc:
 */
public interface AccountDao {
    Account queryAccountByCardNo(String cardNo) throws Exception;
    int updateAccountByCardNo(Account account) throws Exception;
}
