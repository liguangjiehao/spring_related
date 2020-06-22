package com.liguangjiehao.spring.service.impl;

import com.liguangjiehao.spring.dao.AccountDao;
import com.liguangjiehao.spring.dao.impl.JdbcAccountDaoImpl;
import com.liguangjiehao.spring.pojo.Account;
import com.liguangjiehao.spring.service.TransferService;

/**
 * Date: 2020/6/22
 * Author: LLLiGJ
 * Desc:
 */
public class TransferServiceImpl implements TransferService {
    private AccountDao accountDao = new JdbcAccountDaoImpl();
    @Override
    public void transfer(String fromCardNo, String toCardNo, int money)
            throws Exception {
        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);
        from.setMoney(from.getMoney()-money);
        to.setMoney(to.getMoney()+money);
        accountDao.updateAccountByCardNo(from);
        accountDao.updateAccountByCardNo(to);
    }
}
