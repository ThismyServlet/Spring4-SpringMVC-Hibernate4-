package hdgame.zhuoyian.candy;

public class PaySuccessGrantTools {
 /*
  * hdben 用户购买成功之后这个类调用c++的函数发放道具
  * */
	/*
	 * cocos2dx启动的主Activity类包名不能修改，否则会崩溃
	 * 全路径包名：hdgame.zhuoyian.candy.AppActivity  
	 *	
	 * */
	
	/*
	 * 以下道具ID是c++传递过来的对应道具
	 * const unsigned int SKILL_IMPACT_WAVE = 1101001;//十字冲击波		2元/个

	const unsigned int SKILL_BOMB = 1101002;//两个炸弹交换爆炸		2元/个

	const unsigned int SKILL_COLOR_BALL = 1101003;	//随机生成1个彩球		3元/个

	const unsigned int REVIVE_LIFE = 1101004;//复活道具		步数或时间用尽	
	//5元复活一次，步数关卡加5步，时间关卡加15秒
	 * 
	const unsigned int SURPRISE_PACK = 1101006;//惊喜礼包	包含道具：3个冲击波 3个炸弹 2个彩球 15元	

	const unsigned int WIN_PACK = 1101007;//胜利礼包	包含道具：4个冲击波 4个炸弹 3个彩球 20元

	const unsigned int NOOB_PACK = 1101008;//新手礼包	包含道具：1个冲击波 1个炸弹 1个彩球 6元

	const unsigned int LOGIN_PACK = 1101009;//登录礼包	包含道具：2个冲击波 2个炸弹 2个彩球 10元

	const unsigned int OFFLINE_PACK = 11010010;//离线礼包	包含道具：4个冲击波 4个炸弹 3个彩球 20元
	 * */
	
	
	//发放道具函数，toolsID是每个付费道具对应的ID
	public static native void grantTools(int toolsID);
}
