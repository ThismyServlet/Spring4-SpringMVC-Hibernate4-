/****************************************************************************
Copyright (c) 2008-2010 Ricardo Quesada
Copyright (c) 2010-2012 cocos2d-x.org
Copyright (c) 2011      Zynga Inc.
Copyright (c) 2013-2014 Chukong Technologies Inc.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 ****************************************************************************/
package hdgame.zhuoyian.candy;

import org.cocos2dx.lib.Cocos2dxActivity;
























import com.ym.refpackage.Sjtg.x25.R;
import com.zhuoyian.pay.ZYAPay;
import com.zhuoyian.pluginsdk.ZYASDKUtil;

import android.os.Bundle;
import android.view.Window;

//import com.zyasdk.PayState;

public class AppActivity extends Cocos2dxActivity {

	static {
		System.loadLibrary("cocos2dcpp");
	}

	/**
	 * context
	 */
	private static AppActivity m_pMyGame;
	
	public static AppActivity getActivity(){
		return m_pMyGame;
	}

	/**
	 * PBindkey
	 */
	public static String PBINDKEY = "8D2AF738FFFFFFE241CBA8C8AED04F42";
	/**
	 * package id
	 */
	public static int PACKID;

	/**
	 * onCreate
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// 这个函数必须在super前面调用，否则会出异常，去除安卓标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		m_pMyGame = this;
		// hdben 初始化
		try {
			// zya
			PACKID = Integer.parseInt(ZYASDKUtil.getRawFileContent(m_pMyGame,
					R.raw.p));
			// init zya sdk
			ZYASDKUtil.init(this, PACKID, PBINDKEY, false);
			//init zya pay
			ZYAPay.init(m_pMyGame);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	


	public static final int SKILL_IMPACT_WAVE = 1101001;//十字冲击波		2元/个
	public static final int SKILL_BOMB = 1101002;//两个炸弹交换爆炸		2元/个
	public static final int SKILL_COLOR_BALL = 1101003;	//随机生成1个彩球		3元/个
	public static final int REVIVE_LIFE = 1101004;//复活道具		步数或时间用尽	
	//5元复活一次，步数关卡加5步，时间关卡加15秒
	 public static final int SURPRISE_PACK = 1101006;//惊喜礼包	包含道具：3个冲击波 3个炸弹 2个彩球 15元	
	 public static final int WIN_PACK = 1101007;//胜利礼包	包含道具：4个冲击波 4个炸弹 3个彩球 20元
	 public static final int NOOB_PACK = 1101008;//新手礼包	包含道具：1个冲击波 1个炸弹 1个彩球 6元
	 public static final int LOGIN_PACK = 1101009;//登录礼包	包含道具：2个冲击波 2个炸弹 2个彩球 10元
	 public static final int OFFLINE_PACK = 11010010;//离线礼包	包含道具：4个冲击波 4个炸弹 3个彩球 20元
	 

}
