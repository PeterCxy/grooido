package net.typeblog.grooido.dsl

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
}
