package net.typeblog.grooido.dsl

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams as LP
import android.widget.LinearLayout
import android.widget.TextView

import groovy.transform.CompileStatic

import net.typeblog.grooido.dsl.widget.StubTextView
import net.typeblog.grooido.dsl.layout.StubLinearLayout

@CompileStatic
abstract class BaseViewGroup<V extends ViewGroup, L extends BaseLayoutParams, T extends BaseLayoutParams> extends BaseView<V, L> {
	Class<T> mMyLp
	private V mViewGroup

	BaseViewGroup(V v, L lp, Class<T> myLp) {
		super(v, lp)
		mMyLp = myLp
		mViewGroup = mView as V
	}

	BaseViewGroup(Context context, Class<V> clazz, Class<L> clazzLp, Class<L> myLp) {
		super(context, clazz, clazzLp)
		mMyLp = myLp
		mViewGroup = mView as V
	}

	LinearLayout linearLayout(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = StubLinearLayout) Closure cl) {
		addView(StubLinearLayout.class, cl) as LinearLayout
	}

	TextView textView(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = StubTextView) Closure cl) {
		addView(StubTextView.class, cl) as TextView
	}

	protected View addView(Class<? extends BaseView> clazz, Closure cl) {
		try {
			def v = clazz.newInstance(mView.context, mMyLp)
			cl.delegate = v
			cl.resolveStrategy = Closure.DELEGATE_FIRST
			cl.call()
			v.addTo(mViewGroup)
			return v.view
		} catch (Exception e) {
			throw new RuntimeException(e)
		}
	}
}
