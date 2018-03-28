package cn.sevendream.newprojdemo.common.util;

import java.util.Random;

/**
 * Created by zhangxue on 2018/3/28.
 */

public class DataUtil {
	/**
	 * 获取int范围类的随机数
	 * @return
	 */
	public int getRandomInt() {
		Random rand = new Random();
		return rand.nextInt();
	}
}
