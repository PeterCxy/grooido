package net.typeblog.grooido

import android.app.Activity
import android.content.Context
import android.widget.LinearLayout

import groovy.transform.CompileStatic

import net.typeblog.grooido.dsl.layout.StubLinearLayout
import net.typeblog.grooido.dsl.layout.StubLinearLayout.LayoutParams as LP

/*
 * Main class of Grooido.
 * Contains only static methods. 'import static' is preferred
 */
@CompileStatic
class Grooido {
	static LinearLayout layout(Context context, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = StubLinearLayout) Closure cl) {
		def ll = new StubLinearLayout<LP>(context, LP.class)
		cl.delegate = ll
		cl.resolveStrategy = Closure.DELEGATE_FIRST
		cl()
		ll.view
	}

	static LinearLayout content(Activity activity, @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StubLinearLayout) Closure cl) {
		def l = layout(activity, cl)
		activity.contentView = l
		l
	}
}
