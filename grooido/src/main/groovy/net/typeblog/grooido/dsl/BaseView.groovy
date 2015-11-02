package net.typeblog.grooido.dsl

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup

import groovy.transform.CompileStatic

import net.typeblog.grooido.dsl.layout.StubLinearLayout

@CompileStatic
abstract class BaseView<V extends View, L extends BaseLayoutParams>  {
	protected V mView
	protected L mParams

	BaseView(V v, L lp) {
		mView = v
		mParams = lp
	}

	BaseView(Context context, Class<V> clazz, Class<L> clazzLp) {
		try {
			mView = clazz.newInstance(context)
			mParams = clazzLp.newInstance(context)
		} catch (any) {
			throw new RuntimeException('Cannot create new View')
		}
	}

	def layout(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = L) Closure cl) {
		cl.delegate = mParams
		cl.resolveStrategy = Closure.DELEGATE_FIRST
		cl()
	}

	def addTo(ViewGroup vg) {
		vg.addView(mView)
		mParams.apply(mView)
	}

	V getView() {
		return mView
	}
}
