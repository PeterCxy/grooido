Grooido
---
This is the Grooido library under heavy development.
The Grooido library aims to free you from Android layout XMLs (which is too verbose) and you will be able to create Android layouts like
```groovy
@Override
@CompileDynamic
void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState)

	content (this) {
		orientation vertical

		textView {
			text 'Hello'

			layout {
				width wrapContent
				height wrapContent
				gravity centerHorizontal
			}
		}

		linearLayout {
			orientation horizontal

			layout {
				width matchParent
				height wrapContent
				gravity centerVertical
			}

			mButton = button {
				...
			}

			...
		}
		
		...
	}
}
```

Note that this project is started __just for fun__ and is still under heavy development and fully __undocumented__.
Do not try to use it in production.

Collaboration
---
I am currently a Grade 12 student in China and do not have much time for it.
Unfortunately, making an UI library takes a lot of time for constructing wrapper classes for every possible View.
If you are interested in this project, contact me via Issue or E-mail to take part in this project.
