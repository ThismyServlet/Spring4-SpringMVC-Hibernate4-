package hdgame.zhuoyian.paytools;

import hdgame.zhuoyian.candy.AppActivity;
import android.util.Log;

import com.zhuoyian.pay.ZYAPay;
import com.zhuoyian.pay.listener.ZYAPayCallbackListener;
import com.zhuoyian.pay.listener.ZYAPayListener;
import com.zhuoyian.pay.util.NetworkOperators;
import com.zhuoyian.pluginsdk.LanguageUtil;
import com.zhuoyian.pluginsdk.PayRecordUtil;
import com.zyasdk.enums.PayState;
import com.zyasdk.model.PayParm;


/*
 * HDBen  
 * 
 * 注：此包中的两个类名字、已定义的函数名称、包名等都不能做任何修改，否则道具购买会崩溃。
 * 
 * 
 *  游戏打包成so库加载到安卓项目中，用户点击了任意付费道具之后c++代码会
 *  调用此全路径类： hdgame.zhuoyian.paytools.PayUtil
 *  这个包名不能修改，否则游戏调用付费会崩溃。
 *  如果需要修改这个包名c++代码需要重新编译成so库导入
 * */




///支付工具类，点击道具支付会调用这里的pay函数
@SuppressWarnings("unused")
public class PayUtil {
		private static AppActivity m_pActivity = AppActivity.getActivity();
		
	
		
		
		/*
		 * HDBen 
		 * 
		 * 道具的付费操作是用JNI完成的，用户点击了购买道具之后c++代码会调用此pay函数
		 * 
		 * 此函数名在c++代码中已经写死，不能进行修改，否则点击购买道具会崩溃。
		 * 如需修改pay函数则c++代码中的调用函数名需要重新修改
		 * */
	public static void pay(final int code) {
		//PaySuccessGrantTools.grantTools(code);
		// hdben 设置支付成功回调，调用c++函数发放道具给用户
		ZYAPayCallbackListener.getInstance().setCallback(new ZYAPayListener() {

			@Override
			public void payFail(String price, String unit,
					String payBusinessName, String logStr) {
				try {
					// zya
					PayRecordUtil.AddPR(
							m_pActivity,
							getPayParm(PayState.FAIL, payBusinessName, price,
									unit, logStr));
				} catch (Exception e) {

				}
			}

			@Override
			public void paySuccess(String price, String unit,
					String payBusinessName, String logStr) {
				Log.v("grantTool", "grantTool---------------------");
				PaySuccessGrantTools.grantTools(code);
				try {
					// zya
					PayRecordUtil.AddPR(
							m_pActivity,
							getPayParm(PayState.SUCCESS, payBusinessName,
									price, unit, logStr));
				} catch (Exception e) {

				}
			}
		});

		ZYAPay.pay(code);
	}
	
	
	
	
	/*
	 * HDBen
	 * getPayParm函数是保存上报服务器参数
	 * PayParm对象保存了所有需要用到的参数
	 * */
	
	private static PayParm getPayParm(PayState state, String payBusinessName,
			String price, String unit, String logStr) {
		PayParm pp = PayParm.create();
		pp.setPackId(AppActivity.PACKID);
		pp.setPayCompany(payBusinessName);
		pp.setPayCountry(LanguageUtil.getCountry(m_pActivity));
		pp.setPayMoney(price);
		pp.setPayState(state.getState());
		pp.setPayUnit(unit);
		pp.setPbindkey(AppActivity.PBINDKEY);
		pp.setOrderNo("");
		pp.setCodeRemark(logStr);
		pp.setOperators("" + NetworkOperators.getSimOperatorInfo(m_pActivity));
		return pp;
	}
	
	
}
