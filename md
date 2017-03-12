khjghg＃HeaderViewPager

具有共同头部的ViewPager，支持与ListView，GridView，ScrollView，WebView，RecyclerView嵌套使用。具有连续的滑动事件和滑动监听，支持下拉刷新。

该项目参考：https : //github.com/cpoopc/ScrollableLayout喜欢原作的可以使用。相比原项目，代码更简单易懂，扩展性更高，欢迎大家下载体验本项目，如果使用过程中遇到什么问题，欢迎反馈。

演示

图片 图片 图片

用法

该项目和我github上其他的视图相关的项目已经一起打包上传到jCenter仓库中（源码地址https://github.com/jeasonlzy0216/ViewCore），使用的时候可以直接使用编译依赖，用法下

该项目中使用到的大部分自定义控制件，均来源于上述仓库

    编译“ com.lzy.widget：鉴于核心：0.2.1 ”
或者使用

    编译项目（'：header_viewpager '）
2.实现原理

把自定义控制器HeaderViewPagerLayout的dispatchTouchEvent方法进行重写，根据手势方向决定是否分发事件，同时使用滚动滚动内部视图，达到滑动的连续性。具体详细代码，实例代码中会有详细注释。

代码参考

布局解析

自定义控制HeaderViewPagerLayout作为根布局
无论控制具有多少个子View，只有第一个子View被自定义控制按头部解析，所以，如果头部有多个View，可以使用ViewGroup包裹，例如下面实例使用的是LinearLayout包裹（头部是一个ViewPager和指示指示器），除了第一个View会被滑出去外，其余布局均不会被滑出。
如果滑动时，想让布局滑动到一定距离后停止在可能在xml布局中加入自定义属性app:hvp_topOffset="50dp"，值的大小表示距离顶部多少距离停止滑动
在头部滑动的过程中，可以使用setOnScrollListener设置滑动监听，动态改变头部据或者其他布局的动画
例如布局中做如下布局：

    <？xml version = “ 1.0 ” encoding = “ utf-8 ”？>
< FrameLayout  xmlns ：android = “ http://schemas.android.com/apk/res/android ”
              xmlns ：app = “ http://schemas.android.com/apk/res-auto ”
              android ：layout_width = “ match_parent “
              android ：layout_height = ” match_parent “ >

    < COM .lzy.widget.HeaderViewPager
         机器人：ID = “ @ + ID / scrollableLayout ”
        的android ：layout_width = “ match_parent ”
        机器人：layout_height = “ match_parent ”
        机器人：方向 = “垂直”
        应用程序：hvp_topOffset = “ 50dp ” >

        < RelativeLayout 
            android ：layout_width = “ match_parent ”
             android ：layout_height = “ 200dp ” >

            < COM .lzy.widget.loop.LoopViewPager
                 机器人：ID = “ @ + ID / pagerHeader ”
                的android ：layout_width = “ match_parent ”
                机器人：layout_height = “ match_parent ”
                应用程序：lvp_delayTime = “ 2000 ”
                的应用程序：lvp_isAutoLoop = “真” / >

            < COM .lzy.widget.tab.CircleIndicator
                 机器人：ID = “ @ + ID / CI ”
                的android ：layout_width = “ match_parent ”
                机器人：layout_height = “ 20dp ”
                机器人：layout_alignParentBottom = “真”
                的android ：背景 = “＃4000 ”
                应用：ci_normalRadiusColor = “ #FFF ”
                应用：ci_selectedRadiusColor = “ #FFF ” />
        </ RelativeLayout >

        < COM .lzy.widget.tab.PagerSlidingTabStrip
             机器人：ID = “ @ + ID /标签”
            的android ：layout_width = “ match_parent ”
            机器人：layout_height = “ 40dp ”
            机器人：背景 = “ @的mipmap / bg_menu_normal ”
            机器人：TEXTSIZE = “ 16sp “
             app ：pstsDividerColor = ”＃00000000 “
            应用：pstsIndicatorColor = “＃2DA4F0 ”
            应用程序：pstsIndicatorHeight = “ 2DP ”
            应用程序：pstsShouldExpand = “假”
            的应用程序：pstsTextAllCaps = “假”
            的应用程序：pstsUnderlineHeight = “ 2DP ” />app ：pstsShouldExpand = “ false ” app ：pstsTextAllCaps = “ false ” app ：pstsUnderlineHeight = “ 2dp ” />app ：pstsShouldExpand = “ false ” app ：pstsTextAllCaps = “ false ” app ：pstsUnderlineHeight = “ 2dp ” />

        < android .support.v4.view.ViewPager
             android ：id = “ @ + id / viewPager ”
             android ：layout_width = “ match_parent ”
             android ：layout_height = “ match_parent ” />
    </ com .lzy.widget.HeaderViewPager>

    < include 
        android ：id = “ @ + id / titleBar ”
         layout = “ @ layout / include_titlebar ” />
</ FrameLayout >
对于自定义控件，需要做如下初始化

    scrollableLayout 。setCurrentScrollableContainer（片段。得到（0））;
    viewPager 。addOnPageChangeListener（新 ViewPager。SimpleOnPageChangeListener（）{
         @覆盖
        公共 无效 使用onPageSelected（INT  位置）{
            scrollableLayout 。setCurrentScrollableContainer（片段。得到（位置））;
        }}
    }）;
如果需要对滑动过程进行监听，可以使用如下代码，currentY表示当前滑过的距离，maxY表示当前可以滑动的最大距离，有了这两个参数，就可以对任意布局，做任何动画了。例如如下代码就是实现视差动画效果的代码。

    scrollableLayout.setOnScrollListener（new HeaderViewPagerLayout.OnScrollListener（）{
        @覆盖
        public void onScroll（int currentY，int maxY）{
            image.setTranslationY（currentY / 2）;
        }}
    }）;
