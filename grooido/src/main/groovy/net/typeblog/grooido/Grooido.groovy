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

	/*
	 * Creates the root layout.
	 * The root layout is a LinearLayout by default.
	 * Views and layouts are creatable inside the Closure.
	 * Can only be called from a dynamic context.
	 * See net.typeblog.grooido.dsl.layout.StubLinearLayout and other classes under net.typeblog.grooido.dsl for callable methods inside the closure.
	 * @param context The context
	 * @param cl A closure whose delegate will be set to a StubLinearLayout
	 * @return The created layout
	 */
	static LinearLayout layout(Context context, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = StubLinearLayout) Closure cl) {
		def ll = new StubLinearLayout<LP>(context, LP.class)
		cl.delegate = ll
		cl.resolveStrategy = Closure.DELEGATE_FIRST
		cl()
		ll.view
	}

	/*
	 * Short of activity.setContentView(layout(Activity, Closure))
	 */
	static LinearLayout content(Activity activity, @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StubLinearLayout) Closure cl) {
		def l = layout(activity, cl)
		activity.contentView = l
		l
	}
}
