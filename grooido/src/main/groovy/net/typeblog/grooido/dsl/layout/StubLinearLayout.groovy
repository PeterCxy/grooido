package net.typeblog.grooido.dsl.layout

import android.content.Context
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams as LP

import groovy.transform.CompileStatic

import net.typeblog.grooido.dsl.BaseViewGroup
import net.typeblog.grooido.dsl.BaseLayoutParams
import net.typeblog.grooido.dsl.Gravity

/*
 * Wrapper class of android.widget.LinearLayout.
 * Available as delegates to Closures.
 */
@CompileStatic
class StubLinearLayout<L extends BaseLayoutParams> extends BaseViewGroup<LinearLayout, L, StubLinearLayout.LayoutParams> {
	private LinearLayout mLayout

	/*
	 * Wrapper class of android.widget.LinearLayout.LayoutParams
	 */
	@CompileStatic
	static class LayoutParams extends BaseLayoutParams<LP> implements Gravity {
		LayoutParams(Context context, LP params) {
			super(context, params)
		}

		LayoutParams(Context context) {
			super(context, LP.class)
		}

		/*
		 * Set the gravity.
		 * See trait net.typeblog.groodo.dsl.Gravity for available gravities.
		 * This class implements the trait so all gravities are properties of this class and available directly in caller closures.
		 * @param gravity The Gravity
		 */
		def gravity(int gravity) {
			mParams.gravity = gravity
		}
	}

	StubLinearLayout(LinearLayout ll, L lp) {
		super(ll, lp, LayoutParams.class)
		mLayout = mView as LinearLayout
	}

	StubLinearLayout(Context context, Class<L> clazz) {
		super(context, LinearLayout.class, clazz, LayoutParams.class)
		mLayout = mView as LinearLayout
	}

	/*
	 * Set the orientation of this layout.
	 * @param o The orientation (horizontal or vertical)
	 */
	def orientation(int o) {
		mLayout.orientation = o
	}

	def getHorizontal() {
		LinearLayout.HORIZONTAL
	}

	def getVertical() {
		LinearLayout.VERTICAL
	}

	// TODO Finish this class
}
