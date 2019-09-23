package iqiqiya.lanlana.nubiawallpaper;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Author: iqiqiya
 * Date: 2019/9/22
 * Time: 19:17
 * Blog: blog.77sec.cn
 * Github: github.com/iqiqiya
 */
public class HookNubiaPic implements IXposedHookLoadPackage {

    private String TAG = "努比亚";
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        // hook自己
        if (lpparam.packageName.equals("iqiqiya.lanlana.nubiawallpaper")) {
            XposedBridge.log("找到了我自己");
            Log.d(TAG, "找到了我自己");
            Class clasz = lpparam.classLoader.loadClass("iqiqiya.lanlana.nubiawallpaper.MainActivity");
            findAndHookMethod(clasz, "toastMessage", String.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    //super.afterHookedMethod(param);

                    Log.d(TAG,"hook我自己成功,原来的值是"+param.getResult().toString());
                    XposedBridge.log("hook我自己成功,原来的值是"+param.getResult().toString());
                    param.setResult("激活成功,嘿嘿");
                }
            });
        }
        if (lpparam.packageName.equals("cn.nubia.gallerylockscreen")) {
            XposedBridge.log("找到了努比亚锁屏画报");
            Log.d(TAG, "找到了努比亚锁屏画报");
            Class clanubia = lpparam.classLoader.loadClass("cn.nubia.gallerylockscreen.cache.CacheManager");
            findAndHookMethod(clanubia, "getWallpaperThroughSid",String.class,new XC_MethodHook() {
                /**@Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    //super.beforeHookedMethod(param);
                    Log.d(TAG,"ID是"+param.getResult());
                    XposedBridge.log("ID是"+param.getResult());
                }*/

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    //super.afterHookedMethod(param);
                    Log.d(TAG,"内容是"+param.getResult());
                    XposedBridge.log("内容是"+param.getResult());

                    /**if (param.hasThrowable()) return;
                    Class<?> cls = (Class<?>) param.getResult();
                    String name = cls.getName();
                    if ("cn.nubia.gallerylockscreen.settings.PhotoPreviewLayout".equals(name)) {

                        final Class<?> ArgAttr = XposedHelpers.findClass("android.util.AttributeSet",lpparam.classLoader);
                        final Class<?> ArgWPge = XposedHelpers.findClass("cn.nubia.common.bean.WallpaperPage",lpparam.classLoader);
                        final Class<?> ArContext = XposedHelpers.findClass("android.content.Context",lpparam.classLoader);
                        findAndHookMethod(cls, "PhotoPreviewLayout", ArContext, ArgAttr, int.class, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                //super.beforeHookedMethod(param);
                                XposedBridge.log("hook第一个PhotoPreviewLayout"+param.getResult().toString());
                                Log.d(TAG,"hook第一个PhotoPreviewLayout"+param.getResult().toString());
                            }
                        });

                        findAndHookMethod(cls, "PhotoPreviewLayout", ArContext, ArgAttr, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                //super.beforeHookedMethod(param);
                                XposedBridge.log("hook第二个PhotoPreviewLayout"+param.getResult().toString());
                                Log.d(TAG,"hook第二个PhotoPreviewLayout"+param.getResult().toString());
                            }
                        });

                        findAndHookMethod(cls, "loadImage", ArgWPge, new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                //super.beforeHookedMethod(param);
                                XposedBridge.log("hook第一个loadImage"+param.getResult().toString());
                                Log.d(TAG,"hook第一个loadImage"+param.getResult().toString());
                            }
                        });

                        findAndHookMethod(cls, "loadImage", String.class, new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                //super.beforeHookedMethod(param);
                                XposedBridge.log("hook第二个loadImage"+param.getResult().toString());
                                Log.d(TAG,"hook第二个loadImage"+param.getResult().toString());
                            }
                        });
                    } */
                }
            });
        }
    }

}
