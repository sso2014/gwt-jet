/*
 * gwt-jet 
 * 
 * Widgets wrapping objects with reflection autopopulation for fast coding
 * 
 * The gwt-jet library provides a fast, flexible and easy way to wrap business 
 * objects that you want to show at the front-end. The jet classes automatically 
 * create the corresponding widget and automagically populate the user modified 
 * values into the original object.
 * 
 * gwt-jet was created by
 * Silvana Muzzopappa & Federico Pugnali
 * (c)2011 - Apache 2.0 license
 * 
 */
package ar.com.kyol.jet.client.wrappers;

import com.google.gwt.user.client.ui.Label;

public class NullWrapper extends Wrapper {

	/**
	 * Instantiates a new null wrapper.
	 *
	 * @param useValueAsString the use value as string
	 */
	public NullWrapper(boolean useValueAsString) {
		super(useValueAsString);
		initWidget(new Label(""));
	}

	@Override
	protected String getValueAsString() {
		return "";
	}

}
