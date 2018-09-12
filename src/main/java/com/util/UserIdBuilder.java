
package com.util;

import java.util.UUID;

/**
 *@author : 李国鹏
 *@datetime : Sep 8, 2018 2:25:12 PM
 *@descriptioin :  成生用户的唯一 id
 */
public class UserIdBuilder {
	public static final String getUuid() {
		return UUID.randomUUID().toString();
	}
}
