package com.sample.talkingclock.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@SpringBootTest
public class AppExceptionHandlerTest {

	
	private final AppExceptionHandler handler = new AppExceptionHandler();

    @Test
    void test() throws BusinessException {

    	BusinessException businessException= new BusinessException(HttpStatus.BAD_REQUEST, "Bad Request", "Bad Request");
        final ResponseEntity<?> handled = handler.handleAppException(businessException,
                null);
        assertEquals(400, handled.getStatusCode().value());
    }
    
    @Test
    void testValidation() throws BusinessException {

    	BindingResult binding=new BindingResult() {
			
			@Override
			public void setNestedPath(String nestedPath) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rejectValue(String field, String errorCode, String defaultMessage) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void rejectValue(String field, String errorCode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void reject(String errorCode, String defaultMessage) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void reject(String errorCode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void pushNestedPath(String subPath) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void popNestedPath() throws IllegalStateException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean hasGlobalErrors() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean hasFieldErrors(String field) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean hasFieldErrors() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean hasErrors() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String getObjectName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getNestedPath() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<ObjectError> getGlobalErrors() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getGlobalErrorCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public ObjectError getGlobalError() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getFieldValue(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Class<?> getFieldType(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<FieldError> getFieldErrors(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<FieldError> getFieldErrors() {
				// TODO Auto-generated method stub
				List<FieldError> list=new ArrayList<>();
				list.add(new FieldError("Error1", "Error1","Error1"));
				return list;
			}
			
			@Override
			public int getFieldErrorCount(String field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getFieldErrorCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public FieldError getFieldError(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FieldError getFieldError() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getErrorCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public List<ObjectError> getAllErrors() {
				List<ObjectError> list=new ArrayList<>();
				list.add(new ObjectError("Error1", "ErrorMessage1"));
				return list;
			}
			
			@Override
			public void addAllErrors(Errors errors) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String[] resolveMessageCodes(String errorCode, String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] resolveMessageCodes(String errorCode) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getTarget() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getRawFieldValue(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public PropertyEditorRegistry getPropertyEditorRegistry() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Map<String, Object> getModel() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public PropertyEditor findEditor(String field, Class<?> valueType) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addError(ObjectError error) {
				// TODO Auto-generated method stub
				new ObjectError("Error1", "ErrorMessage1");
			}
		};
    	MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, binding);
        ResponseEntity<?> handled = handler.handleMethodArgumentNotValid(ex, null, HttpStatus.BAD_REQUEST, null);
        assertEquals(400, handled.getStatusCode().value());
    }
	
}
