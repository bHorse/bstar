package com.xiaosky.bstar.webmvc.test.common;

import com.xiaosky.bstar.webmvc.config.RootConfig;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaob on 2017/1/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(value = false)
@ContextConfiguration(classes = { RootConfig.class})
public class BaseTest {

}
