package pl.dmcs.mww.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.dmcs.mww.model.Address;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Address.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "street", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "houseNo", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "city", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "country", "error.field.required");
		ValidationUtils.rejectIfEmpty(errors, "postalCode", "error.field.required");

		if (errors.getErrorCount() == 0) {
			if(StringUtils.hasText(((Address)arg0).getPostalCode())) {
				Pattern postalCodePattern = Pattern.compile(
						"\\d\\d-\\d\\d\\d",
						Pattern.CASE_INSENSITIVE);
				Matcher postalCodeMatcher = postalCodePattern.matcher(((Address)arg0).getPostalCode());
				if(!postalCodeMatcher.matches()) {
					errors.rejectValue("postalCode","error.postalCode.invalid");
				}
			}
		}
	}

}