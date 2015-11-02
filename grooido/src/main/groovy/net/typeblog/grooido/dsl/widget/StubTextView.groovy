package net.typeblog.grooido.dsl.widget

import android.content.Context
import android.widget.TextView

import groovy.transform.CompileStatic

import net.typeblog.grooido.dsl.BaseView
import net.typeblog.grooido.dsl.BaseLayoutParams

@CompileStatic
class StubTextView<L extends BaseLayoutParams> extends BaseView<TextView, L> {
	private TextView mTextView

	StubTextView(TextView v, L lp) {
		super(v, lp)
		mTextView = mView as TextView
	}

	StubTextView(Context context, Class<L> clazz) {
		super(context, TextView.class, clazz)
		mTextView = mView as TextView
	}

	def text(String t) {
		mTextView.text = t
	}

	def text(int id) {
		mTextView.text = id
	}
}
