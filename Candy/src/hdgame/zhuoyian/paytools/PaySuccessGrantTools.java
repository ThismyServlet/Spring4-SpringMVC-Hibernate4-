package hdgame.zhuoyian.paytools;

public class PaySuccessGrantTools {
 /*
  * hdben 用户购买成功之后这个类调用c++的函数发放道具
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
	
	
	/*
	 * HDBen
	 * grantTools函数是用户成功购买道具之后发放道具的函数
	 * toolsID是自定义的道具ID，此ID是唯一标识
	 * 传入需要发放的道具ID，发放数量在游戏代码中都是默认的
	 * 
	 * 此函数的包名也是不可变更，否则发放道具的时候游戏会崩溃，
	 * 如需修改包名请修改游戏中的c++代码，重新编译成so库导入安卓项目中
	 * */
	
	
	//发放道具函数，toolsID是每个付费道具对应的ID
	public static native void grantTools(int toolsID);
}
