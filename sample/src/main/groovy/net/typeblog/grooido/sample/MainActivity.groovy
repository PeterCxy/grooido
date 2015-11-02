package net.typeblog.grooido.sample

import android.app.Activity
import android.os.Bundle

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

import net.typeblog.grooido.sample.R
import static net.typeblog.grooido.Grooido.*

@CompileStatic
class MainActivity extends Activity {
	// The method where layout is defined cannot be compiled statically
	@Override
	@CompileDynamic
	void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState)
		content (this) {
			orientation vertical

			textView {
				text R.string.hello

				layout {
					width matchParent
					height wrapContent
				}
			}

			textView {
				text R.string.centered

				layout {
					width wrapContent
					height wrapContent
					gravity centerHorizontal
				}
			}

			textView {
				text R.string.twdp

				layout {
					width 20 of dp
					height wrapContent
				}
			}

			textView {
				text R.string.twpx

				layout {
					width 20 of px
					height wrapContent
					gravity centerHorizontal
				}
			}
		}
	}
}
