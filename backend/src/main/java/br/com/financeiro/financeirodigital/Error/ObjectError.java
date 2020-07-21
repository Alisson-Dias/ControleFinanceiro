package br.com.financeiro.financeirodigital.Error;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ObjectError {

	 	private final String message;
	    private final String field;
	    private final Object parameter;
		    
	    public ObjectError(String message, int i, String field, Object parameter, List<ObjectError> errors) {
	
			this.message = message;
			this.field = field;
			this.parameter = parameter;
		}
	     
		public String getMessage() {
			return message;
		}
		public String getField() {
			return field;
		}
		public Object getParameter() {
			return parameter;
		}


}
