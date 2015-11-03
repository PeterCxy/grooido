package net.typeblog.grooido.dsl

import android.content.Context
import android.view.ViewGroup.LayoutParams as LP

import groovy.transform.CompileStatic

@CompileStatic
trait Dimens {
	String getDp() {
		'dp'
	}

	String getPx() {
		'px'
	}

	String getDimen() {
		'dimen'
	}

	Map makeDimenStub(Context context, int dimen, Closure cl) {
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
							cl((int) (dimen * context.resources.displayMetrics.density))
							break
						case 'dimen':
							cl((int) context.resources.getDimension(dimen))
							break
					}
				}
			]
		}
	}

}
