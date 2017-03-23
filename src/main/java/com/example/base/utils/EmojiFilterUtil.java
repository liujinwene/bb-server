package com.example.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiFilterUtil {
	public static final String filter(String str) {
		if (ObjectUtil.isEmpty(str)) {
			return str;
		}
		
		String pattern="[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";  
        String reStr="";  
        Pattern emoji=Pattern.compile(pattern, Pattern.UNICODE_CASE|Pattern.CASE_INSENSITIVE);  
        Matcher  emojiMatcher=emoji.matcher(str);  
        str=emojiMatcher.replaceAll(reStr);  
        return str;  
	}
	
	public static void main(String[] args) {
		
		String str = "{\"dataList\":[{\"createTime\":1468507502000,\"id\":1436,\"phone\":\"12012340002\",\"startTime\":1468511040000,\"status\":0,\"subject\":\"弄\",\"updateTime\":1484221066000,\"userId\":222421,\"userName\":\"火柴02\"},{\"createTime\":1468564915000,\"id\":1440,\"phone\":\"13685626475\",\"startTime\":1468567980000,\"status\":2,\"subject\":\"ibase夏日狂欢，威新CP派对正式像你发来邀请！\",\"updateTime\":1484221066000,\"userId\":222501,\"userName\":\"朱睿\"},{\"createTime\":1468565545000,\"id\":1441,\"phone\":\"13685626475\",\"startTime\":1468568760000,\"status\":2,\"subject\":\"大咖驾到，5月19日投资界VR沙龙，视觉风暴震撼来袭！\",\"updateTime\":1484221066000,\"userId\":222501,\"userName\":\"朱睿\"},{\"createTime\":1468565961000,\"id\":1442,\"phone\":\"13685626475\",\"startTime\":1468652100000,\"status\":2,\"subject\":\"解读《欢乐颂》中的职场之道，不懂就出局！\",\"updateTime\":1484221066000,\"userId\":222501,\"userName\":\"朱睿\"},{\"createTime\":1468566583000,\"id\":1443,\"phone\":\"13685626475\",\"startTime\":1468569960000,\"status\":2,\"subject\":\"Steve Hoffman空将深圳，为你解析[硅谷藏宝]\",\"updateTime\":1484221066000,\"userId\":222501,\"userName\":\"朱睿\"},{\"createTime\":1468567016000,\"id\":1444,\"phone\":\"13685626475\",\"startTime\":1468739520000,\"status\":2,\"subject\":\"上市帮创业交流：如何自我推荐，才能抓住投资者的心？\",\"updateTime\":1484221066000,\"userId\":222501,\"userName\":\"朱睿\"},{\"createTime\":1468573047000,\"id\":1450,\"phone\":\"13246721240\",\"startTime\":1468573017000,\"status\":2,\"subject\":\"韩国 v\",\"updateTime\":1484221066000,\"userId\":222502,\"userName\":\"涂远诚\"},{\"createTime\":1473126993000,\"id\":1530,\"phone\":\"16010001000\",\"startTime\":1473130569000,\"status\":0,\"subject\":\"test\",\"updateTime\":1484221066000,\"userId\":222575,\"userName\":\"ibase官方账号\"},{\"createTime\":1473843187000,\"id\":1549,\"phone\":\"13603093089\",\"startTime\":1473843060000,\"status\":2,\"subject\":\"中秋茶话会火热进行中\uD83D\uDC4F\uD83D\uDC4F\uD83C\uDF89\uD83C\uDF89\",\"updateTime\":1484221066000,\"userId\":222561,\"userName\":\"胡盼\"},{\"createTime\":1474855892000,\"id\":1580,\"phone\":\"15814046755\",\"startTime\":1474956042000,\"status\":2,\"subject\":\"ibase专属福利 ｜ 1分钱即享办公室按摩护理\",\"updateTime\":1484221066000,\"userId\":230064,\"userName\":\"奚望\"},{\"createTime\":1476267312000,\"id\":1672,\"phone\":\"15814046755\",\"startTime\":1476597600000,\"status\":2,\"subject\":\"ibase宠物联谊派对\",\"updateTime\":1484221066000,\"userId\":230064,\"userName\":\"奚望\"},{\"createTime\":1476268290000,\"id\":1673,\"phone\":\"15814046755\",\"startTime\":1476597647000,\"status\":2,\"subject\":\"ibase宠物联谊派对\",\"updateTime\":1484221066000,\"userId\":230064,\"userName\":\"奚望\"},{\"createTime\":1477560639000,\"id\":1704,\"phone\":\"13603093089\",\"startTime\":1477560540000,\"status\":0,\"subject\":\"1\",\"updateTime\":1484221066000,\"userId\":222561,\"userName\":\"胡盼\"},{\"createTime\":1477561433000,\"id\":1705,\"phone\":\"13603093089\",\"startTime\":1477530000000,\"status\":0,\"subject\":\"2016中国VR/AR产业高峰论坛\",\"updateTime\":1484221066000,\"userId\":222561,\"userName\":\"胡盼\"},{\"createTime\":1477561783000,\"id\":1707,\"phone\":\"13603093089\",\"startTime\":1477530000000,\"status\":2,\"subject\":\"2016中国VR/AR产业高峰论坛\",\"updateTime\":1484221066000,\"userId\":222561,\"userName\":\"胡盼\"},{\"createTime\":1478665559000,\"id\":1774,\"phone\":\"13602473026\",\"startTime\":1478831400000,\"status\":2,\"subject\":\"ibase够小站双十一特惠\",\"updateTime\":1484221066000,\"userId\":227384,\"userName\":\"杨笛\"},{\"createTime\":1479455579000,\"id\":1846,\"phone\":\"13603093089\",\"startTime\":1479456042000,\"status\":0,\"subject\":\"风靡科技园的晓本烘焙来ibase原点啦\\n\",\"updateTime\":1484221066000,\"userId\":222561,\"userName\":\"胡盼\"},{\"createTime\":1479458047000,\"id\":1847,\"phone\":\"13603093089\",\"startTime\":1479457920000,\"status\":2,\"subject\":\"威新中心晓本烘焙福利进行中\",\"updateTime\":1484221066000,\"userId\":222561,\"userName\":\"胡盼\"},{\"createTime\":1481268692000,\"id\":1882,\"phone\":\"13603093089\",\"startTime\":1481268581000,\"status\":2,\"subject\":\"威新ibase送福利之手机内容啦\",\"updateTime\":1484221066000,\"userId\":222561,\"userName\":\"胡盼\"},{\"createTime\":1482395383000,\"id\":1921,\"phone\":\"13603093089\",\"startTime\":1482395446000,\"status\":2,\"subject\":\"ibase威新中心原住民圣诞茶话会\",\"updateTime\":1484221066000,\"userId\":222561,\"userName\":\"胡盼\"}]}";
		System.out.println(str);
		System.out.println(filter(str));
		
		
		
	}
}
