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

	int getBottom() {
		BOTTOM
	}

	int getTop() {
		TOP
	}

	int getLeft() {
		LEFT
	}

	int getRight() {
		RIGHT
	}

	int getStart() {
		START
	}

	int getEnd() {
		END
	}

	int getFill() {
		FILL
	}

	int getFillHorizontal() {
		FILL_HORIZONTAL
	}

	int getFillVertical() {
		FILL_VERTICAL
	}

	// TODO Finish this class
}
