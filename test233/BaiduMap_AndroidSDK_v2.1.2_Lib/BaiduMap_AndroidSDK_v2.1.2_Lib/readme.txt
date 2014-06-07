Android SDK v2.1.2是适用于Android系统移动设备的矢量地图开发包

v2.1.2，功能介绍：
地图展示：包括2D图、卫星图、3D图地图展示。
地图操作：提供控制平移、缩放、底图旋转、变换视角等地图相关操作的功能 。
自定义绘制：提供自定义绘制点、线、圆、矩形、凸多边形和文字的功能。
百度地图导航：提供调起百度地图Android版（v5.0及以上版本）导航功能。
地图搜索：提供根据关键字进行范围检索、城市检索和周边检索。且支持LBS云检索用户自有数据。
详情查询：提供餐饮类的POI的详细信息查看（Place详情）。
线路规划：提供公交、驾车和步行三种类型，多种方案（不含地铁、时间优先、最少换乘、最少步行）的线路规划。
地理编码：提供地址信息与坐标之间的相互转换。
位置标注：提供一个或多个POI位置标注，且支持用户自定义图标。
实时路况：提供城市、城际（城市之间的高速）实时交通路况信息图。
离线地图：提供离线地图功能，可节省用户流量。
定位：采用GPS、WIFI、基站、IP混合定位模式，请使用Android定位SDK获取定位信息，使用地图SDK定位图层进行位置展示。


较之v2.1.1，升级功能：

新增：
自定义指南针位置（类：MapController，方法：setCompassMargin）
自定义当前位置图标（类：MyLocationOverlay，方法：setMarker）
手势控制开关（类：MapController，方法：旋转控制setRotationGesturesEnabled、平移控制setScrollGesturesEnabled、缩放控制setZoomGesturesEnabled、视角控制setOverlookingGesturesEnabled）
文字绘制 （类：TextItem；类：TextOverlay）
凸多边形绘制（类：Geometry，方法：setPolygon）
驾车路径检索增加设置途经点 （类：MKSearch，重载方法：drivingSearch）
自定义覆盖物图层增加更新覆盖物信息接口（类：ItemizedOverlay , 方法：updateItem）

优化：
支持地图无级缩放
覆盖物支持多实例及根据覆盖物图层添加顺序显示覆盖物的顺序
联想词检索（类：MKSearch，方法：suggestionSearch）增加检索城市参数
优化长路线检索服务
几何绘制线条反走样优化
自定义覆盖物3D绘制（类：ItemizedOverlay）

修复：
修复实时路况显示异常的问题



1.3.x 版本 至 2.x.x  版本升级说明：

本段内容适用对象：
            本段内容适用于之前使用过百度地图SDK的开发者，即使用过1.3.5及之前版本进行开发的人员。
------------------------------------------------------------------------------------------
一、使用地图之前，要先初始化地图管理模块。
             代码如下：
                 BMapManager mBMapManager = new BMapManager(context);
                 mBMapManager.init("此处填写你申请的key",new MyGeneralListener()) // MyGeneralListener继承自MKGeneralListener接口
	 mBMapManager.start();

二、废弃了MapActivity类，使用MapView的Activity，自2.0以后无需再继承自MapActivity，可以在任意的Activity中使用。

三、MapView的onPause、onResume、destroy、onSaveInstanceState、onRestoreInstanceState方法，要在相应的Activity的onPause、onResume、onDestroy、onSaveInstanceState、onRestoreInstanceState方法中调用。
            示例代码：
	protected void onPause() {
                        mMapView.onPause();
                        super.onPause();
                } //其他代码类似，这里不一一举例。

四、MapView添加一个Overlay之后，调用MapView的refresh()方法(2.0以后)，替代invalidate()方法(1.3.5之前)。

PS：自2.0.0以后，有些类的包名可能改变，但只要类名不变，功能基本不变。用的时候需要注意。Overlay废弃了draw接口。若需要自绘图形，请参考官网开发指南覆盖物部分第8章节： 几何图形绘制图层。 

更多详细信息，请参考官网开发指南及Demo示例代码。
Android SDK  官网 ：  http://developer.baidu.com/map/sdk-android.htm