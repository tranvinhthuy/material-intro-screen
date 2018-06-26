package agency.tango.materialintroscreen.widgets;

import android.content.Context;
import android.support.v4.view.CustomViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

import agency.tango.materialintroscreen.adapter.SlidesAdapter;

public class SwipeableViewPager extends CustomViewPager {
    private float startPos = 0;
    private int currentIt;
    private boolean swipingAllowed;
    private boolean alphaExitTransitionEnabled = false;

    public SwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        swipingAllowed = true;
    }

    @Override
    public boolean onInterceptTouchEvent(final MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        return false;
    }

    @Override
    public SlidesAdapter getAdapter() {
        return (SlidesAdapter) super.getAdapter();
    }

    @Override
    public boolean executeKeyEvent(KeyEvent event) {
        return false;
    }

    public void moveToNextPage()
    {
        setCurrentItem(getCurrentItem() + 1, true);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    public int getPreviousItem() {
        return getCurrentItem() - 1;
    }

    public void setSwipingRightAllowed(boolean allowed) {
        swipingAllowed = allowed;
    }

    public void alphaExitTransitionEnabled(boolean alphaExitTransitionEnabled) {
        this.alphaExitTransitionEnabled = alphaExitTransitionEnabled;
    }

    public boolean alphaExitTransitionEnabled() {
        return alphaExitTransitionEnabled && swipingAllowed;
    }

    private void resolveSwipingRightAllowed() {
        if (getAdapter().shouldLockSlide(getCurrentItem())) {
            setSwipingRightAllowed(false);
        } else {
            setSwipingRightAllowed(false);
        }
    }
}