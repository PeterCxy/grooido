package net.typeblog.grooido.dsl.widget

import android.content.Context
import android.widget.TextView

import groovy.transform.CompileStatic

import net.typeblog.grooido.dsl.BaseView
import net.typeblog.grooido.dsl.BaseLayoutParams

/*
 * Wrapper class of android.widget.TextView.
 * Available as delegates.
 */
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

	/*
	 * Set the text of this view.
	 * @param t The text.
	 */
	def text(String t) {
		mTextView.text = t
	}

	/*
	 * Set the text of this view from resource.
	 * @param id The resource id.
	 */
	def text(int id) {
		mTextView.text = id
	}

	// TODO Finish this class
}
