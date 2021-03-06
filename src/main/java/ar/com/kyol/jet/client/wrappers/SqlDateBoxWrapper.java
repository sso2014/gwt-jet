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

import java.util.Date;

import ar.com.kyol.jet.client.ObjectSetter;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.DateBox;

public class SqlDateBoxWrapper extends Wrapper {
	
	private java.sql.Date date;
	private DateBox dateBox;
	
	/**
	 * Instantiates a new sql date box wrapper.
	 *
	 * @param date the date
	 */
	public SqlDateBoxWrapper(java.sql.Date date, ObjectSetter objSetter) {
		this(date, new DateBox(), objSetter);
	}
	
	/**
	 * Instantiates a new sql date box wrapper.
	 *
	 * @param date the date
	 * @param dateBox the date box
	 */
	public SqlDateBoxWrapper(java.sql.Date date, DateBox dateBox, ObjectSetter objSetter) {
		this(date, dateBox, false, objSetter);
	}
	
	/**
	 * Instantiates a new sql date box wrapper.
	 *
	 * @param date the date
	 * @param dateBox the date box
	 * @param useValueAsString the use value as string
	 */
	public SqlDateBoxWrapper(java.sql.Date date, DateBox dateBox, boolean useValueAsString, ObjectSetter objSetter) {
		super(useValueAsString);
		this.dateBox = dateBox;
		this.objSetter = objSetter;
		if(date!=null){
			this.date = new java.sql.Date(date.getTime());
		}
		dateBox.setValue(this.date);
		String format = "dd/MM/yyyy";
		if(objSetter.getFormat() != null && !objSetter.getFormat().equals("")) {
			format = objSetter.getFormat();
		}
		dateBox.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat(format)));
		
		dateBox.addValueChangeHandler(new ValueChangeHandler<Date>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Date> arg0) {
				java.util.Date date = SqlDateBoxWrapper.this.dateBox.getValue();
				setProperty(new java.sql.Date(date.getTime()));
			}
		});
		
		initWidget(dateBox);
	}

	@Override
	protected String getValueAsString() {
		return this.dateBox.getValue().toString();
	}

}
