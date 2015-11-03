package net.typeblog.grooido.dsl

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams as LP

import groovy.transform.CompileStatic

/*
 * Base wrapper class for LayoutParams.
 * Only for being delegates. (including its subclasses)
 */
@CompileStatic
abstract class BaseLayoutParams<T extends LP> implements Dimens {
	protected final T mParams
	protected float mDensity
	protected Context mContext

	BaseLayoutParams(Context context, T params) {
		mParams = params
		mDensity = context.resources.displayMetrics.density
		mContext = context
	}

	BaseLayoutParams(Context context, Class<T> clazz) {
		try {
			mParams = clazz.newInstance(LP.WRAP_CONTENT, LP.WRAP_CONTENT)
			mDensity = context.resources.displayMetrics.density
			mContext = context
		} catch (any) {
			throw new RuntimeException('Cannot create LayoutParams')
		}
	}

	/*
	 * Set the width.
	 * Special values: matchParent and wrapContent. Both are properties of this class. (Directly available in the caller Closure)
	 * @param w The width
	 * @return An object with a method 'of(String unit)'. The method must be called to apply the value except you are using special values. See net.typeblog.grooido.dsl.Dimensions for available units.
	 * 	This class implements Dimensions so all dimensions are properties of this class.
	 */
	def width(int w) {
		return makeDimenStub(w) { int d ->
			mParams.width = d
		}
	}

	/*
	 * Set the height.
	 * Special values: same as in width()
	 * @param h The height
	 * @return Same as width()
	 */
	def height(int h) {
		return makeDimenStub(h) { int d ->
			mParams.height = d
		}
	}

	void apply(View v) {
		v.layoutParams = mParams
	}

	LP getParams() {
		return mParams
	}

	int getMatchParent() {
		LP.MATCH_PARENT
	}

	int getWrapContent() {
		LP.WRAP_CONTENT
	}

	protected Map makeDimenStub(int dimen, Closure cl) {
		if (dimen in [LP.MATCH_PARENT, LP.WRAP_CONTENT]) {
			cl(dimen)
			return null
		} else {
			return [
				of: { String unit ->
					switch (unit) {
						case 'px':
							cl(dimen)
							break
						case 'dp':
							cl((int) (dimen * mDensity))
							break
						case 'dimen':
							cl((int) mContext.resources.getDimension(dimen))
							break
					}
				}
			]
		}
	}
}
