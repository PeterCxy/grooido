package net.typeblog.grooido.dsl

import static android.view.Gravity.*;

import groovy.transform.CompileStatic

/*
 * Wrapper of Gravity
 * So you could use something like
 * layoutParams {
 * 	gravity center()
 * }
 */
@CompileStatic
trait Gravity {
	int getCenter() {
		CENTER
	}

	int getCenterVertical() {
		CENTER_VERTICAL
	}

	int getCenterHorizontal() {
		CENTER_HORIZONTAL
	}
}
