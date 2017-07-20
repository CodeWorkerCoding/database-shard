package com.nchu.tech.database;

import org.junit.Test;

/**
 * Created by fujianjian on 2017/7/13.
 */
public class CommonMethodTest {

    @Test
    public void testJSONEscape() {
        String ret = "{\"reqNo\":\"e18dcc4bf6e144cfa0e2731b8f637c4c\",\"reqDate\":\"2017-07-13 15:35:03\",\"partnerId\":\"CFBS\",\"version\":\"2.0\",\"method\":\"smjr.order.splitflow\",\"id\":null,\"phoneNo\":\"18750617863\",\"orderId\":\"C20170713684425\",\"identityNo\":\"350521196301057016\",\"merchantNo\":\"无\",\"merchantName\":\"无\",\"periods\":\"6\",\"productNo\":\"1024\",\"productName\":\"放开花\",\"paymentType\":\"2\",\"principal\":4000.0,\"brandId\":\"无\",\"brandName\":\"无\",\"province\":\"无\",\"city\":\"无\",\"township\":\"无\",\"category\":\"无\",\"age\":19913,\"income\":1.0,\"merchantLevel\":\"2\",\"bankId\":\"建设银行\",\"isDiscount\":\"N\",\"isPassfourele\":\"N\",\"productType\":\"S\",\"dataType\":\"FQSQB;FQFWXY;WCJKHT;DZQMSQS;WTSQS;HGZ;PHOTO;SFZZM;SFZFM;JKHT;YHKZM;PHOTO\",\"auditingTimeStr\":\"2017-07-13 15:35:02\",\"creditReportTimeStr\":\"1970-01-01\",\"applicationIntervalDays\":0,\"carModel\":\"\",\"status\":\"UNKNOWN\"}";

    }
}
