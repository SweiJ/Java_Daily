package com.swei.ordermeal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.ordermeal.mapper.AddressBookMapper;
import com.swei.ordermeal.model.AddressBook;
import com.swei.ordermeal.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-14 21:48
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
